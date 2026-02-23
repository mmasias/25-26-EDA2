# Producto de pares hasta n

Calcular el producto de números pares hasta n

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|0
...
...
...
CR n-1|10 x 12|120
CR n|6 x 10 x 12|720

Esto implica que: **f(n-1) * cabeza = 720**

Osea: **120 * 6 = 720**

</div>

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION productosDePares(n)

    SI n es 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver productosDePares(n - 1) * cabeza

FIN FUNCIÓN
```

</details>

