# producto de pares


Calcular el producto de todos los números pares positivos desde 2 hasta n.


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|        |    n | f(n) |
| ------ | ---: | ---- |
| CB     |    2 | 2    |
| ...    |  ... | ...  |
| CR n-1 |    4 | 8    |
| CR n   |    6 | 48   |



48 = 6 * 8 *o lo que es igual* **n * productoPares(n - 2)**


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION productoPares(n)


    SI n <= 2 ENTONCES

        Resultado = 2

    SINO

        SI n % 2 != 0 ENTONCES

            Resultado = productoPares(n - 1)

        SINO

            Resultado = n * productoPares(n - 2)

        FIN SI

    FIN SI


    Devolver Resultado


FIN FUNCIÓN

```


</details>
