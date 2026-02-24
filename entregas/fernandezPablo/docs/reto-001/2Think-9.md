## 9. Conversor a binario

<details>
<summary>Ver análisis recursivo</summary>

| | n | f(n) |
| :--- | :--- | :--- |
| **CB** | 0 o 1 | "0" o "1" |
| ... | | |
| **CR n/2**| 2 | "10" |
| **CR n** | 5 | "101" = "10" + "1" |

`"101" = f(n/2) + cadena(n modulo 2) o lo que es igual aBinario(n / 2) + cadena(n % 2)`

</details>

### 🔗 Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION aBinario(n)
    SI n == 0 ENTONCES
        Devolver "0"
    FIN SI
    SI n == 1 ENTONCES
        Devolver "1"
    FIN SI
    
    Devolver aBinario(n / 2) + cadena(n % 2)
FIN FUNCION