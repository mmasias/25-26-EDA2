# Elevar un número al cuadrado

Calcular el cuadrado de un número entero positivo *n* aplicando recursividad.

---

## Análisis recursivo

| Caso   | n | f(n) |
|--------|--:|-----:|
| CB     | 0 | 0    |
| ...    | ..| ...  |
| CR n-1 | 3 | 9    |
| CR n   | 4 | 16   |

Se observa que:

16 = 9 + 7  

donde:

**n² = (n − 1)² + (2n − 1)**

Regla general:

- Si `n == 0` → devolver `0`  
- Si `n > 0` → `cuadrado(n - 1) + (2n - 1)`

---

## Pseudocódigo

```text
FUNCION cuadrado(n)

    SI n == 0 ENTONCES
        retornar 0
    SINO
        retornar cuadrado(n - 1) + (2 * n - 1)
    FIN SI

FIN FUNCION