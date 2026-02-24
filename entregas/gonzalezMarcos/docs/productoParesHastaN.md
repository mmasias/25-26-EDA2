# Producto de pares hasta n

Calcular el producto de todos los números pares hasta un número n dado.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|< 2|1
...|...|...
n-1|4|8 (4x2)
n|6|48 (6x4x2)

</div>

- Si n es par --> n * f(n-1)
- Si n es impar --> f(n-1)

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION productoPares(n)

    SI n < 2 ENTONCES
        Devolver 1
    FIN SI

    SI n módulo 2 es igual a 0 ENTONCES
        Devolver n * productoPares(n - 1)
    SI NO
        Devolver productoPares(n - 1)
    FIN SI

FIN FUNCIÓN
```

</details>