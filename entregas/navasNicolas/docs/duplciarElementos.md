# En una lista, duplicar sus elementos

Toma una lista de elementos y devuelve una nueva lista donde cada elemento original aparece duplicado consecutivamente (ej. `[1,2,3]` pasa a ser `[1,1,2,2,3,3]`). La función recibe una lista como entrada.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||entrada (L)|f(L)|
|-|-:|-|
CB|[]|[]   # lista vacía → devolver lista vacía
CR elemento a duplicar|[X, ...]|[X, X] + f([...])  # duplicar el primero y evaluar resto

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION duplicarElementos(L)

    SI L está vacía ENTONCES
        Devolver []
    FIN SI

    primero <- primer elemento de L
    resto   <- L sin el primer elemento

    Devolver [primero, primero] concatenado con duplicarElementos(resto)

FIN FUNCIÓN