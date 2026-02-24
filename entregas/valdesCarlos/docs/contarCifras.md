# contarCifras

Cuenta el número de dígitos (cifras) que tiene un número entero positivo.

## Análisis recursivo

<div align=center>

| Tipo    | n   | f(n) |
|---------|-----|------|
| CB      | 9   | 1    |
|...      |...  |...   |
| CR n-1  | 50  | 2    |
| CR n    | 100 | 3    |


Patrón de recursividad:

- Si `n < 10` (una sola cifra) → **f(n) = 1**
- Si `n >= 10` → **f(n) = 1 + f(n / 10)** (división entera)

</div>

## Pseudocódigo

```text
FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        Resultado = 1
    SINO
        restoDiv = n / 10  // División entera sin decimales
        Resultado = 1 + contarCifras(restoDiv)
    FIN SI

    Devolver Resultado

FIN FUNCIÓN