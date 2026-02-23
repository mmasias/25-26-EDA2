# conversor a binario


Convertir un número entero positivo a su representación binaria (como cadena de texto).


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|        |    n | f(n)   |
| ------ | ---: | ------ |
| CB     |    0 | "0"    |
| CB     |    1 | "1"    |
| CR n/2 |    6 | "110"  |
| CR n   |   13 | "1101" |



f(n) = f(n/2) + string(n % 2)


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION aBinario(n)


    SI n < 2 ENTONCES

        Devolver string(n)

    FIN SI


    Devolver aBinario(n / 2) + string(n % 2)


FIN FUNCIÓN

```


</details>
