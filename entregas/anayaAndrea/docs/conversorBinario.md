# conversorBinario

Convertir un número entero positivo a binario.

Ejemplo: n = 19

## Análisis recursivo

Ejemplo: n = 37

| Caso | n | f(n) |
|------|----|------|
| CB | 1 | "1" |
| ... | ... | ... |
| CR n-1 | 18 | "10010" |
| CR n | 37 | "100101" |

Patrón de recursividad:

f(n) = string(n) si n < 2  
f(n) = f(n / 2) + string(n % 2)

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION binario(n)

    SI n < 2 ENTONCES
        devolver string(n)
    FIN SI

    devolver binario(n / 2) + string(n % 2)

FIN FUNCION