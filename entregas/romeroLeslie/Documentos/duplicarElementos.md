## Duplicar elementos

Duplicar elementos en una cadena de texto expandiendo su estructura.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Tipo    | n (lista)     | f(n)            |
|---------|---------------|----------------|
| CB      | []            | []             |
| ...     | ...           | ...            |
| CR n-1  | [5, 8]        | [5, 5, 8, 8]   |
| CR n    | [4, 5, 8]     | [4, 4, 5, 5, 8, 8] |

f(n) = [cabeza] + [cabeza] + f(resto)



</div>

</details>

## Pseudocódigo
<details>
<summary>Ver pseudocódigo</summary>

FUNCIÓN duplicarElementos(lista)

    SI lista está vacía ENTONCES
        Devolver []
    FIN SI

    Devolver [lista[0]] + [lista[0]] + duplicarElementos(sublista(lista, 1))

FIN FUNCIÓN