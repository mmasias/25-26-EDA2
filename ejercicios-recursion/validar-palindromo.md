# validar palíndromo


Determinar si una palabra o frase es un palíndromo (se lee igual de izquierda a derecha que de derecha a izquierda).


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|             |  palabra | f(palabra)                               |
| ----------- | -------: | ---------------------------------------- |
| CB          | "" o "a" | verdadero                                |
| CR interior |    "aba" | verdadero                                |
| CR completa |  "radar" | verdadero (r == r y "ada" es palíndromo) |



f(palabra) = (pri == ult) AND f(interior)


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION esPalindromo(palabra)


    SI longitud(palabra) <= 1 ENTONCES

        Devolver VERDADERO

    FIN SI


    SI palabra[0] != palabra[longitud(palabra) - 1] ENTONCES

        Devolver FALSO

    FIN SI


    Devolver esPalindromo(palabra[1:longitud(palabra) - 1])


FIN FUNCIÓN

```


</details>
