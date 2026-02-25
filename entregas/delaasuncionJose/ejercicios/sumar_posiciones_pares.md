# Sumar elementos en posiciones pares

Sumar elementos en índice 0, 2, 4, ...

## Analisis recursivo

<div align=center>

||lista|f(lista)|
|-|-|-|
CB|[]|0|
CR|[1,2,3]|4|

</div>

Se suma el primero y se salta uno.

## Pseudocódigo

```text
FUNCION suma_pares(lista)

    SI lista está vacía ENTONCES
        Devolver 0
    FIN SI

    SI solo tiene un elemento ENTONCES
        Devolver primero
    FIN SI

    Devolver primero + suma_pares(lista desde posición 2)

FIN FUNCIÓN