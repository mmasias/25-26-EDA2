# contar cifras


Calcular el número de dígitos que tiene un número entero.


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


||n|f(n)|

|-|-:|-|

CB|0 a 9|1

CR n/10|12|2

CR n|123|3



3 = 1 + f(n/10) *o lo que es igual* **1 + contarCifras(n / 10)**


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION contarCifras(n)


    SI n < 10 ENTONCES

        Devolver 1

    FIN SI


    Devolver 1 + contarCifras(n / 10)


FIN FUNCIÓN

```


</details>
