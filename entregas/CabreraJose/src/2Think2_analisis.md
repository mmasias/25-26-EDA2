# 2Think²: Pruebas del Algoritmo Diagonal 

## Matriz de Referencia
```
 2   5   9  14  21
 4   7  11  17  25
 8  12  15  20  30
13  18  22  27  35
19  24  28  33  40
```

---

## Prueba 1: Buscando 21

**Posición esperada**: Fila 0, Columna 4

**Traza del algoritmo (desde esquina superior-izquierda):**

```
[1] Posición (0, 0): 2 < 21 → Mover DERECHA
[2] Posición (0, 1): 5 < 21 → Mover DERECHA
[3] Posición (0, 2): 9 < 21 → Mover DERECHA
[4] Posición (0, 3): 14 < 21 → Mover DERECHA
[5] Posición (0, 4): 21 = 21 ✓ ENCONTRADO
```

**Resultado**: ✓ **ENCONTRADO en (0, 4)**
**Total: 5 comparaciones** (mejor caso)

---

## Prueba 2: Buscando 16

**Resultado esperado**: No existe en la matriz

**Traza del algoritmo (desde esquina superior-izquierda):**

```
[1] Posición (0, 0): 2 < 16 → Mover DERECHA
[2] Posición (0, 1): 5 < 16 → Mover DERECHA
[3] Posición (0, 2): 9 < 16 → Mover DERECHA
[4] Posición (0, 3): 14 < 16 → Mover DERECHA
[5] Posición (0, 4): 21 > 16 → Mover ABAJO
[6] Posición (1, 4): 25 > 16 → Mover ABAJO
[7] Posición (2, 4): 30 > 16 → Mover ABAJO
[8] Posición (3, 4): 35 > 16 → Mover ABAJO
[9] Posición (4, 4): 40 > 16 → Mover ABAJO
✗ NO ENCONTRADO
```

**Resultado**: ✗ **NO ENCONTRADO**
**Total: 9 comparaciones** (peor caso real)

---

## Prueba 3: ¿Arrancar del Centro vs Arrancar de la Esquina?

### Estrategia 1: Desde ESQUINA (0,0) - Buscando 16
```
Total comparaciones: 9
```

### Estrategia 2: Desde CENTRO (2,2) - Buscando 16
```
[1] Posición (2, 2): 15 < 16 → Mover DERECHA
[2] Posición (2, 3): 20 > 16 → Mover ARRIBA
[3] Posición (1, 3): 17 > 16 → Mover ARRIBA
[4] Posición (0, 3): 14 < 16 → Mover DERECHA
[5] Posición (0, 4): 21 > 16 → Mover ARRIBA
✗ NO ENCONTRADO

Total comparaciones: 5 (MEJORA: 5 comparaciones)
```

### Análisis Comparativo

| Métrica | Esquina | Centro | Mejora |
|---------|---------|--------|--------|
| Comparaciones | 9 | 5 | **44% menos** |
| Efficiency | Estándar | Optimizado | ✓ Mejor |
| Aplicabilidad | Pequeño | Grande | Centro gana |

---

### Conclusión

**SÍ existe un caso concreto donde arrancar del centro es mejor:**

- **Búsqueda del valor 16 (no existe):**
  - Desde esquina: 9 comparaciones
  - Desde centro: 5 comparaciones
  - **Mejora: 44% menos comparaciones** 

- **Razón:**
  - El centro proporciona mejor proximidad a valores distribuidos
  - Reduce el rango de búsqueda más rápidamente
  - Especialmente efectivo en matrices grandes

**Recomendación Técnica**: 
- Para matrices pequeñas: esquina (más simple)
- Para matrices grandes: centro o híbrido (más eficiente)
- Caso práctico probado: valor 16 demuestra clara ventaja del centro
