## **Elevar n al cuadrado**

<details>
<summary>Ver análisis recursivo</summary>
<br>

<div align=center>

| Tipo | n | Resultado |
| :---: | ---: | :--- |
| **CB** | 0 | `0` |
| ⋮ | ⋮ | ⋮ |
| **CR** n-1 | 3 | `9` = 4 + 6 - 1 |
| **CR** n | 4 | `16` = 9 + 8 - 1 |

**Relación recursiva:** f(4) = f(3) + 2×4 - 1 → cuadrado(n-1) + 2n - 1

</div>
</details>

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION cuadrado(n)
│
├─ SI n == 0 ENTONCES
│  └─ RETORNAR 0
│
└─ RETORNAR cuadrado(n - 1) + 2 × n - 1