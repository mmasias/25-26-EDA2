# ELIMINAR TODAS LAS APARICIONES DE UNA LETRA

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||cadena|f(n)|
|-|-|-|
CB|""|""|
...|| |
n-1|"abc"| "bc"|
n|"abcd"| "bcd"|

Si cola(n) == letra => f(n-1)  
Si cola(n) == letra => f(n-1) + cola(n)

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION eliminarLetra(n , letra)

    SI n == "" ENTONCES
        DEVOLVER ""
    FIN SI

    SI cola(n) == letra ENTONCES
        DEVOLVER eliminarLetra(n-1)
    SI NO
        DEVOLVER eliminarLetra(n-1) + cola(n)
    FIN SI

FIN FUNCION
