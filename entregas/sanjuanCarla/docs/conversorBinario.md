# CONVERSOR A BINARIO

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|0|0|
CB|1|1|
...|||
n-1|5|101|
n|6|110|

f(n/2) + (n % 2)

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION convertirBinario(n)

    SI n == 0 ENTONCES
        DEVOLVER "0"
    FIN SI

    SI n == 1 ENTONCES
        DEVOLVER "1"
    FIN SI

    DEVOLVER convertirBinario(n DIV 2) + (n MOD 2)

FIN FUNCION

//NO ENTENDIDO
