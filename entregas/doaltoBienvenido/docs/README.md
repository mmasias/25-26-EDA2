# Búsqueda en Matriz Ordenada

Este proyecto implementa un algoritmo eficiente para encontrar un valor en una matriz donde tanto las filas como las columnas están ordenadas de forma ascendente.

## Planteamiento de la Solución

El algoritmo elegido empieza en la **esquina inferior izquierda** de la matriz. Esta posición es clave porque:
- El elemento de arriba es menor.
- El elemento de la derecha es mayor.

### Algoritmo paso a paso
1. Comparamos el valor actual con el buscado ($k$).
2. Si son iguales, hemos terminado.
3. Si el valor actual es **menor** que $k$, nos movemos a la **derecha** (columna++).
4. Si el valor actual es **mayor** que $k$, nos movemos hacia **arriba** (fila--).
5. Repetimos hasta encontrarlo o salir de los límites.

## Trazas de Ejecución (Matriz 5x5)

### Buscando el valor 22
- (4,0) = 19. 19 < 22 -> Derecha
- (4,1) = 24. 24 > 22 -> Arriba
- (3,1) = 18. 18 < 22 -> Derecha
- (3,2) = 22. **¡Encontrado!** (4 comparaciones)

### Buscando el valor 21
- (4,0) = 19 -> Derecha
- (4,1) = 24 -> Arriba
- (3,1) = 18 -> Derecha
- (3,2) = 22 -> Arriba
- (2,2) = 15 -> Derecha
- (2,3) = 20 -> Derecha
- (2,4) = 30 -> Arriba
- (1,4) = 25 -> Arriba
- (0,4) = 21. **¡Encontrado!** (9 comparaciones)

### Buscando el valor 16
- (4,0) = 19 -> Arriba
- (3,0) = 13 -> Derecha
- (3,1) = 18 -> Arriba
- (2,1) = 12 -> Derecha
- (2,2) = 15 -> Derecha
- (2,3) = 20 -> Arriba
- (1,3) = 17 -> Arriba
- (0,3) = 14 -> Derecha
- (0,4) = 21 -> Arriba (Fuera de límites)
- **No existe** (9 comparaciones)

---

## Análisis de Complejidad

- **Mejor caso**: 1 comparación (si el valor está en la esquina de inicio).
- **Peor caso**: $N + M - 1$ comparaciones. Ocurre al buscar elementos en la esquina opuesta (ej: 21 o 40) o que no existen y obligan a recorrer el máximo camino posible.
- **¿Algoritmo mejor?**: No, para este tipo de matrices el coste mínimo es $O(N+M)$.

## Centro vs Esquina
Arrancar del centro no es mejor porque una comparación en el centro solo descarta un cuadrante (1/4 de la matriz), mientras que desde la esquina cada paso descarta una fila o columna completa de forma garantizada, manteniendo una lógica lineal simple y óptima.
