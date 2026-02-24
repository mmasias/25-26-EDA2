# Producto de números pares hasta n

Calcular el producto de todos los números pares positivos desde 2 hasta *n* utilizando recursividad.

---

## Análisis recursivo

| Caso   |  n | f(n) |
|--------|---:|-----:|
| CB     |  2 | 2    |
| ...    | ...| ...  |
| CR n-1 |  4 | 8    |
| CR n   |  6 | 48   |

Se observa que:

48 = 6 · 8  

donde:

**n · productoPares(n − 2)**

Regla general:

- Si `n` es impar → `productoPares(n - 1)`
- Si `n` es par → `n * productoPares(n - 2)`
- Si `n < 2` → devolver `1`
- Si `n == 2` → devolver `2`

---

## Pseudocódigo

```text
FUNCION productoPares(n)

    SI n < 2 ENTONCES
        retornar 1
    SINO SI n == 2 ENTONCES
        retornar 2
    SINO
        SI n % 2 != 0 ENTONCES
            retornar productoPares(n - 1)
        SINO
            retornar n * productoPares(n - 2)
        FIN SI
    FIN SI

FIN FUNCION