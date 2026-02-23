# reemplazar letra


Reemplazar todas las apariciones de una letra por otra en una palabra o frase.


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|             |         palabra | f(palabra, vieja, nueva) |
| ----------- | --------------: | ------------------------ |
| CB          |              "" | ""                       |
| CR resto    | "casa" (a -> e) | "cese"                   |
| CR completa |         "acasa" | "ecese"                  |



f(palabra) = (nueva + f(resto)) if char == vieja else (char + f(resto))


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION reemplazarLetra(palabra, vieja, nueva)


    SI palabra es vacía ENTONCES

        Devolver ""

    FIN SI


    SI palabra[0] == vieja ENTONCES

       Devolver nueva + reemplazarLetra(palabra[1:], vieja, nueva)

    SINO

       Devolver palabra[0] + reemplazarLetra(palabra[1:], vieja, nueva)

    FIN SI


FIN FUNCIÓN

```


</details>
