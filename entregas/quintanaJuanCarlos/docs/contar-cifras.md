# contar cifras


Calcular el número de dígitos que tiene un número natural.



|         |    n | f(n) |
| ------- | ---: | ---- |
| CB      |    1 | 1    |
| ...     |  ... | ...  |
| CR n-1   |   12 | 2    |
| CR n    |  123 | 3    |



3 = 1 + 2 *o lo que es igual* **1 + contarCifras(n / 10)**


```
FUNCION contarCifras(n)


    SI n < 10 ENTONCES

        Resultado = 1

    SINO

        Resultado = 1 + contarCifras(n / 10)

    FIN SI


    Devolver Resultado


FIN FUNCIÓN