## Contar las cifras de un número
 
 Contar cuantas cifras tiene un número entero

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Tipo | n  | f(n) |
|------|----|------|
| CB | 3 | 1 |
| CB | 1 | 1 |
| ... | ... | ... |
| CR | 17 | 2 = 1 + f(1) |
| CR n-1 | 34 | 2 = 1 + f(3) |
| CR n | 345 | 3 = 1 + f(34) |

f(n) = 1 + f(n / 10)

</div>

</details>

## Pseudocódigo
<details>
<summary>Ver pseudocódigo</summary>

FUNCIÓN contarCifras(n)

    SI n < 10 ENTONCES
        Devolver 1
    FIN SI

    Devolver 1 + contarCifras(n / 10)

FIN FUNCIÓN


