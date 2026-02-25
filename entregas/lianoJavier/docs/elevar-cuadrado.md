# elevar al cuadrado


Calcular el cuadrado de un número n utilizando la propiedad de que n² = (n-1)² + 2n - 1.


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|        |    n | f(n) |
| ------ | ---: | ---- |
| CB     |    0 | 0    |
| ...    |  ... | ...  |
| CR n-1 |    3 | 9    |
| CR n   |    4 | 16   |



16 = 9 + 2(4) - 1 *o lo que es igual* **elevarCuadrado(n - 1) + 2*n - 1**


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION elevarCuadrado(n)


    SI n == 0 ENTONCES

        Resultado = 0

    SINO

        Resultado = elevarCuadrado(n - 1) + 2 * n - 1

    FIN SI


    Devolver Resultado


FIN FUNCIÓN

```


</details>
