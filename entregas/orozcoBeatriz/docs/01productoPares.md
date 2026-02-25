# PRODUCTO DE PARES HASTA N

Multiplicar los números pares desde 2 hasta n.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|Caso|n|f(n)|
|---|---:|---:|
|CB|0|1|
|CB|1|1|
|CB|2|2|
|...|...|...|
|n-1|5|8|
|n|6|48|

Si n es par → f(n) = n * f(n-2)  
Si n es impar → f(n) = f(n-1)

</div>

</details>

## Pseudocódigo

```text
FUNCION productoPares(n)

    SI n < 2 ENTONCES
        DEVOLVER 1
    FIN SI

    SI esPar(n) ENTONCES
        DEVOLVER n * productoPares(n - 2)
    SINO
        DEVOLVER productoPares(n - 1)
    FIN SI

FIN FUNCION
```