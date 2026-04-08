# Explicación del Algoritmo — CriptarimeticaSolver

## Qué es el problema

Un acertijo de criptaritmética consiste en una operación matemática donde cada letra representa un dígito único del 0 al 9. Las letras que aparecen al inicio de cada palabra no pueden valer 0, ya que representan la cifra más significativa de un número. El objetivo es encontrar la asignación de dígitos que hace válida la operación.

## Enfoque utilizado: Recursividad con Backtracking

El algoritmo asigna dígitos a cada letra de forma secuencial mediante llamadas recursivas. En cada nivel de recursión se prueba un dígito para la letra actual y, si cumple las restricciones, se avanza al siguiente nivel. Si al completar todas las asignaciones la suma no cuadra, se retrocede (backtracking), se deshace la última asignación y se prueba con el siguiente dígito disponible.

## Estructura de la clase

La clase `CriptarimeticaSolver` recibe en su constructor un array de operandos (las palabras que se suman) y un resultado (la palabra del resultado). A partir de ahí extrae automáticamente las letras únicas y las letras iniciales que no pueden valer 0.

### Atributos

- `letras`: array con las letras únicas del acertijo.
- `asignacion`: array paralelo a `letras` que guarda el dígito asignado a cada una.
- `digitoUsado`: array de 10 booleanos que indica qué dígitos ya están ocupados.
- `operandos`: las palabras que se suman.
- `resultado`: la palabra resultado.
- `letrasIniciales`: letras que no pueden valer 0 por estar al inicio de una palabra.

### Método recursivo: asignarLetra(indice)

Este es el núcleo del algoritmo:

1. **Caso base** — Si el índice es igual al total de letras, ya se han asignado todas. Se llama a `verificarSuma()` para comprobar si la ecuación es correcta.
2. **Caso recursivo** — Se prueban los dígitos del 0 al 9. Para cada uno se comprueba que no esté ya usado y que no sea 0 si la letra es inicial. Si es válido, se asigna, se marca como usado y se llama recursivamente con el siguiente índice.
3. **Backtracking** — Si la llamada recursiva devuelve `false`, se deshace la asignación (se pone a -1) y se libera el dígito para probarlo en otra letra.

### Validación: esAsignacionValida(indice, digito)

Comprueba dos restricciones:

- Que el dígito no esté ya asignado a otra letra.
- Que no se asigne 0 a una letra que aparece al inicio de alguna palabra.

### Verificación: verificarSuma()

Construye los números a partir de las asignaciones actuales y comprueba si la suma de los operandos es igual al resultado. Si es correcta, imprime la solución y devuelve `true`.

### Construcción de números: construirNumero(palabra)

Recorre la palabra carácter a carácter y va multiplicando por 10 y sumando el dígito correspondiente para formar el número completo. Por ejemplo, si S=9, E=5, N=6, D=7, para "SEND" calcula 9×1000 + 5×100 + 6×10 + 7 = 9567.

## Diseño generalizado

El solver no está hecho para un acertijo concreto. Al recibir operandos y resultado como parámetros, resuelve cualquier acertijo de criptaritmética sin modificar el código. En el `main` se instancian tres casos:

- SEND + MORE = MONEY
- FORTY + TEN + TEN = SIXTY
- ODD + ODD = EVEN

## Complejidad

En el peor caso se exploran todas las permutaciones de 10 dígitos tomados de N en N, siendo N el número de letras únicas. Sin embargo, el backtracking poda las ramas inválidas de forma temprana (dígitos repetidos, ceros en posiciones iniciales), lo que reduce drásticamente el espacio de búsqueda real.

## Resultado esperado

Para SEND + MORE = MONEY la solución es:

```
S=9, E=5, N=6, D=7, M=1, O=0, R=8, Y=2
9567 + 1085 = 10652
```