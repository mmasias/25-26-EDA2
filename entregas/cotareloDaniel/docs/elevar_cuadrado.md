# nAlCuadrado

Calcular el cuadrado de un número entero positivo recursivamente.

## Análisis recursivo

<div align=center>

| Tipo    | n | f(n) |
|---------|--:|------:|
| CB      | 0 |     0 |
| ...     | ..|    .. |
| CR n-1  | 3 |     9 |
| CR n    | 4 |    16 |

16 = 9 + (2·4 - 1)  
→ **f(n-1) + 2·n - 1**

</div>

## Pseudocódigo

```text
FUNCION nAlCuadrado(n)

    SI n == 0 ENTONCES
        Resultado = 0
    SINO
        Resultado = nAlCuadrado(n - 1) + 2 * n - 1
    FIN SI

    Devolver Resultado

FIN FUNCIÓN
