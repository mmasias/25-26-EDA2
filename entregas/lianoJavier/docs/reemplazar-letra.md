# reemplazar letra


Reemplazar todas las apariciones de una letra por otra en una palabra o frase.


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|          | palabra | f(palabra, 'a', 'e') |
| -------- | ------: | -------------- |
| CB       |      "" | ""             |
| ...      |     ... | ...            |
| CR n-1 |  "nana" | "nene"         |
| CR n     | "anana" | "enene"        |



"enene" = 'e' + "nene" *o lo que es igual* **nueva + reemplazarLetra(resto, vieja, nueva)**


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION reemplazarLetra(palabra, vieja, nueva)


    SI palabra es vacía ENTONCES

        Resultado = ""

    SINO

        SI palabra[0] == vieja ENTONCES

           Resultado = nueva + reemplazarLetra(palabra[1...longitud(palabra)-1], vieja, nueva)

        SINO

           Resultado = palabra[0] + reemplazarLetra(palabra[1...longitud(palabra)-1], vieja, nueva)

        FIN SI

    FIN SI


    Devolver Resultado


FIN FUNCIÓN

```


</details>
