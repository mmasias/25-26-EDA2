### Máximo de una lista

Encontrar el elemento máximo de una lista de números.

## Análisis recursivo

<div align=center>

| Tipo   | lista     | f(lista) |
|--------|-----------|---------:|
| CB     | [4]       |        4 |
| ...    | ...       |      ... |
| CR n-1 | [2,4]     |        4 |
| CR n   | [2,2,4]   |        4 |
| ...    | ...       |      ... |
| CR n-1 | [2,4]     |        4 |
| CR n   | [5,2,4]   |        5 |

Si **cabeza > f(resto)** → f(lista) = **cabeza**  
Si **cabeza ≤ f(resto)** → f(lista) = **f(resto)**

</div>

> Idea: **cabeza** = primer elemento, **resto** = lista sin el primer elemento.

## Pseudocódigo

```text
FUNCION maximo(lista)

    SI longitud(lista) == 1 ENTONCES

        Resultado = lista[0]

    SI NO

        cabeza = primer elemento de la lista
        resto = lista sin el primer elemento

        maximoResto = maximo(resto)

        SI cabeza > maximoResto ENTONCES

            Resultado = cabeza

        SI NO

            Resultado = maximoResto

        FIN SI

    FIN SI

    Devolver Resultado

FIN FUNCIÓN