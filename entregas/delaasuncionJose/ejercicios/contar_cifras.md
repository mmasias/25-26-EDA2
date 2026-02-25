# Contar cifras de un número

Calcular cuántas cifras tiene un número entero positivo.

## Analisis recursivo

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|0|
CB|7|1|
CR n-1|12|2|
CR n|123|3|

f(123) = 1 + f(12)

</div>

Cada llamada elimina una cifra dividiendo entre 10.

## Pseudocódigo

```text
FUNCION contar_cifras(n)

    SI n es 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver 1 + contar_cifras(n / 10)

FIN FUNCIÓN