### Suma de N primeros

Calcular la suma de los **n** primeros números enteros positivos.

## Análisis recursivo

<div align=center>

| Tipo    |   n |   f(n) |
|---------|----:|--------:|
| CB      |   0 |       0 |
| ...     | ... |     ... |
| CR n-1  |   4 |      10 |
| CR n    |   5 |      15 |

15 = 5 + 10 → **n + f(n - 1)**

</div>

## Pseudocódigo

```text
FUNCION sumaNPrimeros(n)

    SI n == 0 ENTONCES

        Resultado = 0

    SI NO

        Resultado = n + sumaNPrimeros(n - 1)

    FIN SI

    Devolver Resultado

FIN FUNCIÓN