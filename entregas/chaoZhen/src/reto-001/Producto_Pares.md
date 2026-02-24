### 1. Producto de pares hasta n

<details open>
<summary>Ver análisis recursivo</summary>

| | n | f(n) |
| :--- | :---: | :---: |
| CB | 0 | 1 |
| ... | | |
| ... | | |
| CR n-1 | 4 | 8 = 4x2x1 |
| CR n | 6 | 48 = 6x4x2x1 |

<br>
<center>48 = 6 x f(n-1) <i>o lo que es igual</i> <b>n * productoPares(n - 1)</b></center>
</details>

### Pseudocódigo

<details open>
<summary>Ver pseudocódigo</summary>

```text
FUNCION productoPares(n)

    SI n < 2 ENTONCES
        Devolver 1
    FIN SI
    
    SI n%2 no es 0 ENTONCES
        Devolver productoPares(n - 1)
    FIN SI
    
    Devolver n * productoPares(n - 1)
    
FIN FUNCIÓN
```
</details>