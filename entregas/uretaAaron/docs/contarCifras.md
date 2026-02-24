# Calcular cuántos dígitos tiene un número entero positivo *n*.

---

## Explicación recursiva

| Caso        |   n  | resultado |
|------------|-----:|----------:|
| Caso base  |   8  | 1         |
| ...        |  ... | ...       |
| Paso n-1   |  52  | 2         |
| Paso n     | 452  | 3         |

Se observa que:

3 = 1 + 2  

Es decir:

**1 + contarDigitos(n / 10)**

- Si `n < 10` → el resultado es `1`
- Si `n ≥ 10` → el resultado es `1 + contarDigitos(n / 10)`

---

## Pseudocódigo

```text
FUNCION contarDigitos(n)

    SI n < 10 ENTONCES
        retornar 1
    SINO
        retornar 1 + contarDigitos(n / 10)
    FIN SI

FIN FUNCION