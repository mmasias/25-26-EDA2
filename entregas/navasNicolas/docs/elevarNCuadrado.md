# Elevar n al cuadrado

Elevar cualquier digito a su respectivo valor al cuadrado.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|0
CB|1|1
CB|7|49
...|  | 
CR n|8|64 = f(n - 1) + f(2 * n - 1)


</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION elevarAlCuadrado(n)

    SI n es igual a 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver elevarAlCuadrado(n - 1) + (2 * n - 1)

FIN FUNCIÓN
```

</details>