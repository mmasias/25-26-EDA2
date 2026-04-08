# Identificación y justificación del caso base y del caso recursivo

## Caso base

El caso base se encuentra en el método `resolver(int posicion)` en la condición:

if (posicion == letras.length)

Se considera caso base porque en este punto ya se han asignado valores a todas las letras del problema, es decir, el problema ya está completamente resuelto.

A partir de aquí no se realizan más llamadas recursivas, sino que se construyen los números correspondientes a cada palabra mediante el método `formarNumero(...)`, se calcula la suma de los sumandos y se compara con el resultado.

Por tanto, es el punto en el que la recursividad termina y se decide si la solución es válida o no.

---

## Caso recursivo

El caso recursivo se encuentra en el mismo método, en el bloque alternativo:

else { ... }

Se considera caso recursivo porque el problema aún no está completamente resuelto, ya que quedan letras por asignar.

En este bloque se toma la letra actual y se prueban distintos valores posibles (del 0 al 9) que no estén ya utilizados y que cumplan las restricciones del problema.

Para cada valor válido se realiza una llamada recursiva:

resolver(posicion + 1)

Esta llamada permite avanzar en el problema asignando la siguiente letra, reduciendo así el problema original a uno más pequeño.

Si una asignación no conduce a una solución válida, se deshace y se prueba con otro valor, permitiendo explorar todas las combinaciones posibles.

Por tanto, este bloque es recursivo porque contiene la llamada a sí mismo y va reduciendo progresivamente el problema hasta alcanzar el caso base.

---

# Método alternativo sin recursividad

Una forma alternativa de resolver el problema sin utilizar recursividad es mediante un enfoque iterativo de fuerza bruta.

En este caso, en lugar de usar llamadas recursivas, se generan todas las posibles combinaciones de asignación de dígitos a las letras utilizando estructuras iterativas.

El proceso consistiría en:

- Generar todas las combinaciones posibles de dígitos sin repetir.
- Filtrar aquellas que no cumplan las restricciones (por ejemplo, que las letras iniciales no sean 0).
- Construir los números correspondientes a cada palabra.
- Comprobar si la suma de los sumandos coincide con el resultado.

Este método no utiliza recursividad, pero sigue siendo de fuerza bruta, ya que explora todas las combinaciones posibles.