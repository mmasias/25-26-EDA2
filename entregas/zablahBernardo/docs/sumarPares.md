# sumarPosicionesPares

Sumar los elementos que se encuentran en las posiciones pares de una lista (considerando el primer elemento en la posición 0, que se asume como par). Por definición, si la lista está vacía, la suma es 0.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|        | n (lista) | f(n)                 |
|--------|-----------|----------------------|
| CB     | []        | 0                    |
| ...    | ...       | ...                  |
| CR n-1 | [2, 3]    | 0 + f([3]) = 3       |
| CR n   | [1, 2, 3] | 1 + 3 = 4            |

Si la posición actual es par:
f(n) = f(n) = cabeza + f(n-1)

Si la posición actual es impar:
f(n) = f(n) = 0 + f(n-1)


</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION sumarPosicionesPares(lista, esPar)

    SI lista está vacía ENTONCES
        Devolver 0
    FIN SI

    cabeza = primer elemento de la lista
    cola = resto de la lista (n-1)

    SI esPar es Verdadero ENTONCES
        Devolver cabeza + sumarPosicionesPares(cola, Falso)
    SI NO
        Devolver sumarPosicionesPares(cola, Verdadero)
    FIN SI

FIN FUNCIÓN
```

</details>