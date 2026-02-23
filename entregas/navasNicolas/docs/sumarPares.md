# En una lista, sumar elementos en posiciones pares

Calcula la suma de los elementos que se encuentran en los índices pares de una lista (posiciones 0, 2, 4...). La función recibe una lista de números y devuelve un número entero con la suma.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||entrada (L)|f(L)|
|-|-:|-|
CB|[]|0
CB|[1]|1
||...|...|
CR |[1, 2, 3, 4, 5, 6]|6 (f(n-2)+(n-2))
CR |[1, 2, 3, 4, 5, 6, 7]|12 (f(n-2)+(n-2))
</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION sumarPosicionesPares(L)

    SI L está vacía ENTONCES
        Devolver 0
    FIN SI

    SI longitud de L == 1 ENTONCES
        Devolver primer elemento de L
    FIN SI

    par   <- primer elemento de L (posición 0)
    resto <- L sin los dos primeros elementos (saltando posición 1)

    Devolver par + sumarPosicionesPares(resto)

FIN FUNCIÓN