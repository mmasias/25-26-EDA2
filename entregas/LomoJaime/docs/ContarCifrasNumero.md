## **Contar las cifras de un número**

<details>
<summary>Ver análisis recursivo</summary>
<br>

<div align=center>

| Tipo | n | Resultado |
| :---: | ---: | :--- |
| **CB** | 5 | `1` |
| ⋮ | ⋮ | ⋮ |
| **CR** n-1 | 123 | `3` = 1 + contarCifras(12) |
| **CR** n | 1234 | `4` = 1 + contarCifras(123) |

**Relación recursiva:** f(1234) = 1 + f(123) → 1 + contarCifras(n / 10)

</div>
</details>

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contarCifras(n)
│
├─ SI n < 10 ENTONCES
│  └─ RETORNAR 1
│
└─ RETORNAR 1 + contarCifras(n / 10)