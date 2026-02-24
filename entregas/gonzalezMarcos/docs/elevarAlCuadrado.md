# Elevar n al cuadrado

Elevar un número n al cuadrado de forma recursiva (basado en la propiedad matemática).

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|0
...|...|...
n-1|4|16
n|5|25

</div>

Propiedad matemática: $n^2 = (n-1)^2 + 2n - 1$

- f(n-1) + (2 * n) - 1


</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION elevarCuadrado(n)

    SI n es 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver elevarCuadrado(n - 1) + (2 * n) - 1

FIN FUNCIÓN
```

</details>