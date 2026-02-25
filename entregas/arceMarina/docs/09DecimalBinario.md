# 9. Conversor a binario

Convierte un número decimal a binario.

## Análisis recursivo

| Caso | n | f(n) |
|------|---|------|
| CB | 0 | "0" |
| CB | 1 | "1" |
| ... | ... | ... |
| n/2 | 3 | "11" |
| n | 6 | "110" |

Análisis de pasos:
- 6 en binario es "110".
- 3 en binario es "11".
- Por lo tanto: "110" = (binario de 3) + "0" (que es $6\%2$).

**Relación:**  $f(n) = f(n/2) + cadena(n \% 2)$

## Pseudocódigo
```text
FUNCION decimalABinario(n)
    SI n = 0 ENTONCES
        Devolver "0"
    FIN SI
    SI n = 1 ENTONCES
        Devolver "1"
    FIN SI

    Devolver decimalABinario(n / 2) + cadena(n % 2)
FIN FUNCION