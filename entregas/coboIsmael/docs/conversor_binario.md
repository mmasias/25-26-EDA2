# Conversor a binario

Convertir un número entero n ≥ 0 a su representación binaria.

## Análisis recursivo

| Caso | n | f(n) |
|------|---|------|
| CB | 0 | "0" |
| CB | 1 | "1" |
| CR | 2 | "10" |
| CR | 5 | "101" |
| CR | 9 | "1001" |
| CR | 18 | "10010" |

Resultado = f(n / 2) + (n % 2)

## Pseudocódigo

FUNCION aBinario(n)

    SI n < 2 ENTONCES
        Devolver convertirAString(n)
    FIN SI

    Devolver aBinario(n / 2) + convertirAString(n % 2)

FIN FUNCIÓN