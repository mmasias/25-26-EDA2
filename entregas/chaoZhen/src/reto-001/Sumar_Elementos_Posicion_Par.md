### 8. En una lista, sumar elementos en posiciones pares

<details open>
<summary>Ver análisis recursivo</summary>

Asumiendo la lista `n = [10, 20, 30, 40, 50]` (Los índices pares son 0, 2, 4 que corresponden a 10, 30, 50):

| | n | f(n) |
| :--- | :---: | :---: |
| CB | [] | 0 |
| ... | | |
| CR n-1 | [30, 40, 50] | 80 = 30 + 50 |
| CR n | [10, 20, 30, 40, 50] | 90 = 10 + 80 |

<br>
<center>90 = cabeza + f(n-1) <i>o lo que es igual</i> <b>cabeza + sumarPares()</b></center>
</details>

### Pseudocódigo

<details open>
<summary>Ver pseudocódigo</summary>

FUNCION sumarPosicionesPares(L)

    SI esta vaía ENTONCES
        Devolver 0
    FIN SI
    
    cabeza = L[0]
    sublista_par = sublista(n, desde_indice_par)
    
    Devolver cabeza + sumarPosicionesPares(sublista_par)
    
FIN FUNCIÓN
</details>