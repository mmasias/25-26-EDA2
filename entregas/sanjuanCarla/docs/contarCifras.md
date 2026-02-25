# CONTAR LAS CIFRAS DE UN NÚMERO

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|0|1| 
...|||
n-1|34|2|
n|234|3|

f(n-1) + 1

CB-> (UN NÚMERO DE UNA CIFRA)

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contarCifras(n)

    SI n == 0 ENTONCES
        DEVOLVER "1"
    FIN SI

    DEVOLVER 1 + contarCifras(n-1)

FIN FUNCION
