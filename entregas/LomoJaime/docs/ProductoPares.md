## **Producto de pares hasta n**

<details>
<summary>Ver análisis recursivo</summary>
<br>

<div align=center>

| Tipo | n | Resultado |
| :---: | ---: | :--- |
| **CB** | 0 | `1` |
| **CB** | 1 | `1` |
| ⋮ | ⋮ | ⋮ |
| **CR** n-2 | 6 | `48` = 6×4×2×1 |
| **CR** n | 8 | `384` = 8×6×4×2×1 |

**Relación recursiva:** f(8) = 8 × f(6) → n × productoPares(n - 2)

</div>
</details>

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION productoPares(n)
│
├─ SI n < 2 ENTONCES
│  └─ RETORNAR 1
│
├─ SI n es par ENTONCES
│  └─ RETORNAR n × productoPares(n - 2)
│
└─ RETORNAR productoPares(n - 1)