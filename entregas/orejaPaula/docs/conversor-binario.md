# conversor binario


Convertir un número entero positivo n a binario.


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|        | n  | f(n)  |
| ------ | --:| ----- |
| CB     | 1  | "1"   |
| ...    | ...| ...   |
| CR n-1 | 6  | "110" |
| CR n   | 13 | "1101"|



"1101" = "110" + "1" *o lo que es igual* **aBinario(n / 2) + (n % 2)**


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION aBinario(n)


    SI n == 0 ENTONCES

        Resultado = "0"

    SINO SI n == 1 ENTONCES

        Resultado = "1"

    SINO

        Resultado = aBinario(n / 2) + (n % 2)

    FIN SI


    Devolver Resultado


FIN FUNCIÓN
