# Contar las cifras de un número

Contar la cantidad de cifras que tiene un número entero.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|< 10|1
...|...|...
n-1|45|2
n|456|3

</div>

1 + f(n / 10)  *(división entera)*


</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        Devolver 1
    FIN SI

    Devolver 1 + contarCifras(n división entera entre 10)

FIN FUNCIÓN
```

</details>