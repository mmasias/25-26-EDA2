# contar cifras


Calcular el número de dígitos que tiene un número natural.


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|         |    n | f(n) |
| ------- | ---: | ---- |
| CB      |    1 | 1    |
| ...     |  ... | ...  |
| CR n-1  |   5432523 | 7    |
| CR n    |  54325234 | 8    |



8 = 1 + 7 *o lo que es igual* **1 + contarCifras(n / 10)**


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION contarCifras(n)


    SI n < 10 ENTONCES

        Resultado = 1

    SINO

        Resultado = 1 + contarCifras(n / 10)

    FIN SI


    Devolver Resultado


FIN FUNCIÓN

```


</details>
