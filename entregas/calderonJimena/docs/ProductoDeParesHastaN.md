# Producto de pares hasta n

Calcular el producto de todos los números pares positivos desde 1 hasta n.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|      | n | f(n) |
|------|--:|----:|
| CB   | 0 |   1 |
| CB   | 1 |   1 |
| CR 2 | 2 |   2 |
| CR 4 | 4 |   8 |
| CR 6 | 6 |  48 |

48 = 6 × f(4) = 6 × 8 → n * f(n−2) cuando n es par.

</div>
</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION productoPares(n)
    SI n <= 1 ENTONCES
        Devolver 1
    FIN SI

    SI n ES IMPAR ENTONCES
        Devolver productoPares(n - 1)
    SINO
        Devolver n * productoPares(n - 2)
    FIN SI
FIN FUNCION
