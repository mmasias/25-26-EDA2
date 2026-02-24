# REEMPLAZAR UNA LETRA POR OTRA

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||cadena|f(n)|
|-|-|-|
CB|""|""|
...|||
n-1|"abc"| "bbc"|
n|"abcd"| "bbcd"|

Si cola == letraCambia => f(n-1)  + letraNueva
Si cola != letraCambia => f(n-1) + cola(n)

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION reemplazarLetra(n, letraCambia, letraNueva)

    SI n == "" ENTONCES
        DEVOLVER ""
    FIN SI

    SI cola(n) == letraCambia ENTONCES
        DEVOLVER reemplazarLetra(n-1)+ letraNueva
    SI NO
        DEVOLVER reemplazarLetra(n-1) + cola(cadena)
    FIN SI

FIN FUNCION
