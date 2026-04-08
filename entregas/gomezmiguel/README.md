# Money

Para resolver el problema **SEND + MORE = MONEY**  use bastanate la programacion orintada a objetos,y la recursividad.

##  Como use la Recursividad

Use principalmente backtracking y reciursividad principalmente

1. Caso base Si todas las letras tienen un dígito asignado, la recursión se detiene y valida si la suma aritmética es correcta.
2. Caso Recursivo:El método se llama a sí mismo para intentar asignar un valor a la siguiente letra de la lista.
3. Backtracking:Si una asignación no conduce a la solución, la función "vuelve atrás" en la pila de llamadas, libera el dígito y prueba el siguiente camino.
