# productoPares

Calcular el producto de todos los números enteros positivos pares desde 1 hasta n. Por definición, si n es menor o igual a 1, el producto será 1.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|        | n | f(n)       |
|--------|--:|------------|
| CB     | 0 | 1          |
| CB     | 1 | 1          |
| ...    |...| ...        |
| CR n-1 | 5 | 8 = 4x2    |
| CR n   | 6 | 48 = 6x4x2 |
| CR n   | 7 | 48 = f(6)  |

n es par ==> n * f(n-1)

n es impar ==> f(n-1)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION productoPares(n)

    SI n <= 1 ENTONCES
        Devolver 1
    FIN SI

    SI n módulo 2 es 0 ENTONCES
        Devolver n * productoPares(n - 1)
    SI NO
        Devolver productoPares(n - 1)
    FIN SI

FIN FUNCIÓN
```

</details>