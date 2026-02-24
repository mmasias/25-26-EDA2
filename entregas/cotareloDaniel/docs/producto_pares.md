# Producto de pares hasta n

Calcular el producto de todos los números pares positivos desde 2 hasta n.

## Análisis recursivo

<div align=center>

| Tipo    |   n |   f(n) |
|---------|----:|--------:|
| CB      |   2 |       2 |
| ...     | ... |     ... |
| CR n-1  |   4 |       8 |
| CR n    |   6 |      48 |

48 = 6 × 8 → n * f(n - 1)

</div>

## Pseudocódigo

```text
FUNCION productoPares(n)

    SI n == 2 ENTONCES

        Resultado = 2

    SI NO

        SI n % 2 != 0 ENTONCES

            Resultado = productoPares(n - 1)

        SINO

            Resultado = n * productoPares(n - 2)

        FIN SI

    FIN SI

    Devolver Resultado

FIN FUNCIÓN