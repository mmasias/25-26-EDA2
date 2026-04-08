# Resolución: SEND + MORE = MONEY

---

## Integrantes del Grupo
 **Gabriel Béjar**
 **Miguel Gómez**
 **Carlos Alvarado**
 **Nicolás Navas**
 **Samuel Herrera**

---

## Propuesta Inicial
> **Nota:** Estrategia basada en búsqueda exhaustiva mediante Backtracking.

* Se asignan dígitos a las letras una a una en el orden: `(S, E, N, D, M, O, R, Y)`.
* Cada vez que se elige un número, se reserva para evitar repeticiones (memoización).
* En cada paso, se comprueba si la suma mantiene la posibilidad de ser válida.
* Si en algún punto la combinación deja de ser viable, el algoritmo retrocede (**backtrack**) y prueba con el siguiente número disponible.
* Al completar la asignación de todas las letras, se valida la ecuación fundamental:  

---

### Topología

 **Identificar caso base** (Condición de parada)
  Ocurre cuando el algoritmo ya ha procesado todas las letras del arreglo.
  ```java
  if (indice == letters.length) {
      return verifySum(option);
  }
  ```
 **Identificar poda** (Descarte de caminos inválidos)
Evita procesar ramas donde el dígito ya está en uso o si se intenta asignar un cero a las letras iniciales de las palabras.

```java
boolean esCeroInvalido = (digit == 0) && ((option == 1 && (caracterActual == 'S' || caracterActual == 'M')));

if (!esCeroInvalido && !used[digit]) 

```

 **Identificar hacer** (Marcar el estado / Tomar decisión)
Se reserva el dígito marcándolo como usado y se le asigna el valor a la letra actual.

```java
used[digit] = true;
values[caracterActual] = digit;
```

 **Identificar llamada recursiva** (Avanzar en el árbol de decisiones)
Se llama a la misma función pasando a la siguiente letra (indice + 1).

```java
if (resolve(letters, indice + 1, option)) {
    return true;
}
```

 **Identificar deshacer** (Backtracking / Revertir el estado)
Si la llamada recursiva no devolvió éxito, se desmarca el dígito para liberarlo y probar con el siguiente en el ciclo for.

```java
used[digit] = false;
```

---

## Justificación del Diseño Algorítmico

El algoritmo finaliza cuando el índice de búsqueda alcanza la longitud total del arreglo de letras. En este punto, se realiza la conversión de las letras asignadas a sus valores numéricos y se verifica si la identidad aritmética se cumple satisfactoriamente.

Mientras no se alcance el final del arreglo, el sistema identifica el carácter actual según la profundidad de la recursión (el índice), preparándolo para la asignación de un valor.

Se ejecuta un ciclo iterativo del **0 al 9** para cada letra. Se aplica una técnica de **poda (pruning)** esencial: se restringe que las letras que inician una palabra (**S** y **M**) tomen el valor de **0**, garantizando la coherencia matemática del problema.

Se emplea un arreglo auxiliar de estados para marcar un dígito como "usado" y se vincula a la letra actual.
2.  **Hacer:** Se invoca la función recursiva aumentando en 1 el índice para procesar la siguiente letra.
3.  **Deshacer:** Siguiendo el principio de deshacer caminos incorrectos, al regresar en la llamada recursiva, se "desmarca" el dígito utilizado, permitiendo que sea probado en otras combinaciones.

---