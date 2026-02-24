# Contar las cifras de un número

Contar cuántas cifras tiene un número entero n.
El número 0 tiene 1 cifra.

## Análisis recursivo

|   | n | f(n) |
|---|---|------|
| CB | 0 | 1 |
| CB | 7 | 1 |
|   | 42 | 2 |
|   | 534 | 3 |
|   | 1200 | 4 |

1 + f(n / 10)

## Pseudocódigo

FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        Devolver 1
    FIN SI

    Devolver 1 + contarCifras(n / 10)

FIN FUNCIÓN