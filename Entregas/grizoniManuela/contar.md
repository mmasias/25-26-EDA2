### Contar

Generar una cadena con los números desde **0** hasta **n**, separados por comas.

## Análisis recursivo

<div align=center>

| Tipo   |   n | f(n)        |
|--------|----:|-------------|
| CB     |   0 | "0"         |
| ...    | ... | ...         |
| CR n-1 |   4 | "0, 1, 2, 3, 4" |
| CR n   |   5 | "0, 1, 2, 3, 4, 5" |

"0, 1, 2, 3, 4, 5" = "0, 1, 2, 3, 4" + ", 5" → **f(n - 1) + ", " + n**

</div>

## Pseudocódigo

```text
FUNCION contar(n)

    SI n == 0 ENTONCES

        Resultado = "0"

    SI NO

        Resultado = contar(n - 1) + ", " + n

    FIN SI

    Devolver Resultado

FIN FUNCIÓN