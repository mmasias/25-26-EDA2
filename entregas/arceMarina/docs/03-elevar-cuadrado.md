# 3. Elevar n al cuadrado

Calcula $n^2$ utilizando únicamente sumas y la propiedad:

$n^2 = (n-1)^2 + 2n - 1$

## Análisis recursivo

| Caso | n | f(n) |
|------|---|------|
| CB | 0 | 0 |
| ... | ... | ... |
| n−1 | 4 | 16 |
| n | 5 | 25 |

Análisis de pasos:
- $3^2$ es 9.
- $2^2$ es 4.
- Usando la propiedad: $9 = 4 + (2 \times 3 - 1)$.

**Relación:**  
$f(n) = f(n-1) + (2 \times n - 1)$

## Pseudocódigo
```text
FUNCION elevarCuadrado(n)
    SI n = 0 ENTONCES
       Devolver 0
    FIN SI

    Devolver elevarCuadrado(n - 1) + (2 * n - 1)
FIN FUNCION