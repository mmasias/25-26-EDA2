# DUPLICAR ELEMENTOS DE UNA LISTA

[1,2,3] → [1,1,2,2,3,3]

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|Caso|lista|f(lista)|
|---|---|---|
|CB|[]|[]|
|...|...|...|
|n-1|[1,2]|[1,1,2,2]|
|n|[1,2,3]|[1,1,2,2,3,3]|

f(lista) = [primero, primero] + f(resto)

</div>

</details>

## Pseudocódigo

```text
FUNCION duplicar(lista)

    SI lista ESTA VACIA ENTONCES
        DEVOLVER []
    FIN SI

    primero = lista[0]
    resto = sublista desde posición 1

    DEVOLVER [primero, primero] + duplicar(resto)

FIN FUNCION
```