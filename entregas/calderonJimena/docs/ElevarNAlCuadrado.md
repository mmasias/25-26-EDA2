# Elevar n al cuadrado

## Análisis recursivo

<div align=center>

| Tipo    | n | f(n) |
|---------|--:|-----:|
| CB      | 1 |    1 |
| ...     |...|  ... |
| CR n-1  | 2 |    4 |
| CR n    | 3 |    9 |

9 = 4 + 5  →  f(n - 1) + (2n - 1)

</div>

## Pseudocódigo

```text
FUNCION cuadrado(n)

    SI n == 1 ENTONCES

        Resultado = 1

    SI NO

        Resultado = cuadrado(n - 1) + (2 * n - 1)

    FIN SI

    Devolver Resultado

FIN FUNCIÓN