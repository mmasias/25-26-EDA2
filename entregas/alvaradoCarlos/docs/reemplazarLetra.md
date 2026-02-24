# Reemplazar Letra

En una palabra/frase, reemplazar una letra por otra

## Análisis Recursivo

<details>
<summary>Ver análisis</summary>

<div align=center>

||n, A, B|f(n)|
|-|-:|-|
CB|""|""
...
...
...
n-1|ATAR|BTBR
n|MATAR|MBTBR
...
...
n-1|LAS|LBS
n|ALAS|BLBS

Básicamente si la letra a ser reemplazada (A) se encuentra en la cabeza de la cadena, únicamente se pone el reemplazo y se añade *f(n-1)*. Y si no está en la cabeza, solo se añade esa cabeza a *f(n-1)* de esta forma: **n[0] o cabeza + f(n-1)**

[Imágen de Análisis](/entregas/alvaradoCarlos/images/reemplazarLetra.jpeg)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION reemplazarLetra(n, letraAReemplazar, reemplazo)

    SI n == "" ENTONCES
        Devolver ""
    FIN SI

    SI n[0] == letraAReemplazar
        Devolver reemplazo + reemplazarLetra(n - 1, letraAReemplazar, reemplazo)
    SI NO
        Devolver n[0] + reemplazarLetra(n - 1, letraAReemplazar, reemplazo)
    FIN SI

FIN FUNCIÓN
```

</details>
