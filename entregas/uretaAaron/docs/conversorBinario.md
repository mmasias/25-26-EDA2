Transformar un número entero positivo *n* a su representación en sistema binario usando recursividad.

**Ejemplo:**  
13 → 1101

---

## Análisis recursivo

Ejemplo con `n = 13`

| Caso |  n  | f(n)  |
|------|----:|-------|
| CB   |  0  | ""    |
| CB   |  1  | "1"   |
| ...  | ... | ...   |
| CR   |  6  | "110" |
| CR   | 13  | "1101"|

Se cumple que:

"1101" = convertirBinario(n / 2) + (n % 2)

Regla general:

- Si `n < 2` → devolver `n` convertido a texto  
- Si `n ≥ 2` → `convertirBinario(n / 2) + (n % 2)`

---

## Pseudocódigo

```text
FUNCION convertirBinario(n)

    SI n < 2 ENTONCES
        retornar convertir n a texto
    SINO
        retornar convertirBinario(n / 2) + (n % 2)
    FIN SI

FIN FUNCION