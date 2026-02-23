# Contar las cifras de un número

Calcular cuántas cifras tiene un entero positivo n.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|      |   n | f(n) |
|------|----:|----:|
| CB   |   7 |   1 |
| CR   |  12 |   2 |
| CR   | 123 |   3 |
| CR   |1234 |   4 |

4 = 1 + f(123) → 1 + f(n div 10).

</div>
</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contarCifras(n)
    SI n < 10 ENTONCES
        Devolver 1
    FIN SI
    Devolver 1 + contarCifras(n / 10) 
FIN FUNCION
