# Producto de pares hasta n

Calcular el producto de todos los números pares positivos desde 2 hasta n.

## Análisis recursivo

<div align=center>

| Tipo    |   n |   f(n) |
|---------|----:|-------:|
| CB      |   1 |      1 |
| ...     | ... |    ... |
| CR n-1  |   5 |      8 |
| CR n    |   6 |     48 |

48 = 6 × 8 → n * f(n - 1)  (cuando n es par)

</div>

## Pseudocódigo

```text
FUNCION productoPares(n)

    SI n < 2 ENTONCES

        Devolver 1

    SI NO

        SI n % 2 == 0 ENTONCES

            Devolver n * productoPares(n - 1)

        SINO

            Devolver productoPares(n - 1)

        FIN SI

    FIN SI

FIN FUNCIÓN