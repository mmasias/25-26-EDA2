### 7. En una lista, duplicar sus elementos

<details open>
<summary>Ver análisis recursivo</summary>

Asumiendo la lista `L = [1, 2, 3]`:

| | n | f(n) |
| :--- | :---: | :---: |
| CB | [] | [] |
| ... | | |
| CR n-1 | [3] | [3, 3] |
| CR n | [2, 3] | [2, 2, 3, 3] |

<br>
<center>[2, 2, 3, 3] = Cabeza + f(n-1)</center>
</details>

### Pseudocódigo

<details open>
<summary>Ver pseudocódigo</summary>

```text
FUNCION duplicarElementos(L)

    SI n esta vacia ENTONCES
        Devolver []
    FIN SI
    
    Devolver [cabeza, cabeza] + duplicarElementos(n-1)
    
FIN FUNCIÓN
```
</details>