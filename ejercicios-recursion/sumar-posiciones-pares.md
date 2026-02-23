# sumar posiciones pares


Sumar los elementos de una lista que se encuentran en posiciones pares (0, 2, 4...).


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|             |       lista | f(lista)                                                 |
| ----------- | ----------: | -------------------------------------------------------- |
| CB          |          [] | 0                                                        |
| CR resto    |     [3,4,5] | 5 (salta el 3 y el 4 no es par relativo al inicio total) |
| CR completa | [1,2,3,4,5] | 1 + 3 + 5 = 9                                            |



f(lista) = lista[0] + f(lista[2:])


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION sumarPares(lista)


    SI lista es vacía ENTONCES

        Devolver 0

    FIN SI


    SI longitud(lista) == 1 ENTONCES

        Devolver lista[0]

    FIN SI


    Devolver lista[0] + sumarPares(lista[2:])


FIN FUNCIÓN

```


</details>
