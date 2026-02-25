# Conversor a binario

## Análisis recursivo

<div align=center>

| Tipo   | n | f(n) |
|--------|--:|------|
| CB     | 0 | ""   |
| ...    |...| ...  |
| CR n-1 | 2 | "10" |
| CR n   | 5 | "101" |

"101" = "10" + "1"  →  f(n / 2) + (n % 2)

</div>

## Pseudocódigo

```text
FUNCION convertirBinario(n)

    SI n == 0 ENTONCES

        Resultado = ""

    SI NO

        Resultado = convertirBinario(n / 2) + (n % 2)

    FIN SI

    Devolver Resultado

FIN FUNCIÓN