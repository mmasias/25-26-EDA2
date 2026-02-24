### Potencias

Calcular **2** elevado a la potencia **n**.

## Análisis recursivo

<div align=center>

| Tipo   |   n |   f(n) |
|--------|----:|-------:|
| CB     |   0 |      1 |
| ...    | ... |    ... |
| CR n-1 |   4 |     16 |
| CR n   |   5 |     32 |

32 = 2 × 16 → **2 * f(n - 1)**

</div>

## Pseudocódigo

```text
FUNCION potencia(n)

    SI n == 0 ENTONCES

        Resultado = 1

    SI NO

        Resultado = 2 * potencia(n - 1)

    FIN SI

    Devolver Resultado

FIN FUNCIÓN