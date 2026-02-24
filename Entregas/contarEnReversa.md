### Contar en reversa

Generar una cadena con los números desde **n** hasta **0**, en orden descendente.

## Análisis recursivo

<div align=center>

| Tipo   |   n | f(n)        |
|--------|----:|-------------|
| CB     |   0 | "0"         |
| ...    | ... | ...         |
| CR n-1 |   4 | "4, 3, 2, 1, 0" |
| CR n   |   5 | "5, 4, 3, 2, 1, 0" |

"5, 4, 3, 2, 1, 0" = "5, " + "4, 3, 2, 1, 0" → **n + ", " + f(n - 1)**

</div>

## Pseudocódigo

```text
FUNCION contarEnReversa(n)

    SI n == 0 ENTONCES

        Resultado = "0"

    SI NO

        Resultado = n + ", " + contarEnReversa(n - 1)

    FIN SI

    Devolver Resultado

FIN FUNCIÓN