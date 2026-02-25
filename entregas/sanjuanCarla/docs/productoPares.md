# PRODUCTO DE PARES HASTA N

Multiplicar los números pares desde 2 hasta n.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|2|2|
...|||
n-1|5|8|
n|6|48|

Si n es par => n * f(n-1)  
Si n es impar => f(n-1)

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION productoPares(n)

    SI n <= 1 ENTONCES
        DEVOLVER 1
    FIN SI

    SI n es par ENTONCES
        DEVOLVER n * productoPares(n-2)
    SI NO
        DEVOLVER productoPares(n-1)
    FIN SI

FIN FUNCION
