# Modelos UML

Esta carpeta contiene el código fuente del diagrama de clases en formato PlantUML (`Algoritmos_Ordenacion.puml`).

Como GitHub no renderiza directamente los archivos `.puml`, a continuación se incluye el mismo diagrama en formato **Mermaid**, el cual se visualiza automáticamente aquí:

```mermaid
classDiagram
    class InsertionSort {
        -int depth$
        -arrToString(arr: int[])$ String
        -printIndent(depth: int)$ void
        +ordenar(array: int[])$ void
        +ordenar(array: int[], n: int)$ void
    }

    class MergeSort {
        -int depth$
        -arrToString(arr: int[])$ String
        -subArrToString(arr: int[], ini: int, fin: int)$ String
        -printIndent()$ void
        -fusionar(array: int[], izquierda: int, medio: int, derecha: int)$ void
        +ordenar(array: int[], izquierda: int, derecha: int)$ void
        +ordenarIterativo(array: int[])$ void
    }

    class QuickSort {
        -int depth$
        -arrToString(arr: int[])$ String
        -subArrToString(arr: int[], ini: int, fin: int)$ String
        -printIndent()$ void
        -particionar(array: int[], izquierda: int, derecha: int)$ int
        +ordenar(array: int[], izquierda: int, derecha: int)$ void
    }
```
