## 1. Producto de pares hasta n

Calcula el producto de todos los números pares positivos hasta `n` (asumiendo que `n` es par y mayor o igual a 2).

<details>
<summary>Ver análisis recursivo</summary>

| | n | f(n) |
| :--- | :--- | :--- |
| **CB** | 2 | 2 |
| ... | | |
| **CR n-2**| 4 | 8 = 4 x 2 |
| **CR n** | 6 | 48 = 6 x 8 |

`48 = 6 x f(n-2) o lo que es igual n * productoPares(n - 2)`

</details>

### 🔗 Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION productoPares(n)
    SI n <= 2 ENTONCES
        Devolver 2
    FIN SI
    
    Devolver n * productoPares(n - 2)
FIN FUNCION