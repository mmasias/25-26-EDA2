### 2. Contar las cifras de un número

<details open>
<summary>Ver análisis recursivo</summary>

| | n | f(n) |
| :--- | :---: | :---: |
| **CB** | 4 | **1** |
| ... | | |
| **CR n-1** | 45 | **2** = 1 + 1 |
| **CR n** | 456 | **3** = 1 + 2 |

<br>
<center>3 = 1 + f(45) <i>o lo que es igual</i> <b>1 + contarCifras(n-1)</b></center>
</details>

### Pseudocódigo

<details open>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        Devolver 1
    FIN SI
    
    Devolver 1 + contarCifras(n - 1) 
    
FIN FUNCIÓN