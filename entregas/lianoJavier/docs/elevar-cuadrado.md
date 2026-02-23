# elevar al cuadrado


Calcular el cuadrado de un número n utilizando la propiedad de que n² = (n-1)² + 2n - 1.


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|        |    n | f(n)               |
| ------ | ---: | ------------------ |
| CB     |    0 | 0                  |
| CR n-1 |    4 | 16                 |
| CR n   |    5 | 25 = 16 + 2(5) - 1 |



25 = f(n-1) + 2n - 1 *o lo que es igual* **elevarCuadrado(n - 1) + 2*n - 1**


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION elevarCuadrado(n)


    SI n == 0 ENTONCES

        Devolver 0

    FIN SI

    
    Devolver elevarCuadrado(n - 1) + 2 * n - 1


FIN FUNCIÓN

```


</details>
