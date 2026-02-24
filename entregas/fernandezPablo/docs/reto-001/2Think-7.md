## 7. En una lista, duplicar sus elementos

<details>
<summary>Ver análisis recursivo</summary>

| | lista (L) | f(L) |
| :--- | :--- | :--- |
| **CB** | [] | [] |
| ... | | |
| **CR n-1**| [2, 3] | [2, 2, 3, 3] |
| **CR n** | [1, 2, 3] | [1, 1, 2, 2, 3, 3] |

`[1, 1, ...] = [L[0], L[0]] + f(L[1:])`

</details>

### 🔗 Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION duplicarElementos(lista)
    SI estaVacia(lista) ENTONCES
        Devolver []
    FIN SI
    
    Devolver [lista[0], lista[0]] + duplicarElementos(lista[1:])
FIN FUNCION