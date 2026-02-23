# duplicar elementos


Dada una lista, duplicar cada uno de sus elementos (ej: [1,2,3] -> [1,1,2,2,3,3]).


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


||lista|f(lista)|

|-|-:|-|

CB|[]|[]

CR resto| [2,3] | [2,2,3,3]

CR completa| [1,2,3] | [1,1,2,2,3,3]



f(lista) = [elem, elem] + f(resto)


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION duplicarElementos(lista)


    SI lista es vacía ENTONCES

        Devolver []

    FIN SI


    Elemento = lista[0]

    RestoDuplicado = duplicarElementos(lista[1:])


    Devolver [Elemento, Elemento] + RestoDuplicado


FIN FUNCIÓN

```


</details>
