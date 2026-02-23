### 2. Contar las cifras de un número

Calcular la cantidad de dígitos que componen un número entero positivo n. Por definición, un número menor a 10 tiene 1 cifra.

<details open>
<summary>Ver análisis recursivo</summary>

| | n | f(n) |
| :--- | :---: | :---: |
| CB | 4 | 1 |
| ... | | |
| CR n/10 | 45 | 2 = 1 + 1 |
| CR n | 456 | 3 = 1 + 2 |

<br>
<center>3 = 1 + f(n/10) <i>o lo que es igual</i> <b>1 + contarCifras(n / 10)</b></center>
</details>

### Pseudocódigo & código

<details open>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        Devolver 1
    FIN SI
    
    Devolver 1 + contarCifras(n / 10) // División entera
    
FIN FUNCIÓN
```
</details>

---
