# Elevar n al cuadrado

Calcular el cuadrado de un número entero positivo `n` sumando impares sucesivos (propiedad matemática: el cuadrado de `n` es igual al cuadrado de `n-1` más `2n - 1`).

## Análisis recursivo

<div align=center>

| Tipo    | n   | f(n) |
|---------|----:|-----:|
| CB      | 0   |    0 |
| ...     | ... |  ... |
| CR n-1  | 4   |   16 |
| CR n    | 5   |   25 |

El cuadrado de 4 es 16  
El cuadrado de 5 es 25  

25 = 16 + 9 *(donde 9 es el quinto número impar: 2 * 5 - 1)* → **f(n) = f(n-1) + (2 * n - 1)** </div>

## Pseudocódigo

```text
FUNCION cuadrado(n)

    SI n == 0 ENTONCES
        Resultado = 0
    SINO
        NumeroImpar = (2 * n) - 1
        Resultado = NumeroImpar + cuadrado(n - 1)
    FIN SI

    Devolver Resultado

FIN FUNCIÓN