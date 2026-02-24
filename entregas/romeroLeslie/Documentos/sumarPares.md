## Sumar posiciones pares

Sumar aquellos elementos que se encuentren en posiciones pares dentro de una lista.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Tipo    | n (lista), esPar | f(n)            |
|---------|-----------------|----------------|
| CB      | [], _           | 0              |
| ...     | ...             | ...            |
| CR n-1  | [2, 3], F       | f([3], V) = 3  |
| CR n    | [1, 2, 3], V    | 1 + f([2, 3], F) = 4 |

Si esPar == Verdadero: 
f(n) = cabeza + f(resto, Falso)

Si esPar == Falso: 
f(n) = f(resto, Verdadero)$


</div>

</details>

## Pseudocódigo
<details>
<summary>Ver pseudocódigo</summary>

FUNCION sumarPosicionesPares(lista, esPar)

    SI lista está vacía ENTONCES
        Devolver 0
    FIN SI

    SI esPar == Verdadero ENTONCES
        Devolver lista[0] + sumarPosicionesPares(sublista(lista, 1), Falso)
    SI NO
        Devolver sumarPosicionesPares(sublista(lista, 1), Verdadero)
    FIN SI

FIN FUNCIÓN