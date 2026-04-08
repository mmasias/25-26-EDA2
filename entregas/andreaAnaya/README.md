# SEND + MORE = MONEY

Solución al clásico criptograma aritmético mediante dos enfoques: **algoritmo recursivo** con backtracking y **algoritmo iterativo** con simulación de pila.

---

## ¿En qué consiste el problema?

El problema es una suma donde cada letra representa un dígito del 0 al 9:

```
  S E N D
+ M O R E
---------
M O N E Y
```

Las reglas son:
- Cada letra representa un dígito distinto
- Dos letras distintas no pueden tener el mismo dígito
- `S` y `M` no pueden ser 0, ya que son la primera cifra de un número

La única solución válida es:

```
    09567
  + 01085
  -------
    10652
```

Es decir: S=9, E=5, N=6, D=7, M=1, O=0, R=8, Y=2.

---

## ¿Cómo funciona la solución?

Se asigna un dígito a cada letra una a una. Para cada letra se prueban los dígitos del 0 al 9 en orden. Si el dígito ya está usado por otra letra, se salta. Cuando todas las letras tienen un dígito asignado, se construyen los números SEND, MORE y MONEY y se comprueba si la suma es correcta. Si no lo es, se deshace la última asignación y se prueba el siguiente dígito. Este proceso de volver atrás y probar otra cosa se llama **backtracking**.

---

## Algoritmo recursivo

La función se llama a sí misma con la siguiente letra en cada paso.

**Caso base:** cuando todas las letras están asignadas, se verifica si la suma es correcta. Si lo es, se ha encontrado la solución. Si no, se devuelve `false` y la función vuelve atrás automáticamente.

**Caso recursivo:** si aún quedan letras sin asignar, se prueba cada dígito disponible para la letra actual y se llama a la misma función con la siguiente letra.

**Backtracking:** cuando ningún dígito funciona para una letra, la función devuelve `false` y el nivel anterior prueba el siguiente dígito. Este retroceso es automático gracias a la pila de llamadas de Java.

---

## Algoritmo iterativo

Hace exactamente lo mismo que el recursivo pero sin llamarse a sí mismo. En su lugar usa una variable de posición que avanza o retrocede manualmente.

**Equivalente al caso base:** cuando la posición llega a la última letra, se verifica si la suma es correcta.

**Equivalente al avance recursivo:** si se encontró un dígito válido y no es la última letra, la posición avanza a la siguiente.

**Equivalente al backtracking:** si ningún dígito funcionó para la letra actual, la posición retrocede a la anterior y se libera el dígito que tenía asignado.

**Condición de parada:** cuando la posición cae por debajo de cero, significa que se han agotado todas las combinaciones posibles y el bucle termina.

---

## Diferencias entre ambos enfoques

| | Recursivo | Iterativo |
|---|---|---|
| Longitud del código | Corto | Más largo |
| Legibilidad | Alta | Media |
| Backtracking | Automático | Manual |
| Caso base | Cuando todas las letras están asignadas | Cuando la posición llega a la última letra |
| Parada | La función devuelve false | La posición cae por debajo de cero |

---


- Cueva Lovelle, J.M. — *Lenguajes, Gramáticas y Autómatas* (2001), Universidad de Oviedo
- Problema clásico de criptaritmética propuesto por Henry Dudeney (1924)
