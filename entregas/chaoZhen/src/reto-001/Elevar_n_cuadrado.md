### 3. Elevar n al cuadrado

<details open>
<summary>Ver análisis recursivo</summary>

| | n | f(n) |
| :--- | :---: | :---: |
| CB | 0 | 0 |
| ... | | |
| CR n-1 | 2 | 4 = 1 + 2(2) - 1 |
| CR n | 3 | 9 = 4 + 2(3) - 1 |

<br>
<center>9 = f(n-1) + 2(3) - 1 <i>o lo que es igual</i> <b>cuadrado(n - 1) + 2*n - 1</b></center>
</details>

### Pseudocódigo

<details open>
<summary>Ver pseudocódigo</summary>

```text
FUNCION cuadrado(n)

    SI n es 0 ENTONCES
        Devolver 0
    FIN SI
    
    Devolver cuadrado(n - 1) + (2 * n) - 1
    
FIN FUNCIÓN
```
</details>
