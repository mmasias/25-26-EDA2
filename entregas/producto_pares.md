# Producto de pares hasta n

Calcular el producto de todos los números pares positivos desde 2 hasta $n$.

## Análisis recursivo

<div align=center>

| Tipo    | n   | f(n) |
|---------|----:|-----:|
| CB      | 1   |    1 |
| ...     | ... |  ... |
| CR n-1  | 5   |    8 |
| CR n    | 6   |   48 |

El producto de pares hasta 5 es 8 (2 * 4)  
El producto de pares hasta 6 es 48 (2 * 4 * 6)  

48 = 6 * 8  
→ **f(n) = n * f(n-1)** *(si n es par)* → **f(n) = f(n-1)** *(si n es impar)* *(Nota: Usamos 1 como caso base para no anular el producto con un 0)*
</div>

## Pseudocódigo

```text
FUNCION productoPares(n)

    SI n < 2 ENTONCES
        Resultado = 1
    SINO
        SI n % 2 == 0 ENTONCES
            Resultado = n * productoPares(n - 1)
        SINO
            Resultado = productoPares(n - 1)
        FIN SI
    FIN SI

    Devolver Resultado

FIN FUNCIÓN 