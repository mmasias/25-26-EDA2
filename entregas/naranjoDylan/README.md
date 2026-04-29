# Reto de recuperacion - Trazas de algoritmos

> Entrega centrada en reconstruir la ejecucion de algoritmos de ordenacion a partir de la salida por consola.

## Autor

**Naranjo Dylan**  
Grado en Ingenieria Informatica - Universidad Europea del Atlantico

---

## Descripcion

En este reto se enriquecen con trazas detalladas tres algoritmos clasicos de ordenacion:

- **Insertion Sort** (iterativo y recursivo)
- **Merge Sort** (recursivo e iterativo)
- **Quick Sort**

El objetivo es que la salida por consola permita reconstruir las decisiones, comparaciones y transformaciones realizadas sobre el array hasta llegar al resultado ordenado.

---

## Estructura del proyecto

```text
naranjoDylan/
|-- README.md
|-- src/
|   |-- AppOrdenamientos.java
|   |-- InsertionSort.java
|   |-- MergeSort.java
|   |-- QuickSort.java
|   `-- ConsolaTraza.java
|-- modelosUML/
|   `-- diagramaClases.puml
|-- docs/
|   `-- explicacion.md
`-- images/
```

---

## Modelos UML

El modelo UML de clases se encuentra en:

- `modelosUML/diagramaClases.puml`

Este diagrama muestra el reparto de responsabilidades entre el punto de entrada, las clases de algoritmos y la utilidad de trazas.

---

## Documentacion

La explicacion tecnica de la solucion se encuentra en:

- `docs/explicacion.md`

---

## Array de prueba

Todas las ejecuciones usan el array exigido por el enunciado:

```java
int[] array = {5, 2, 8, 1, 9, 3};
```




