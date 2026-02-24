# Producto de pares hasta n

Calcular el producto de números pares hasta n

## Análisis Recursivo

<details>
<summary>Ver análisis</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|2|2
...
...
...
n-1|6|48
n|8|384
...
...
n-1|10|3840
n|12|46080

Esto implica que: **f(n-1) * n = f(n)** cuando son pares, cuando son impares se salta el número.

[Imágen de Análisis](/entregas/alvaradoCarlos/images/productoDePares.jpeg)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION multiplicarPares(n)

    SI n == 2 ENTONCES
        Devolver 2
    SI NO

        SI n es par ENTONCES
            Devolver n * multiplicarPares(n-2)
        SI NO
            Devolver multiplicarPares(n - 1)
        FIN SI

    FIN SI

FIN FUNCIÓN
```

</details>

