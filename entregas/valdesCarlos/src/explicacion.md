# Explicación del problema: SEND + MORE = MONEY

Este documento explica cómo he pensado y resuelto el acertijo criptoaritmético `SEND + MORE = MONEY` utilizando recursividad y la técnica de "vuelta atrás" (backtracking). 

El objetivo es asignarle a cada letra (S, E, N, D, M, O, R, Y) un dígito del 0 al 9, asegurándonos de que no haya números repetidos y de que la suma final sea correcta.

## 1. La idea principal

En lugar de crear 8 bucles anidados (uno para cada letra, lo cual sería muy lioso), he planteado una solución recursiva que va letra por letra probando los números que quedan libres. 

Para saber cómo va el proceso, utilizo dos herramientas muy simples:
* Una lista para ir apuntando qué número le he dado a cada letra.
* Una lista de "ocupados" para ir tachando los números del 0 al 9 que ya he repartido, así me aseguro de no repetir ninguno.

La clave de este método es que si el programa toma un mal camino (la suma no da), no empieza todo desde cero. Simplemente da un paso atrás, **borra el último número que puso** y prueba con la siguiente opción disponible.

## 2. Reglas del algoritmo

Para que el ordenador sepa qué hacer en cada momento, he definido estas reglas básicas:

| Momento del proceso | ¿Qué pasa? | ¿Qué hace el programa? |
| :--- | :--- | :--- |
| **Final del camino** *(Caso base)* | Ya he rellenado las 8 letras con números. | Saca la calculadora, convierte esas letras en números reales y comprueba si la suma cuadra. |
| **Descarte rápido** *(Poda)* | Se intenta asignar un `0` a las letras iniciales ('S' o 'M'). | Lo prohíbe. Como los números no empiezan por cero, descarta esa opción y prueba el siguiente dígito. |
| **Número repetido** | Se intenta probar un número que ya tiene otra letra. | Pasa al siguiente número. |
| **Probar y retroceder** *(Backtracking)* | Hay un número libre y válido. | **1. Anota:** Le da el número a la letra y lo marca como usado.<br>**2. Avanza:** Llama a la función para probar la siguiente letra.<br>**3. Retrocede:** Si más adelante ese camino falla, vuelve aquí, "des-marca" el número y prueba otra opción. |