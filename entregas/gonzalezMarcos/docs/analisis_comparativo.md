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

Con tres llamadas recursivas sobre cuatro cuadrantes (cada uno de tamaño N/2 × M/2), la recurrencia es:

```
T(N) = 3 · T(N/2) + O(1)
```

Por el **Teorema Maestro** (caso 1, a=3, b=2, f(N)=O(1)):

```
T(N) = O(N^(log₂ 3)) ≈ O(N^1.58)
```

| Caso | Comparaciones | Complejidad |
|---|---|---|
| **Mejor** | 1 — `k` es el pivote inicial | O(1) |
| **Peor** | ∝ N^1.58 — se exploran tres cuadrantes en cada nivel | O(N^log₂3) |

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
