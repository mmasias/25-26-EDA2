# Análisis Comparativo: Búsqueda por Eliminación vs. Divide y Vencerás

> **Por qué es correcto, pero peor que la solución escogida.**

> → [Volver al README principal](../README.md)

---

## 1. La Estrategia

La idea parte de aplicar el paradigma de **Divide y Vencerás** a la búsqueda en una matriz ordenada, eligiendo siempre la **celda central** como pivote:

1. Tomar la celda central de la submatriz actual como pivote `M`.
2. Si `k == M` → encontrado.
3. Si `k < M` → el cuadrante inferior derecho queda descartado (todos sus valores son mayores que `M`, y por tanto mayores que `k`). Se lanzan **tres llamadas recursivas** sobre los cuadrantes restantes: superior izquierdo, superior derecho e inferior izquierdo.
4. Si `k > M` → el cuadrante superior izquierdo queda descartado. Se lanzan **tres llamadas recursivas** sobre: inferior derecho, superior derecho e inferior izquierdo.


### Por qué se descartan solo cuadrantes opuestos

La ordenación por filas y columnas garantiza que, tomando el pivote central:

```
┌──────────────┬──────────────┐
│  valores <M  │  ambiguos    │
│  (sup. izq.) │  (sup. der.) │
├──────────────┼──────────────┤
│  ambiguos    │  valores >M  │
│  (inf. izq.) │  (inf. der.) │
└──────────────┴──────────────┘
```

Solo los cuadrantes **diagonal al pivote** pueden descartarse con certeza. Los otros dos son ambiguos: pueden contener tanto valores menores como mayores que `M`, por lo que ambos deben explorarse siempre.

---

## 2. Análisis de Complejidad

### Paso 1 — Cuántas llamadas se hacen en cada nivel

En cada llamada, el algoritmo divide la submatriz en cuatro cuadrantes iguales (cada uno de tamaño N/2 × N/2) y solo puede descartar uno de ellos con certeza. Por tanto, siempre lanza **3 llamadas recursivas** sobre los otros tres.

Esto define la siguiente **recurrencia**:

```
T(N) = 3 · T(N/2) + O(1)
       ─────────────────────
       │      │         │
       │      │         └── trabajo hecho en este nivel (solo la comparación con el pivote)
       │      └──────────── cada llamada trabaja sobre una submatriz de la mitad del tamaño
       └─────────────────── se hacen 3 llamadas recursivas
```

### Paso 2 — Cuántos niveles tiene la recursión

La submatriz se divide por la mitad en cada nivel. Partiendo de tamaño N, los niveles son:

```
Nivel 0 → submatriz de tamaño N
Nivel 1 → submatriz de tamaño N/2
Nivel 2 → submatriz de tamaño N/4
  ...
Nivel k → submatriz de tamaño N/2^k
```

La recursión para cuando la submatriz tiene tamaño 1 (un único elemento):

```
N / 2^k = 1  →  k = log₂(N)
```

Es decir, hay **log₂(N) niveles** en total.

### Paso 3 — Cuánto trabajo se hace en total

En cada nivel `i` existen `3^i` subproblemas activos, y cada uno hace O(1) trabajo (solo comparar con el pivote). El trabajo total es la suma de todos los niveles:

```
Total = 3^0 + 3^1 + 3^2 + ... + 3^(log₂N)
      = suma de una serie geométrica de razón 3
      = O(3^(log₂N))
```

Usando la identidad matemática `a^(log_b N) = N^(log_b a)`:

```
3^(log₂N) = N^(log₂3)
```

Como `log₂(3) ≈ 1.585`, la complejidad final es:

```
T(N) = O(N^1.58)
```

### Paso 4 — Aplicación del Teorema Maestro (verificación)

La forma general del Teorema Maestro es `T(N) = a·T(N/b) + f(N)`.

| Parámetro | Valor | Origen |
|---|---|---|
| `a = 3` | nº de llamadas recursivas | se descartan 3 cuadrantes de 4 |
| `b = 2` | factor de reducción del tamaño | cada cuadrante es la mitad |
| `f(N) = O(1)` | trabajo fuera de la recursión | solo una comparación con el pivote |
| `N^(log_b a) = N^(log₂3) ≈ N^1.58` | término dominante | crece más rápido que f(N)=O(1) |

Como `f(N) = O(1)` es asintóticamente menor que `N^1.58`, se aplica el **caso 1** del Teorema Maestro:

```
T(N) = Θ(N^(log₂3)) ≈ Θ(N^1.58)
```

### Resumen de casos

| Caso | Situación | Complejidad |
|---|---|---|
| **Mejor** | `k` coincide con el primer pivote | O(1) |
| **Peor** | `k` no existe o está en la última hoja explorada | O(N^1.58) |

---

## 3. Comparación entre algoritmos

| Criterio | Busqueda por eliminación | Divide y Vencerás |
|---|---|---|
| **Complejidad peor caso** | **O(N + M)** | O(N^1.58) |
| **Comparaciones (matriz 5×5)** | **máx. 9** | más de 9 en muchos casos |
| **Overhead de gestión** | Ninguno — bucle simple | Pila de llamadas recursivas |
| **Uso de memoria** | O(1) | O(log N) |

Para la matriz del reto (5×5), busqueda por eliminación necesita como máximo **9 comparaciones** recorriendo la frontera con un bucle sencillo. El enfoque de cuadrantes, al dividir en tres ramas recursivas en cada nivel, incurre en un overhead significativo y acaba evaluando más nodos en los casos desfavorables.

La clave está en qué **información se usa**:

- **Busqueda por eliminación** aprovecha el orden de forma global: desde la esquina, cada comparación garantiza el descarte de una fila o columna completa, sin ambigüedad.
- **D&C** solo aprovecha el orden de forma local respecto al pivote: descarta un cuadrante, pero debe explorar tres, introduciendo trabajo redundante.

→ [Volver a la solución original](../README.md)
