# Elevar n al cuadrado

El resultado de n a la potencia de 2.

## Análisis recursivo

<div align=center>

| Tipo    | n   | f(n) |
|---------|----:|------:|
| CB      | 0   |    0 |
| ...     | ... |  ... |
| CR n-1  | 4   |   16  |
| CR n    | 5   |    25 |

25= 16 + (5 * 2) -1
 **f(n-1) + 2·n - 1**

</div>

## Pseudocódigo

```text
FUNCION nAlCuadrado(n)

    SI n == 0 ENTONCES
        Resultado = 0
    SINO
        Resultado = nAlCuadrado(n - 1) + (2 * n) - 1
    FIN SI

    Devolver Resultado

FIN FUNCIÓN