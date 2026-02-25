# productoPares
Calcular el producto de todos los números pares positivos menores o iguales a un número dado n.

## Análisis recursivo
<div align=center>

| Tipo    | n   | f(n) |
|---------|----:|-----:|
| CB      | 0   | 1    |
| CR n-1  | 1   | 1    |
| CR n-2  | 2   | 2    |
| CR n-2  | 4   | 8    |
| CR n    | 6   | 48   |

El producto de pares hasta 6 es 48
El producto de pares hasta 4 es 8
48 = 6 * 8
→ **f(n) = n * f(n - 2)** (si n es par)
→ **f(n) = f(n - 1)** (si n es impar, lo ignoramos y pasamos al anterior)

</div>

## Pseudocódigo
```text
FUNCION productoPares(n)
    SI n <= 0 ENTONCES
        Resultado = 1
    SINO SI n MOD 2 != 0 ENTONCES
        Resultado = productoPares(n - 1)
    SINO
        Resultado = n * productoPares(n - 2)
    FIN SI
    Devolver Resultado
FIN FUNCIÓN