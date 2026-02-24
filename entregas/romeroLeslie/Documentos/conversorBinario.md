## Convertir a binario

Convertir de entero a binario.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Tipo    | n  | f(n)                 |
|---------|----|---------------------|
| CB      | 1  | "1"                 |
| ...     | ...| ...                 |
| CR n-1  | 6  | f(3) + "0" = "110"  |
| CR n    | 13 | f(6) + "1" = "1101" |

f(n) = f(n / 2) + (n MOD 2)


</div>

</details>

## Pseudocódigo
<details>
<summary>Ver pseudocódigo</summary>

FUNCION conversorABinario(n)

    SI n < 2 ENTONCES
        Devolver cadena(n)
    FIN SI
    Devolver conversorABinario(n / 2) + cadena(n MOD 2)

FIN FUNCIÓN