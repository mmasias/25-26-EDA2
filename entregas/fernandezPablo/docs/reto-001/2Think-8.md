## 8. En una lista, sumar elementos en posiciones pares

<details>
<summary>Ver análisis recursivo</summary>

| | lista (L) | f(L) |
| :--- | :--- | :--- |
| **CB** | [] o [x] | 0 o x |
| ... | | |
| **CR n-2**| [3, 4] | 3 |
| **CR n** | [1, 2, 3, 4]| 4 = 1 + 3 |

`4 = L[0] + f(L[2:]) o lo que es igual L[0] + sumarPosicionesPares(L[2:])`

</details>

### 🔗 Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION sumarPosicionesPares(lista)
    SI estaVacia(lista) ENTONCES
        Devolver 0
    FIN SI
    SI longitud(lista) == 1 ENTONCES
        Devolver lista[0]
    FIN SI
    
    Devolver lista[0] + sumarPosicionesPares(lista[2:])
FIN FUNCION