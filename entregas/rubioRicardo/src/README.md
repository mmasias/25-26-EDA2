# Proyecto: Solucionador de Criptoaritmética

## La Forma de la Búsqueda (El Árbol)
Visualmente, el algoritmo construye un árbol donde cada nivel de profundidad representa una letra diferente (Nivel 0 = S, Nivel 1 = E...). Cada rama representa una elección de un número del 0 al 9.



## El Caso Base (El límite del árbol)
Ocurre cuando el índice iguala a la cantidad total de letras. Significa que ya hemos asignado un número a todas las variables. Aquí la recursividad deja de avanzar y llama a la función de comprobación para ver si esa combinación es la ganadora.

**Código del caso base:**

java
if (indice == letras.length) {
    return comprobarSuma();
}

## El Caso Recursivo (El motor de avance)
Ubicado dentro de un bucle for, es donde la función reserva un número (usado[digito] = true) y luego se llama a sí misma pasándole la batuta a la siguiente letra (resolver(indice + 1)).

## El Backtracking como método de corrección
Si la llamada recursiva falla (devuelve false), el código entra en la fase de recuperación: ejecuta usado[digito] = false para liberar el número equivocado y permite que el bucle siga girando para probar el siguiente.

Cuando llegamos al Caso Base y la suma es incorrecta, esa ejecución específica retorna false y muere. Sin embargo, el programa no se apaga. Gracias a la pila de llamadas de Java, el control del programa retrocede automáticamente a la función que la había llamado, es decir, a la letra anterior.

### Ejemplo del flujo:
1. **La Letra 6** elige un número y llama a la **Letra 7** (la última letra).
2. **La Letra 7** choca contra el Caso Base, la suma da error, y la Letra 7 devuelve false.
3. Al recibir ese false, la memoria de Java despierta de nuevo a la **Letra 6**.
4. **La Letra 6** asume el error, borra su número implementando el Backtracking y, como está dentro de un bucle for, simplemente prueba con el siguiente número disponible y vuelve a invocar a la Letra 7.

Por lo tanto, el Caso Base actúa como un rebote. Cada vez que el algoritmo choca contra él y falla, la Pila de Llamadas absorbe el golpe, retrocede un paso, ajusta un número y vuelve a lanzarse hacia adelante. Este ciclo de intentar, chocar y retroceder no se detendrá hasta que el algoritmo logre el objetivo, es decir, la suma correcta, o hasta que se agoten todas las combinaciones posibles del universo numérico.

En el código entregado, cada letra se puede representar como un escalón y cada número una puerta. La recursividad es lo que permite moverte de a un escalón a la vez (indice + 1), mientras que el arreglo usado[] es lo que no nos permite repetir números. El caso base es el final de la escalera: cuando te quedas sin letras, te detienes y compruebas si la suma es correcta.

Si la suma falla, el backtracking entra en juego como un paso atrás automático: desbloqueas la última entrada (usado = false) y pruebas la siguiente. Esta estructura permite que el programa no dé vueltas en círculos, sino que avance siempre hacia una solución, descartando caminos falsos e introduciendo el concepto de poda hasta que lleguemos a un caso base, deteniendo la búsqueda en el momento exacto en que encuentras la respuesta.