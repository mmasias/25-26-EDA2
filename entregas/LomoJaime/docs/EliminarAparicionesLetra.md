## **Eliminar apariciones de una letra**

<details>
<summary>Ver análisis recursivo</summary>
<br>

<div align=center>

| Tipo | palabra | Resultado |
| :---: | :--- | :--- |
| **CB** | `""` | `""` |
| ⋮ | ⋮ | ⋮ |
| **CR** n-1 | `"hol"` | `"ol"` |
| **CR** n | `"hola"` | `"ola"` |

**Relación recursiva:** f("hola") = f("ola") → eliminarLetra(resto, letra)

</div>
</details>

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION eliminarLetra(palabra, letra)
│
├─ SI longitud(palabra) == 0 ENTONCES
│  └─ RETORNAR ""
│
├─ SI primerCaracter(palabra) == letra ENTONCES
│  └─ RETORNAR eliminarLetra(resto(palabra), letra)
│
└─ RETORNAR primerCaracter(palabra) + eliminarLetra(resto(palabra), letra)