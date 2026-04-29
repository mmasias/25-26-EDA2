# Reto 003 — Trazas de Algoritmos de Ordenación

**Autor:** Sergio Puente  
**Asignatura:** Estructuras de Datos y Algoritmos II  
**Curso:** 2º Ingeniería Informática — Universidad Europea del Atlántico

---

## Objetivo

Enriquecer las implementaciones de referencia de **Insertion Sort**, **Merge Sort** y **Quick Sort** con instrucciones de traza que permitan reconstruir, exclusivamente desde la salida por consola, la secuencia completa de decisiones y transformaciones realizadas sobre el array hasta alcanzar el resultado ordenado.

**Restricción clave:** la lógica de ordenación no se modifica. Solo se añaden `System.out.println` y métodos auxiliares de soporte (formateo, indentación).

---

## Array de prueba

```java
int[] array = {5, 2, 8, 1, 9, 3};
```

---

## Estructura de la entrega

- [`/src`](./src) — Código fuente de los cinco algoritmos más el `Main`.
- [`/modelosUML`](./modelosUML) — Diagrama de clases en formato PlantUML.
- [`/images`](./images) — Diagramas exportados a imagen.
- [`/docs`](./docs) — Análisis comparativo de los algoritmos.

---

## Algoritmos implementados

| # | Algoritmo | Archivo |
|---|-----------|---------|
| 1 | Insertion Sort Iterativo | [`InsertionSortIterativo.java`](./src/InsertionSortIterativo.java) |
| 2 | Insertion Sort Recursivo | [`InsertionSortRecursivo.java`](./src/InsertionSortRecursivo.java) |
| 3 | Merge Sort Recursivo | [`MergeSortRecursivo.java`](./src/MergeSortRecursivo.java) |
| 4 | Merge Sort Iterativo | [`MergeSortIterativo.java`](./src/MergeSortIterativo.java) |
| 5 | Quick Sort | [`QuickSort.java`](./src/QuickSort.java) |

Punto de entrada único: [`Main.java`](./src/Main.java)

---

## Diseño de la traza

Toda traza incluye:

1. **Estado inicial y final** del array.
2. **Comparaciones relevantes**: valores comparados y resultado de la comparación.
3. **Modificaciones del array**: tras cada desplazamiento, intercambio o inserción se imprime el array resultante.
4. **Indentación proporcional al nivel de recursión** en algoritmos recursivos (cada nivel añade cuatro espacios).
5. **Identificación explícita de casos base** con etiqueta `CASO BASE`.

---

## Diagrama de clases

![Diagrama de clases](./images/diagramaClases.png)

Fuente: [`diagramaClases.puml`](./modelosUML/diagramaClases.puml)

---

## Documentación adicional

- [Análisis comparativo de los algoritmos](./docs/analisis.md)

---

## Cómo ejecutar

Desde la carpeta `/src`:

```bash
javac *.java
java Main
```

La salida muestra, en orden, la traza completa de los cinco algoritmos sobre el array de prueba.