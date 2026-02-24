# Conversor a Binario

## Análisis Recursivo

<details>
<summary>Ver análisis</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|0
CB|1|1
...
...
...
n-1|5|101
n|6|110
...
...
n-1|12|1100
n|13|1101

Notemos que el último dígito siempre es el residuo de n entre 2 (n % 2). El resto de la cadena es el resultado de evaluar la función en la mitad del número (n / 2). Por lo tanto: **f(n / 2) + (n % 2) = f(n)**.

[Imágen de Análisis](/entregas/alvaradoCarlos/images/conversorBinario.jpeg)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION convierteABinario(n)

    SI n == 0 ENTONCES
        Devolver "0"
    FIN SI

    SI n == 1 ENTONCES
        Devolver "1"
    FIN SI

    Devolver convierteABinario(n / 2) + (n % 2)

FIN FUNCIÓN
```

</details>