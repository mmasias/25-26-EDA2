# Reto de Recuperación - Trazas de Algoritmos de Ordenación

**Array de prueba:** `{5, 2, 8, 1, 9, 3}`

## Objetivo
Enriquecer las implementaciones de **Insertion Sort**, **Merge Sort** y **Quick Sort** con trazas para poder reconstruir completamente su ejecución mediante la salida por consola.

## Requisitos Cumplidos
- Estado inicial y final del array.
- Cada comparación relevante registrada.
- Cada modificación del array (desplazamientos, intercambios, fusiones).
- Indentación según profundidad de recursión.
- Casos base explícitos.
- **No he modificó la lógica original** de ningún algoritmo.

## Algoritmos Implementados

### Insertion Sort
- **Iterativo**: Trazas de cada pasada, comparación y desplazamiento.
- **Recursivo**: Trazas con indentación según nivel de recursión.

### Merge Sort
- **Recursivo**: División del array + proceso completo de fusión.
- **Iterativo**: Fusiones por tamaños crecientes.

### Quick Sort
- **Recursivo**: Selección de pivote, partición completa y recursión.

## Métodos Auxiliares
- `printArray()` → Muestra estado del array.
- `printIndented()` → Mensajes con indentación por nivel de recursión.

## Conclusión
Se cumplen todos los requisitos del enunciado. La salida por consola permite seguir paso a paso el funcionamiento interno de cada algoritmo sin alterar su lógica original.
