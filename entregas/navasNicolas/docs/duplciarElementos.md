# En una lista, duplicar sus elementos

Toma una lista de elementos y devuelve una nueva lista donde cada elemento original aparece duplicado consecutivamente (ej. `[1,2,3]` pasa a ser `[1,1,2,2,3,3]`). La función recibe una lista como entrada.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|Caso|Lista|f(L)|
|-|-:|-|
|Base (CB)|[ ]|[ ]
||[ a ]|[ a, a ]
||...|...
||...|...
||[ a, b, c, d, f, e ]|[a, a, b, b, c, c, d, d, f, f, e, e ]
|Recursivo CR|[a, b, c, d, f, e, g]|[a, a, b, b, c, c, d, d, f, f, e, e, g, g] (f(L-1) + cola, cola)

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