### Filtrar lista

Filtrar una lista manteniendo solo los elementos **mayores** que un umbral dado.

## Análisis recursivo

<div align=center>

| Tipo   | lista, umbral | f(lista, umbral) |
|--------|----------------|------------------|
| CB     | [], 3          | []               |
| ...    | ...            | ...              |
| CR n-1 | [5], 3         | [5]              |
| CR n   | [4,5], 3       | [4,5]            |
| ...    | ...            | ...              |
| CR n-1 | [2,3,4,5], 3   | [4,5]            |
| CR n   | [1,2,3,4,5], 3 | [4,5]            |

Si **cabeza > umbral** → f(lista, umbral) = **[cabeza] + f(resto, umbral)**  
Si **cabeza ≤ umbral** → f(lista, umbral) = **f(resto, umbral)**

</div>

> Idea: **cabeza** = primer elemento, **resto** = lista sin el primer elemento.

## Pseudocódigo

```text
FUNCION filtrarLista(lista, umbral)

    SI lista está vacía ENTONCES

        Resultado = []

    SI NO

        cabeza = primer elemento de la lista
        resto = lista sin el primer elemento

        resultadoResto = filtrarLista(resto, umbral)

        SI cabeza > umbral ENTONCES

            Resultado = [cabeza] + resultadoResto

        SI NO

            Resultado = resultadoResto

        FIN SI

    FIN SI

    Devolver Resultado

FIN FUNCIÓN