### 7. En una lista, duplicar sus elementos

Dada una lista, devolver una nueva lista donde cada elemento de la original aparezca dos veces seguidas.

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

### Pseudocódigo & código

<details open>
<summary>Ver pseudocódigo</summary>

```text
FUNCION duplicarElementos(L)

    SI n esta vacia ENTONCES
        Devolver []
    FIN SI
    
    Devolver [n[0], n[0]] + duplicarElementos(restoDeLista(n))
    
FIN FUNCIÓN
```
</details>