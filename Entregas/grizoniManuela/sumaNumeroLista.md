### Suma de números de una lista

Calcular la suma de todos los números de una lista.

## Análisis recursivo

<div align=center>

| Tipo   | lista      | f(lista) |
|--------|------------|---------:|
| CB     | []         |        0 |
| ...    | ...        |      ... |
| CR n-1 | [2,3,4,5]  |       14 |
| CR n   | [1,2,3,4,5]|       15 |

15 = 1 + 14 → **cabeza + f(resto)**

</div>

> Idea: **cabeza** = primer elemento, **resto** = lista sin el primer elemento.

## Pseudocódigo

```text
FUNCION sumaNumerosLista(lista)

    SI lista está vacía ENTONCES

        Resultado = 0

    SI NO

        cabeza = primer elemento de la lista
        resto = lista sin el primer elemento

        Resultado = cabeza + sumaNumerosLista(resto)

    FIN SI

    Devolver Resultado

FIN FUNCIÓN