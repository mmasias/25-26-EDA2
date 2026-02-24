# En una lista, duplicar sus elementos ([1,2,3] convertirla en [1,1,2,2,3,3])

Dada una lista, duplicar cada uno de sus elementos secuencialmente.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|[]|[]
...|...|...
n-1|[2, 3]|[2, 2, 3, 3]
n|[1, 2, 3]|[1, 1, 2, 2, 3, 3]

</div>

[Cabeza, Cabeza] + f(n-1)


</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION duplicarElementos(lista)

    SI longitud(lista) es 0 ENTONCES
        Devolver lista vacía
    FIN SI

    cabeza = lista[0]
    resto = lista sin el primer elemento

    Devolver lista formada por [cabeza, cabeza] + duplicarElementos(resto)

FIN FUNCIÓN
```

</details>