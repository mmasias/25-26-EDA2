# En una lista, sumar elementos en posiciones pares.

En una lista, calcular la suma de los elementos que se encuentran en posiciones pares (índices 0, 2, 4...).

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|[]|0
CB|[5]|5
...|...|...
n-1|[3, 4]|3
n|[1, 2, 3, 4]|4 (que es 1 + 3)

</div>

Cabeza + f(n-1) *(lista sin los dos primeros elementos)*


</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION sumarPosicionesPares(lista)

    SI longitud(lista) es 0 ENTONCES
        Devolver 0
    FIN SI
    
    SI longitud(lista) es 1 ENTONCES
        Devolver lista[0]
    FIN SI

    cabeza = lista[0]
    resto = lista sin los dos primeros elementos

    Devolver cabeza + sumarPosicionesPares(resto)

FIN FUNCIÓN
```

</details>