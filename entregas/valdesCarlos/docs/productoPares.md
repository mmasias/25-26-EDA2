# productoPares

Calcular el producto de todos los números pares desde 2 hasta un número dado `n`.

## Análisis recursivo

<div align=center>

| Tipo    | n | f(n) |
|---------|---|------|
| CB      | <2| 1    |
| ...     |...|...   |
| CR n-1  | 4 | 8    |
| CR n    | 6 | 48   |

En n = 6:

- Valor actual = 6 (es par)
- Siguiente paso = n - 1 → f(4) = 8

Patrón de recursividad:

- Si `n < 2` → **f(n) = 1**
- Si `n` es impar → **f(n) = f(n-1)**
- Si `n` es par → **f(n) = n * f(n-2)**

</div>

## Pseudocódigo

```text
FUNCION productoPares(n)

    SI n < 2 ENTONCES
        Resultado = 1
    SINO
        SI n MOD 2 == 0 ENTONCES
            Resultado = n * productoPares(n - 2)
        SINO
            Resultado = productoPares(n - 1)
        FIN SI
    FIN SI

    Devolver Resultado

FIN FUNCIÓN