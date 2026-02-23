# eliminar letra


Eliminar todas las apariciones de una letra específica en una palabra o frase.


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|     | palabra | f(palabra, 'a') |
| --- | ------: | --------------- |
| CB  |      "" | ""              |
| ... |     ... | ...             |
| CR n-1 |  "nana" | "nn"            |
| CR n | "anana" | "nn"            |



resultado = cabeza + f(n-1)


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION eliminarLetra(palabra, letra)


    SI palabra es vacía ENTONCES

        Resultado = ""

    SINO

        SI palabra[0] == letra ENTONCES

           Resultado = eliminarLetra(palabra[1...longitud(palabra)-1], letra)

        SINO

           Resultado = palabra[0] + eliminarLetra(palabra[1...longitud(palabra)-1], letra)

        FIN SI

    FIN SI


    Devolver Resultado


FIN FUNCIÓN

```


</details>
