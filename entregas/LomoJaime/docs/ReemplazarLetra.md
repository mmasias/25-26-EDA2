## **Reemplazar una letra por otra**

<details>
<summary>Ver análisis recursivo</summary>
<br>

<div align=center>

| Tipo | palabra | Resultado |
| :---: | :--- | :--- |
| **CB** | `""` | `""` |
| ⋮ | ⋮ | ⋮ |
| **CR** n-1 | `"hol"` | `"hol"` |
| **CR** n | `"hola"` | `"holb"` |

**Relación recursiva:** f("hola") = f("hol") + "b" → reemplazarLetra(resto) + nueva

</div>
</details>

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION reemplazarLetra(palabra, vieja, nueva)
│
├─ SI longitud(palabra) == 0 ENTONCES
│  └─ RETORNAR ""
│
├─ SI primerCaracter(palabra) == vieja ENTONCES
│  └─ RETORNAR nueva + reemplazarLetra(resto(palabra), vieja, nueva)
│
└─ RETORNAR primerCaracter(palabra) + reemplazarLetra(resto(palabra), vieja, nueva)