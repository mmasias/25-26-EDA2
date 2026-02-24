# Contar cifras de un número

Contar cifras de un número hasta n

## Análisis Recursivo

<details>
<summary>Ver análisis</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|1|1
...
...
...
n-1|11|2
n|511|3
...
...
n-1|4593411|7
n|64593411|8

Esto implica que: **f(n-1) + 1 = f(n)**, siempre que el número séa mayor o igual a 10, se sumará uno por cada nueva cifra que se agregue, de lo contrario f(n) será 1.

[Imágen de Análisis](/entregas/alvaradoCarlos/images/contarCifras.jpeg)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        Devolver 1
    SI NO
        Devolver contarCifras(n - 1) + 1  // Hecho por tabulación
        Devolver contarCifras(n / 10) + 1 // Solución real para código
    FIN SI

FIN FUNCIÓN
```

</details>
