# Elevar n al cuadrado

Calcular el cuadrado de un número usando suma recursiva.

## Analisis recursivo

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|0|
CR n-1|2|4|
CR n|3|9|

f(3) = f(2) + 2·3 − 1

</div>

Basado en la identidad:

n² = (n−1)² + 2n − 1

## Pseudocódigo

```text
FUNCION cuadrado(n)

    SI n es 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver cuadrado(n - 1) + 2*n - 1

FIN FUNCIÓN