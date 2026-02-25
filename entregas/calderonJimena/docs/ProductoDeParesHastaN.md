# Producto de pares hasta n

## Análisis recursivo

<div align=center>

| Tipo | n | f(n) |
|------|---:|-----:|
| CB   | 2 | 2 |
| CR   | 4 | 8 |
| CR   | 6 | 48 |

f(n) = n * f(n - 2)  (si n es par)

</div>

## Pseudocódigo

```text
FUNCION productoPares(n)

    SI n == 2 ENTONCES
        Resultado = 2
    SI NO
        SI n % 2 != 0 ENTONCES
            Resultado = productoPares(n - 1)
        SINO
            Resultado = n * productoPares(n - 2)
        FIN SI
    FIN SI

    Devolver Resultado

FIN FUNCION
