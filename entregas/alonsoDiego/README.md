# Memoria de Entrega: Reto de Recuperación 

Este documento detalla el trabajo realizado para la implementación de las trazas de ejecución sobre los algoritmos de ordenación solicitados. El objetivo ha sido proporcionar una visibilidad total sobre el funcionamiento interno de cada algoritmo sin alterar su lógica original.

## 1. Algoritmos Incluidos
Se han implementado y enriquecido con trazas los siguientes algoritmos:
* **Insertion Sort:** Versiones iterativa y recursiva.
* **Merge Sort:** Versiones recursiva e iterativa.
* **Quick Sort:** Versión recursiva basada en partición.

## 2. Cumplimiento de los Requisitos de Traza
Para asegurar una reconstrucción completa de la ejecución desde la consola, se han integrado los siguientes elementos:

* **Estado Inicial y Final:** Cada ejecución comienza mostrando el array desordenado `{5, 2, 8, 1, 9, 3}` y finaliza con el array ordenado.
* **Registro de Decisiones:** Se han documentado todas las comparaciones críticas. Por ejemplo, en *Quick Sort* se detalla la comparación de cada elemento con el pivote; en *Insertion Sort*, se explica por qué se detiene el desplazamiento (ya sea por valor o por límite de índice).
* **Modificaciones del Array:** Se imprime el estado del array tras cada intercambio, desplazamiento o fusión significativa, permitiendo ver la transformación paso a paso.
* **Profundidad de Recursión:** He implementado un sistema de indentación dinámica. Cada nivel de recursión añade espacios adicionales a la izquierda, permitiendo visualizar el árbol de llamadas de forma jerárquica y así poder seguirlo mejor.
* **Identificación de Casos Base:** Se han señalado los momentos exactos en los que los algoritmos recursivos alcanzan su condición de parada (arrays de tamaño 0 o 1), explicando el motivo del retorno.

## 3. Respeto a las Restricciones del Reto
Me he centrado en cumplir la **prohibición de modificar la lógica de ordenación**:

1.  **Lógica Intacta:** No se han añadido estructuras de control (`if`, `for`, `while`) ni se han modificado las condiciones originales de los algoritmos del enunciado.
2.  **Métodos Auxiliares:** Toda la lógica de la traza se basa en métodos de soporte (`formatearArray`, `ind`, `trazaComparacion`, etc.). Estos métodos son de "solo lectura" y no interfieren en el proceso de ordenación.

## 4. Pruebas Realizadas
Todas las trazas han sido generadas ejecutando el código sobre el array obligatorio:
`int[] array = {5, 2, 8, 1, 9, 3};`

Los resultados obtenidos permiten seguir la traza de forma lógica y coherente con el funcionamiento teórico de cada algoritmo de ordenación.
Y así me ha permitido verificar que lo que estaba haciendo estaba bien, y cuando no era así, podía revisar y hacer los ajustes necesarios, para arreglarlo.