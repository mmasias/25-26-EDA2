# Explicación del Reto: Trazas de Algoritmos de Ordenación

## Algoritmos Implementados

### 1. Insertion Sort (Ordenación por Inserción)
- **Versión Iterativa**: Muestra el progreso por cada iteración. En cada iteración, selecciona un elemento y lo desplaza hacia la izquierda hasta encontrar su posición correcta. Se registran todas las comparaciones y desplazamientos.
- **Versión Recursiva**: Logra el mismo objetivo pero reduciendo el problema al tamaño `n-1` recursivamente. La profundidad de la recursión se refleja de manera visual en la salida a consola gracias al uso de indentación proporcional.

### 2. Merge Sort (Ordenación por Mezcla)
- **Versión Recursiva**: Basado en el paradigma "Divide y Vencerás". La traza muestra cómo el array original se va dividiendo a la mitad repetidamente, alcanzando los casos base (sub-arrays de tamaño 1), y luego muestra la fusión ordenada paso a paso registrando de qué mitad (izquierda o derecha) se toman los valores.
- **Versión Iterativa (Bottom-up)**: Realiza la fusión en bloques (tamaño 1, 2, 4, 8...). Se traza el estado del array antes y después de fusionar cada bloque.

### 3. Quick Sort (Ordenación Rápida)
- Utiliza la técnica de particionamiento. La implementación elige el último elemento de la porción correspondiente como `pivote`. 
- La traza expone todas las comparaciones de cada elemento con el pivote, los intercambios realizados y, finalmente, la colocación definitiva del pivote dividiendo el sub-array en dos nuevas regiones. El nivel de indentación marca la profundidad de la división recursiva.

## Requisitos de Traza Cumplidos
1. **Estado inicial y final**: Se imprimen siempre antes de iniciar la primera llamada y al concluir por completo.
2. **Decisiones relevantes**: Toda comparación (como `<` o `>`) que desencadena una acción se notifica por consola (Ej. `→ VERDADERO → desplazar...`).
3. **Modificaciones del array**: Cada cambio o intercambio actualiza y muestra el sub-array resultante.
4. **Profundidad de recursión**: Gestionada a través de un contador estático `depth` que inyecta espacios en blanco (`"  ".repeat(depth)`).
5. **Casos Base**: Explícitamente denotados en la consola con la etiqueta `[CASO BASE]`.
6. **Array de Prueba Único**: Las pruebas principales están configuradas para ejecutarse con `{5, 2, 8, 1, 9, 3}` según las especificaciones.

## Conclusión
Sin alterar la lógica original de ordenamiento, la instrumentación del código ha proporcionado una herramienta exhaustiva que permite entender de forma determinista la evolución interna de cada estructura de datos.
