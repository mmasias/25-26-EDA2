# Búsqueda en Matriz Ordenada

## Propuesta

La matriz está ordenada de izquierda a derecha y de arriba hacia abajo.  
La propuesta consiste en comenzar desde la esquina superior derecha.

- Si el número buscado es menor, se mueve a la izquierda.
- Si el número buscado es mayor, se baja.
- Si son iguales, el elemento fue encontrado.

Con esto se elimina una fila o una columna en cada comparación.

## Ejemplo buscando 22

21 ↓  
25 ←  
17 ↓  
20 ↓  
30 ←  
27 ←  
22 ✓

## Complejidad

- Mejor caso: 1 comparación.
- Peor caso: n + m - 1 comparaciones.

Para una matriz 5x5:

9 comparaciones en el peor caso.
