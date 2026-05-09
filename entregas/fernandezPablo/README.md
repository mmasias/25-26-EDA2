#  Búsqueda en Matriz Ordenada: Algoritmo "Atrapar al Ratón"

Este proyecto implementa una solución eficiente en **Java** para buscar un número objetivo (`k`) dentro de una matriz bidimensional con propiedades de ordenación específicas.

El algoritmo diseñado minimiza el número de comparaciones utilizando una combinación de **Divide y Vencerás** (para el descarte masivo de datos) y **Backtracking** (para la exploración de rutas alternativas).

---

##  Naturaleza del Problema

Se nos proporciona una matriz `N x M` con la siguiente restricción:
1. Los valores de cada fila crecen de izquierda a derecha.
2. Los valores de cada columna crecen de arriba a abajo.

**Ejemplo de la matriz:**
```text
  2   5   9  14  21
  4   7  11  17  25
  8  12  15  20  30
 13  18  22  27  35
 19  24  28  33  40