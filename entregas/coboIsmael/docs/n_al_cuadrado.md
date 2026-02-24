# Elevar n al cuadrado

Calcular n² utilizando una relación recursiva basada en la suma de impares.

## Análisis recursivo

|   | n | f(n) |
|---|---|------|
| CB | 0 | 0 |
|   | 1 | 1 |
|   | 2 | 4 |
|   | 3 | 9 |
|   | 4 | 16 |
|   | 5 | 25 |

f(n) = f(n-1) + (2n - 1)

## Pseudocódigo

FUNCION cuadrado(n)

    SI n es 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver cuadrado(n - 1) + (2 * n - 1)

FIN FUNCIÓN