## Productos pares hasta n

Calcula el producto de todos los números pares positivos hasta n. Por definición, el producto más pequeño (caso base) es el del primer número par positivo, que es 2.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|     | n | f(n) |
|-----|---|------|
| CB | 2 | 2 |
| ... | ... | ... |
| CR n-1 | 4 | 8 = 4 x 2 |
| CR n | 6 | 48 = 6 x f(4) |

f(n) = n * f(n - 2)

</div>

</details>

## Pseudocódigo
<details>
<summary>Ver pseudocódigo</summary>

FUNCIÓN productoPares(n)

    SI n <= 2 ENTONCES
        Devolver 2
    FIN SI
    
    Devolver n * productoPares(n - 2)

FIN FUNCIÓN