# Contar las cifras de un número
Calcular la cantidad de cifras de un número entero positivo.
## Análisis recursivo
<div align=center>
| Tipo    |   n |   f(n) |
|---------|----:|-------:|
| CB      |   1 |      1 |
| ...     | ... |    ... |
| CR n-1  |  38 |      2 |
| CR n    | 385 |      3 |
3 = 1 + 2 → 1 + f(n/10)  
</div>
## Pseudocódigo
```text
FUNCION contarCifras(n)

    SI n < 10 ENTONCES

        Devolver 1

    SINO

        Devolver 1 + contarCifras(n/10)

    FIN SI

FIN FUNCIÓN
```