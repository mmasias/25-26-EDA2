# ELEVAR N AL CUADRADO

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|0|0|
...|2|4|
n-1|2|4|
n|3|9|

f(n-1) + (2n - 1)

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION cuadrado(n)

    SI n == 0 ENTONCES
        DEVOLVER 0
    FIN SI

    DEVOLVER cuadrado(n-1) + (2n - 1)

FIN FUNCION
