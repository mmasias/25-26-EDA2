# cuadradoN

Calcular el cuadrado de un número entero positivo n basándose en la suma de los primeros n números impares de forma recursiva. Por definición, el cuadrado de 0 es 0.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|        | n | f(n)                |
|--------|--:|---------------------|
| CB     | 0 | 0                   |
| CB     | 1 | 1                   |
| ...    |...| ...                 |
| CR n-1 | 3 | 9 = 4 + 5           |
| CR n   | 4 | 16 = 9 + 7          |
| CR n   | 5 | 25 = 16 + 9 = f(4) + 9 |

f(n) = ((2 * n) - 1) + f(n - 1)

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION cuadradoN(n)

    SI n es 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver (2 * n - 1) + cuadradoN(n - 1)

FIN FUNCIÓN
```

</details>