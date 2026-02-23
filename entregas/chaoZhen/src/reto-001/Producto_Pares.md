### 1. Producto de pares hasta n

Calcular el producto de todos los números pares positivos desde 2 hasta n. Por definición, el caso base para n < 2 devolverá 1.

<details open>
<summary>Ver análisis recursivo</summary>

| | n | f(n) |
| :--- | :---: | :---: |
| CB | 0 | 1 |
| ... | | |
| ... | | |
| CR n-2 | 4 | 8 = 4x2x1 |
| CR n | 6 | 48 = 6x4x2x1 |

<br>
<center>48 = 6 x f(n-2) <i>o lo que es igual</i> <b>n * productoPares(n - 2)</b> (si n es par)</center>
</details>

### Pseudocódigo & código

<details open>
<summary>Ver pseudocódigo</summary>

```text
FUNCION productoPares(n)

    SI n < 2 ENTONCES
        Devolver 1
    FIN SI
    
    SI n MOD 2 no es 0 ENTONCES
        Devolver productoPares(n - 1)
    FIN SI
    
    Devolver n * productoPares(n - 2)
    
FIN FUNCIÓN
```
</details>