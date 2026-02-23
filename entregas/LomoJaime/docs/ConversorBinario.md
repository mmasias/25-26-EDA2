## **Conversor a binario**

<details>
<summary>Ver análisis recursivo</summary>
<br>

<div align=center>

| Tipo | n | Resultado |
| :---: | ---: | :--- |
| **CB** | 0 | `"0"` |
| **CB** | 1 | `"1"` |
| ⋮ | ⋮ | ⋮ |
| **CR** n-1 | 5 | `"101"` |
| **CR** n | 10 | `"1010"` |

**Relación recursiva:** f(10) = f(5) + "0" → aBinario(n/2) + caracter(n%2)

</div>
</details>

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION aBinario(n)
│
├─ SI n == 0 ENTONCES
│  └─ RETORNAR "0"
│
├─ SI n == 1 ENTONCES
│  └─ RETORNAR "1"
│
└─ RETORNAR aBinario(n / 2) + convertirCaracter(n % 2)