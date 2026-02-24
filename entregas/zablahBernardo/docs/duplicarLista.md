# duplicarElementos

Duplicar cada elemento de una lista, de modo que una lista como [1, 2, 3] se convierta en [1, 1, 2, 2, 3, 3]. Por definición, si la lista está vacía, devuelve una lista vacía.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|        | n  | f(n)                 |
|--------|-----------|----------------------|
| CB     | []        | []                   |
| ...    | ...       | ...                  |
| CR n-1 | [2, 3]    | [2, 2, 3, 3]         |
| CR n   | [1, 2, 3] | [1, 1, 2, 2, 3, 3]   |

f(n) = f(n) = [cabeza] + [cabeza] + f(n-1)

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION duplicarElementos(lista)

    SI lista está vacía ENTONCES
        Devolver []
    FIN SI

    cabeza = primer elemento de la lista
    cola = resto de la lista (n-1)

    Devolver [cabeza] + [cabeza] + duplicarElementos(cola)

FIN FUNCIÓN
```

</details>