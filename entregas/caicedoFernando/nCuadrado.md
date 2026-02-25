# cuadradoRecursivo
Calcular el cuadrado de un número entero positivo de forma recursiva sumando números impares consecutivos.

## Análisis recursivo
<div align=center>

| Tipo    | n   | f(n) |
|---------|----:|-----:|
| CB      | 1   | 1    |
| CR n-1  | 2   | 4    |
| CR n-1  | 3   | 9    |
| CR n    | 4   | 16   |

El cuadrado de 4 es 16
El cuadrado de 3 es 9
16 = 7 + 9  (donde 7 es el 4º número impar)
→ **f(n) = (2 * n - 1) + f(n - 1)**
(donde *(2 * n - 1)* es el n-ésimo número impar y *f(n - 1)* es el cuadrado del número anterior)

</div>

## Pseudocódigo
```text
FUNCION cuadradoRecursivo(n)
    SI n == 1 ENTONCES
        Resultado = 1
    SINO
        Resultado = (2 * n - 1) + cuadradoRecursivo(n - 1)
    FIN SI
    Devolver Resultado
FIN FUNCIÓN