# Reto 002

El problema consiste en resolver algunas operaciones como:
 
```
  S E N D
+ M O R E
---------
M O N E Y
```
 
Cada letra representa un dígito del 0 al 9 sin repetirse, y hay que encontrar qué número le toca a cada una para que la suma cuadre. El reto pide resolverlo mediante recursividad.
 
---
 
## Cómo lo he planteado
 
Mi idea fue ir asignándole números a las letras una a una de forma recursiva. Primero recojo todas las letras únicas de cada operación, y luego el método `asignar()` va probando dígitos del 0 al 9 para cada una. Cuando ya están todas asignadas compruebo si la suma se cumple, y si no, deshago la asignación y pruebo con otro número.
 
Hay un par de restricciones que hay que tener en cuenta: no se puede repetir un dígito que ya esté usado por otra letra, y ninguna palabra puede empezar por 0.

El [**caso base**](https://github.com/beatriizorozco/25-26-EDA2/blob/4c1a5685421ac1eae90d03bc0f2b1317ed0e3e24/entregas/orozcoBeatriz/src/AlgoritmoRecursivo.java#L30) es cuando `pos == letras.length()`, es decir, cuando ya no quedan letras por asignar. En ese momento se comprueba si la suma es correcta y si lo es, se imprime la solución.
 
La [**llamada recursiva**](https://github.com/beatriizorozco/25-26-EDA2/blob/b8b7ead10e135df1492f21db6d3ace0f49b05bc3/entregas/orozcoBeatriz/src/AlgoritmoRecursivo.java#L40) es `asignar(letras, pos + 1, sumandos, resultado)`, que se hace justo después de asignar un dígito a la letra actual, avanzando a la siguiente posición.
 
Lo he probado con las tres operaciones pedidas del reto y los resuelve todos sin problema.
 
---
 
## Resultados
 
```
SEND + MORE = MONEY        →   9567 + 1085 = 10652
FORTY + TEN + TEN = SIXTY  →   29786 + 850 + 850 = 31486
ODD + ODD = EVEN           →   dos soluciones: 655+655 y 855+855
```
 
La tercera tiene dos soluciones porque las restricciones son menos estrictas al haber menos letras distintas.

## Versión iterativa
 
También lo he resuelto de forma iterativa, que básicamente es lo mismo pero sin usar recursividad. En vez de que sea la propia JVM la que gestione la pila de llamadas, lo hago yo a mano con un array `asignacion[]` que guarda qué dígito tiene asignado cada letra en cada momento.
 
El bucle principal avanza letra a letra (`pos++`) cuando encuentra un dígito válido, y retrocede (`pos--`) cuando se queda sin opciones — que es exactamente lo que hacía la recursión, pero explícito. La clave es que al retroceder, el array `asignacion[]` me dice desde qué número tengo que seguir probando, sin volver a empezar desde 0.
 
```java
if (encontrado) {
    pos++;
} else {
    pos--;
}
```
 
El resultado es el mismo, solo cambia cómo se gestiona internamente el backtracking.
