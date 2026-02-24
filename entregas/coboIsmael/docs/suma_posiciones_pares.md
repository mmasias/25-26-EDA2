# Sumar elementos en posiciones pares

Sumar los elementos ubicados en posiciones pares (0,2,4,...) de una lista.

## Análisis recursivo

| Caso | n | f(n) |
|------|---|------|
| CB | [] | 0 |
| CB | [5] | 5 |
| CR | [5,9] | 5 |
| CR | [5,9,2] | 7 |
| CR | [5,9,2,8,1] | 8 |

Resultado = cabeza + f(lista desde posición 2)

## Pseudocódigo

FUNCION sumarPosicionesPares(lista)

    SI longitud(lista) es 0 ENTONCES
        Devolver 0
    FIN SI

    SI longitud(lista) es 1 ENTONCES
        Devolver lista[0]
    FIN SI

    cabeza = lista[0]
    resto = sublista desde posición 2 hasta el final

    Devolver cabeza + sumarPosicionesPares(resto)

FIN FUNCIÓN