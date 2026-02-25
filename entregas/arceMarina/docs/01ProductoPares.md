## 1. Producto de pares hasta n
Calcula la multiplicación de todos los números pares desde $n$ hasta el primer par positivo (2).

### Análisis recursivo
| | n | f(n) |
| :--- | :--- | :--- |
| **CB** | 2 | 2 |
| ... | ... | ... |
| **n-2** | 4 | 8 ($2 \times 4$) |
| **n** | 6 | 48 ($2 \times 4 \times 6$) |

**Análisis de pasos:** 
- El producto de pares hasta 6 es 48.
- El producto de pares hasta 4 es 8.
- Por lo tanto: $48 = 6 \times (producto\ de\ pares\ hasta\ 4)$.

**Relación:** $f(n) = n \times f(n-2)$  

### Pseudocódigo
```text
FUNCION productoPares(n)
    SI n <= 2 ENTONCES
        Devolver 2
    FIN SI
    
    SI n % 2 no es 0 ENTONCES
        Devolver productoPares(n - 1)
    SINO
        Devolver n * productoPares(n - 2)
    FIN SI
FIN FUNCION