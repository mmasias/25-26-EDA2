# Caso base, caso recursivo y extensión sin recursividad

## Caso base

El caso base se encuentra en el método `resolver(int posicion)` en la condición:

if (posicion == letras.length)

Se considera caso base porque en este punto ya se han asignado valores a todas las letras del problema. No se realizan más llamadas recursivas, sino que se construyen los números y se comprueba si la suma es correcta. Aquí es donde termina la recursividad.

---

## Caso recursivo

El caso recursivo se encuentra en el bloque:

else { ... }

Se considera recursivo porque todavía quedan letras por asignar. Se prueban distintos valores para la letra actual y se realiza la llamada:

resolver(posicion + 1)

Esto permite avanzar en el problema. Si una opción no funciona, se deshace y se prueba otra, explorando todas las combinaciones.

---

## Extensión sin recursividad

En la extensión del reto se elimina la recursividad y se utiliza un enfoque iterativo.

En lugar de asignar valores letra a letra mediante llamadas recursivas, se generan todas las combinaciones posibles usando permutaciones con el método:

permutar(indice)

Se utiliza un array `digitos[]` con valores del 0 al 9 y se intercambian posiciones para generar distintas combinaciones.

Cuando se alcanza una combinación válida:

- Se asignan los valores a las letras
- Se comprueba que las letras iniciales no sean 0
- Se construyen los números
- Se verifica si la suma es correcta

Este método no usa recursividad para dividir el problema, sino que prueba directamente todas las combinaciones posibles de forma iterativa.