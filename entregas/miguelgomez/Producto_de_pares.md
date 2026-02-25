# productoParesHastaN

Efectuar la multiplicación de todos los valores pares comprendidos entre 2 y n.

## Análisis recursivo

<div align=center>

| Tipo    |   n |   f(n) |
|---------|----:|--------:|
| CB       |   2 |       2 |
| ...      | ... |     ... |
| CR n-1   |   6 |      48 |
| CR n     |   8 |     384 |

384 es el resultado de 8 multiplicado por 48.
**f(n) = n * f(n-2)** (si n es par)

</div>

## Pseudocódigo

```text
FUNCION calcularProductoPares(n)

    SI n == 2 ENTONCES
        Resultado = 2
    SINO
        SI n % 2 != 0 ENTONCES
            Resultado = calcularProductoPares(n - 1)
        SINO
            Resultado = n * calcularProductoPares(n - 2)
        FIN SI
    FIN SI

    Devolver Resultado

FIN FUNCIÓN