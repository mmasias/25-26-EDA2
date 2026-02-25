# Contar las cifras de un número

## Análisis recursivo

| Tipo | n | f(n) |
|------|---:|-----:|
| CB   | 7 | 1 |
| CR   | 25 | 2 |
| CR   | 356 | 3 |

f(n) = 1 + f(n / 10)

## Pseudocódigo

FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        Resultado = 1
    SI NO
        Resultado = 1 + contarCifras(n / 10)
    FIN SI

    Devolver Resultado

FIN FUNCION
