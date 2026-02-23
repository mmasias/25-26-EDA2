### 8. En una lista, sumar elementos en posiciones pares

Dada una lista, sumar los elementos que ocupan los índices pares (0, 2, 4...).

<details open>
<summary>Ver análisis recursivo</summary>

Asumiendo la lista `L = [10, 20, 30, 40, 50]` (Los índices pares son 0, 2, 4 que corresponden a 10, 30, 50):

| | n | f(n) |
| :--- | :---: | :---: |
| CB | [50] | 50 |
| ... | | |
| CR n-2 | [30, 40, 50] | 80 = 30 + 50 |
| CR n | [10, 20, 30, 40, 50] | 90 = 10 + 80 |

<br>
<center>90 = 10 + f(n-2) <i>o lo que es igual</i> <b>n[0] + sumarPares(L[2..n])</b></center>
</details>

### Pseudocódigo & código

<details open>
<summary>Ver pseudocódigo</summary>

```text
FUNCION sumarPares(n)

    SI L esta vacia ENTONCES
        Devolver 0
    FIN SI
    
    SI longitud(L) es 1 ENTONCES
        Devolver n[0]
    FIN SI
    
    Devolver n[0] + sumarPares(sublista(L, desde_indice_2_hasta_final))
    
FIN FUNCIÓN
```
</details>