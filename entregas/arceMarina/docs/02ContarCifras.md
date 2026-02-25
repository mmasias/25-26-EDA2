# Contar cifras de un número

## Análisis recursivo

| Caso | n | f(n) |
|------|---|------|
| CB | 7 | 1 |
| ... | ... | ... |
| n−1 | 45 | 2 |
| n | 345 | 3 |

Análisis de pasos:
- 456 tiene 3 cifras
- 45 tiene 2 cifras.
- Por lo tanto: $3 = 1 + (cantidad\ de\ cifras\ de\ 45)$.

**Relación:** $f(n) = 1 + f(n / 10)$

## Pseudocódigo
```text
FUNCION contarCifras(n)
    SI n < 10 ENTONCES
        Devolver 1
    FIN SI
    
    Devolver 1 + contarCifras(n / 10)
FIN FUNCION