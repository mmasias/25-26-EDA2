## Elevar un número al cuadrado

Calcular el cuadrado de un número entero positivo n mediante una función recursiva. 


<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Tipo | n | f(n) |
|------|---|------|
| CB | 0 | 0 |
| CB | 1 | 1 |
| ... | ... | ... |
| CR | 2 | 4 = 3 + f(1) |
| CR n-1 | 3 | 9 = 5 + f(2) |
| CR n | 4 | 16 = 7 + f(3) |

f(n) = (2n - 1) + f(n - 1)

</div>

</details>

## Pseudocódigo
<details>
<summary>Ver pseudocódigo</summary>

FUNCIÓN cuadradoN(n)

    SI n == 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver (2 * n - 1) + cuadradoN(n - 1)

FIN FUNCIÓN