## Factorial

Calcular el producto de todos los números enteros positivos desde 1 hasta n.  
Por definición, **0! = 1**.

## Análisis recursivo

<div align=center>

| Tipo    |   n |   f(n) |
|---------|----:|--------:|
| CB      |   0 |       1 |
| ...     | ... |     ... |
| CR n-1  |   4 |      24 |
| CR n    |   5 |     120 |

120 = 5 × 24 → **n * f(n - 1)**

</div>

## Pseudocódigo

```text
FUNCION factorial(n)

    SI n == 0 ENTONCES

        Resultado = 1

    SI NO

        Resultado = n * factorial(n - 1)

    FIN SI

    Devolver Resultado

FIN FUNCIÓN