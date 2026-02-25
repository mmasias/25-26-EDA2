# Contar las cifras de un número

## Análisis recursivo

<div align=center>

| Tipo    |    n | f(n) |
|---------|-----:|-----:|
| CB      |    7 |    1 |
| ...     |  ... |  ... |
| CR n-1  |   25 |    2 |
| CR n    |  356 |    3 |

3 = 1 + 2  →  1 + f(n / 10)

</div>

## Pseudocódigo

```text
FUNCION contarCifras(n)

    SI n < 10 ENTONCES

        Resultado = 1

    SI NO

        Resultado = 1 + contarCifras(n / 10)

    FIN SI

    Devolver Resultado

FIN FUNCIÓN
