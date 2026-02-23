# producto de pares


Calcular el producto de todos los números pares positivos desde 2 hasta n.


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|        |    n | f(n)                             |
| ------ | ---: | -------------------------------- |
| CB     |    0 | 1 (Elemento neutro del producto) |
| CR n-2 |    4 | 8 = 4 * 2                        |
| CR n   |    6 | 48 = 6 * 8                       |



48 = 6 * f(n-2) *o lo que es igual* **n * productoPares(n - 2)**


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION productoPares(n)


    SI n < 2 ENTONCES

        Devolver 1

    FIN SI


    SI n % 2 != 0 ENTONCES

        Devolver productoPares(n - 1)

    FIN SI


    Devolver n * productoPares(n - 2)


FIN FUNCIÓN

```


</details>
