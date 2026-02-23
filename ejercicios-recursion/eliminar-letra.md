# eliminar letra


Eliminar todas las apariciones de una letra específica en una palabra o frase.


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|             |                  palabra | f(palabra, letra) |
| ----------- | -----------------------: | ----------------- |
| CB          |                       "" | ""                |
| CR resto    | "casa" (si letra es 'a') | "cs"              |
| CR completa |                  "acasa" | "cs"              |



f(palabra) = f(resto) if char == letra else char + f(resto)


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION eliminarLetra(palabra, letra)


    SI palabra es vacía ENTONCES

        Devolver ""

    FIN SI


    SI palabra[0] == letra ENTONCES

       Devolver eliminarLetra(palabra[1:], letra)

    SINO

       Devolver palabra[0] + eliminarLetra(palabra[1:], letra)

    FIN SI


FIN FUNCIÓN

```


</details>
