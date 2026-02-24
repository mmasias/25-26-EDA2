# Producto de pares hasta n

Calcular el producto de todos los números pares desde 2 hasta n.
Si no hay pares, el resultado es 1.

## Análisis recursivo

|   | n | f(n) |
|---|---|------|
| CB | 0 | 1 |
| CB | 1 | 1 |
|   | 2 | 2 |
|   | 3 | 2 |
|   | 4 | 8 |
|   | 6 | 48 |

Si n es par → n * f(n-2)
Si n es impar → f(n-1)

## Pseudocódigo

FUNCION productoPares(n)

    SI n < 2 ENTONCES
        Devolver 1
    FIN SI

    SI n es impar ENTONCES
        Devolver productoPares(n - 1)
    FIN SI

    Devolver n * productoPares(n - 2)

FIN FUNCIÓN