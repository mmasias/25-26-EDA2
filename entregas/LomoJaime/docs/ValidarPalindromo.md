## **Validar palíndromo**
<details>
<summary>Ver análisis recursivo</summary>
<br>

<div align=center>

| Tipo | palabra | Resultado |
| :---: | :--- | :--- |
| **CB** | `"a"` | `verdadero` |
| **CB** | `""` | `verdadero` |
| ⋮ | ⋮ | ⋮ |
| **CR** n-2 | `"ana"` | `verdadero` |
| **CR** n | `"anana"` | `verdadero` |

**Relación recursiva:** f("anana") = (a==a) AND f("nan") → primero==ultimo AND esPalindromo(medio)

</div>
</details>

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION esPalindromo(palabra)
│
├─ SI longitud(palabra) <= 1 ENTONCES
│  └─ RETORNAR verdadero
│
├─ SI primerCaracter != ultimoCaracter ENTONCES
│  └─ RETORNAR falso
│
└─ RETORNAR esPalindromo(medio(palabra))