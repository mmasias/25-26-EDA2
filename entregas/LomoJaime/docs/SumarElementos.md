## **Sumar elementos en posiciones pares**

<details>
<summary>Ver análisis recursivo</summary>
<br>

<div align=center>

| Tipo | lista | Resultado |
| :---: | :--- | :--- |
| **CB** | `[]` | `0` |
| ⋮ | ⋮ | ⋮ |
| **CR** n-2 | `[1,2,3]` | `4` = 1 + 3 |
| **CR** n | `[1,2,3,4,5]` | `9` = 1 + 3 + 5 |

**Relación recursiva:** f([1,2,3,4,5]) = 1 + f([3,4,5]) → primero + sumarPosPares(saltarDos)

</div>
</details>

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION sumarPosicionesPares(lista)
│
├─ SI longitud(lista) == 0 ENTONCES
│  └─ RETORNAR 0
│
├─ SI longitud(lista) == 1 ENTONCES
│  └─ RETORNAR primerElemento(lista)
│
└─ RETORNAR primerElemento(lista) + sumarPosicionesPares(saltarDos(lista))