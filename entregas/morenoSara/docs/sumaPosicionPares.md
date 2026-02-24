# SUMAR ELEMENTOS EN POSICIONES PARES

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||lista|f(n)|
|-|-|-|
CB|[]|0|
...|||
n-1|[2,3]|3|
n|[2,3,4]|6|

Si indice  par => f(n-1) + cola(n) 
Si no es par => f(n-1)

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION sumarPosicionesPares(n, indice)

    SI n == [] ENTONCES
        DEVOLVER 0
    FIN SI

    SI indice es par ENTONCES
        DEVOLVER sumarPosicionesPares(n-1)+ cola(n)
    SI NO
        DEVOLVER sumarPosicionesPares(n-1)
    FIN SI

FIN FUNCION
