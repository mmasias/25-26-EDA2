# conversor a binario


Convertir un número entero positivo a su representación binaria.



|        |    n | f(n)   |
| ------ | ---: | ------ |
| CB     |    1 | "1"    |
| ...    |  ... | ...    |
| CR n-1 |    6 | "110"  |
| CR n   |   13 | "1101" |



"1101" = "110" + "1" *o lo que es igual* **aBinario(n / 2) + string(n % 2)**


# Pseudocódigo


```

FUNCION aBinario(n)


    SI n < 2 ENTONCES

        Resultado = string(n)

    SINO

        Resultado = aBinario(n / 2) + string(n % 2)

    FIN SI


    Devolver Resultado


FIN FUNCIÓN


