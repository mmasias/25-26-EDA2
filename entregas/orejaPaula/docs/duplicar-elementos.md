# Duplicar elementos


Duplicar cada elemento de una lista.


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|        | lista     | f(lista)        |
| ------ | --------- | --------------- |
| CB     | []        | []              |
| ...    | ...       | ...             |
| CR n-1 | [2,3]     | [2,2,3,3]       |
| CR n   | [1,2,3]   | [1,1,2,2,3,3]   |



[cabeza,cabeza] + duplicar(n - 1)


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION duplicar(lista)


    SI lista está vacía ENTONCES

        Resultado = []

    SINO

        cabeza = lista[0]
        resto = lista sin el primero

        Resultado = [cabeza, cabeza] + duplicar(resto)

    FIN SI


    Devolver Resultado


FIN FUNCIÓN
