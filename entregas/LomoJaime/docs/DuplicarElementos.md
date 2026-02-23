## **Duplicar elementos de una lista**

<details>
<summary>Ver análisis recursivo</summary>
<br>

<div align=center>

| Tipo | lista | Resultado |
| :---: | :--- | :--- |
| **CB** | `[]` | `[]` |
| ⋮ | ⋮ | ⋮ |
| **CR** n-1 | `[1,2]` | `[1,1,2,2]` |
| **CR** n | `[1,2,3]` | `[1,1,2,2,3,3]` |

**Relación recursiva:** f([1,2,3]) = [1,1] + f([2,3]) → [elem,elem] + duplicarElementos(resto)

</div>
</details>

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION duplicarElementos(lista)
│
├─ SI longitud(lista) == 0 ENTONCES
│  └─ RETORNAR []
│
├─ elemento = primerElemento(lista)
└─ RETORNAR [elemento, elemento] + duplicarElementos(resto(lista))