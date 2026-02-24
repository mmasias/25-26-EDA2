
## 2. Contar las cifras de un número

Cuenta cuántos dígitos tiene un número entero positivo.

<details>
<summary>Ver análisis recursivo</summary>

| | n | f(n) |
| :--- | :--- | :--- |
| **CB** | < 10 | 1 |
| ... | | |
| **CR n/10**| 42 | 2 = 1 + 1 |
| **CR n** | 425 | 3 = 1 + 2 |

`3 = 1 + f(n/10) o lo que es igual 1 + contarCifras(n / 10)`

</details>

### 🔗 Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contarCifras(n)
    SI n < 10 ENTONCES
        Devolver 1
    FIN SI
    
    Devolver 1 + contarCifras(n / 10)
FIN FUNCION