# Entrega: Reto de Recuperación - Trazas de Ordenación

## Descripción
Esta carpeta contiene las implementaciones en Java de los algoritmos **Insertion Sort**, **Merge Sort** y **Quick Sort**. Se han enriquecido los códigos con instrucciones de traza por consola para visualizar el comportamiento de cada algoritmo paso a paso.

Se ha respetado **estrictamente** la restricción del ejercicio: **no se ha modificado la lógica de ordenación original**. Las únicas adiciones han sido instrucciones `System.out.println` y variables/métodos auxiliares para gestionar la representación visual e indentación como el uso de tabs para indentacion etc.

## Cumplimiento de Requisitos
- ✅ **Estado inicial y final:** Se muestra el array de prueba `{5, 2, 8, 1, 9, 3}` antes de iniciar y tras finalizar.
- ✅ **Cada decisión relevante:** Las comparaciones de los bucles y condicionales se imprimen indicando los valores exactos y si el resultado es Verdadero o Falso.
- ✅ **Modificaciones del array:** Cada desplazamiento, intercambio o fusión queda registrado indicando el índice y el valor.
- ✅ **Profundidad de recursión visible:** Se ha implementado un sistema de prefijos y tabulaciones (`┌──`, `│`, `└──`) que dibuja el árbol de llamadas recursivas en la consola.
- ✅ **Identificación de casos base:** Se notifica claramente cuándo la recursión se detiene y la razón matemática (ej. `izq >= der` o sub-array de 1 elemento).