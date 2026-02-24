# Duplicar elementos de una lista

Dada una lista, devolver una nueva lista donde cada elemento aparezca duplicado.

Ejemplo:
[1,2,3] → [1,1,2,2,3,3]

## Análisis recursivo

| Caso | n | f(n) |
|------|---|------|
| CB | [] | [] |
| CR | [3] | [3,3] |
| CR | [2,3] | [2,2,3,3] |
| CR | [1,2,3] | [1,1,2,2,3,3] |

Resultado = [cabeza, cabeza] + f(resto)

## Pseudocódigo

FUNCION duplicarElementos(lista)

    SI lista está vacía ENTONCES
        Devolver lista vacía
    FIN SI

    cabeza = lista[0]
    resto = lista sin el primer elemento

    Devolver [cabeza, cabeza] + duplicarElementos(resto)

FIN FUNCIÓN