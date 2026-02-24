# Producto de pares hasta n

Calcular el producto de todos los números pares positivos desde 2 hasta n.

## Análisis recursivo

<div align=center>

| Tipo    |   n |   f(n) |
|---------|----:|--------:|
| CB      |   2 |       2 |
| ...     | ... |     ... |
| CR n-1  |   6 |      48 |
| CR n    |   8 |     384 |

384 = 8 × 48 = n * f(n - 1)

</div>

## Pseudocódigo

```text

FUNCION productoPares(n)

    SI n == 2 ENTONCES
      
        Resultado = 2

    SINO
        SI n % 2 != 0 ENTONCES
            
            Resultado = productoPares(n - 1)
        SINO
           
            Resultado = n * productoPares(n - 2)
        FIN SI
    FIN SI

    Devolver Resultado

FIN FUNCIÓN