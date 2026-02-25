# Duplicar elementos de una lista

Convertir [1,2,3] en [1,1,2,2,3,3]

## Analisis recursivo

<div align=center>

||lista|f(lista)|
|-|-|-|
CB|[]|[]|
CR|[1,2]|[1,1,2,2]|

</div>

Se duplica el primer elemento y se concatena el resto.

## Pseudocódigo

```text
FUNCION duplicar(lista)

    SI lista está vacía ENTONCES
        Devolver []
    FIN SI

    Devolver [primero, primero] + duplicar(resto)

FIN FUNCIÓN