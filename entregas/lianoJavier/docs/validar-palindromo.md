# validar palíndromo


Determinar si una palabra o frase es un palíndromo.


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|          | palabra | f(palabra) |
| -------- | ------: | ---------- |
| CB       |      "" | V          |
| CB       |     "d" | V          |
| ...      |     ... | ...        |
| CR n-1 |   "ada" | V          |
| CR n     | "radar" | V          |



V = ('r' == 'r') AND V *o lo que es igual* **(p[0] == p[n-1]) AND esPalindromo(interior)**


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION esPalindromo(palabra)


    SI longitud(palabra) <= 1 ENTONCES

        Resultado = VERDADERO

    SINO

        SI palabra[0] != palabra[longitud(palabra)-1] ENTONCES

            Resultado = FALSO

        SINO

            Resultado = esPalindromo(palabra[1...longitud(palabra)-2])

        FIN SI

    FIN SI


    Devolver Resultado


FIN FUNCIÓN

```


</details>
