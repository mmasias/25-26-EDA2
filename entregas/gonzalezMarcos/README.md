# Reto 003 — Trazas de algoritmos de ordenación

**Autor:** Marcos González Hidalgo  
**Asignatura:** Estructura de Datos y Algoritmos II  
**Fecha:** 29/04/2026

## Descripción

Implementación de trazas detalladas para tres algoritmos de ordenación, permitiendo reconstruir la secuencia completa de decisiones y transformaciones que cada algoritmo realiza sobre el array hasta alcanzar el resultado ordenado.

## Array de prueba

```java
int[] array = {5, 2, 8, 1, 9, 3};
```

## Algoritmos implementados

| # | Algoritmo | Variantes | Archivo fuente | Documentación |
|---|-----------|-----------|----------------| ------------- | 
| 1 | **Insertion Sort** | Iterativo + Recursivo | [InsertionSortTraza.java](src/InsertionSortTraza.java) | [Insertion Sort — Análisis y traza completa](docs/insertion-sort.md) |
| 2 | **Merge Sort** | Recursivo + Iterativo | [MergeSortTraza.java](src/MergeSortTraza.java) | [Merge Sort — Análisis y traza completa](docs/merge-sort.md) |
| 3 | **Quick Sort** | Recursivo | [QuickSortTraza.java](src/QuickSortTraza.java) | [Quick Sort — Análisis y traza completa](docs/quick-sort.md) |

## Estructura del proyecto

```
gonzalezHidalgoMarcos/
├── README.md                          
├── src/
│   ├── Main.java                      ← Punto de entrada (ejecuta todos los algoritmos)
│   ├── InsertionSortTraza.java        ← Insertion Sort (iterativo y recursivo)
│   ├── MergeSortTraza.java            ← Merge Sort (recursivo e iterativo)
│   └── QuickSortTraza.java            ← Quick Sort
└── docs/
    ├── insertion-sort.md              
    ├── merge-sort.md                  
    └── quick-sort.md                  
```

## Requisitos de traza 

-  **Estado inicial y final** — Se muestra el array antes y después de cada algoritmo.
-  **Cada decisión relevante** — Todas las comparaciones quedan registradas con valores y resultado.
-  **Cada modificación del array** — Cada intercambio o desplazamiento muestra el array resultante.
-  **Profundidad de recursión visible** — Indentación proporcional al nivel de recursión.
-  **Identificación de casos base** — Señalización explícita de cuándo y por qué se alcanza un caso base.



