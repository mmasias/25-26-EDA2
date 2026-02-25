# Elevar n al cuadrado
Calcular el cuadrado de un número entero positivo `n` usando recursividad.
## Análisis recursivo
<div align=center>
| Tipo    |   n |   f(n) |
|---------|----:|-------:|
| CB      |   1 |      1 |
| ...     | ... |    ... |
| CR n-1  |   5 |     25 |
| CR n    |   6 |     36 |
36 = 25 + 6 + 5 → f(n-1) + n + (n-1)
</div>
## Pseudocódigo
```text
FUNCION cuadrado(n)

    SI n == 1 ENTONCES

        Devolver 1

    SINO

        Devolver cuadrado(n - 1) + n + (n - 1)

    FIN SI

FIN FUNCIÓN
```