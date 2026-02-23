## Producto de pares hasta n

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|1
CB|1|1
...|...|...
...|...|...
CR n-2|6|48 = 6×4×2×1
CR n|8|384 = 8×6×4×2×1

384 = 8 × f(6) *o lo que es igual* **n × productoPares(n-2)**

</div>

</details>

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION productoPares(n)

    SI n < 2 ENTONCES
        Devolver 1
    FIN SI

    SI n es par ENTONCES
        Devolver n × productoPares(n - 2)
    FIN SI

    Devolver productoPares(n - 1)

FIN FUNCIÓN