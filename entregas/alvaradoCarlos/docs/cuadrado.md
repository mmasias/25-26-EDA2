# Elevar n al cuadrado

Elevar un número al cuadrado hasta n

## Análisis Recursivo

<details>
<summary>Ver análisis</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0²|0
CB|1²|1
...
...
...
n-1|5²|25
n|6²|36
...
...
n-1|6²|36
n|7²|49

Si restamos *f(n)* y *f(n-1)* vemos que siempre devuelve un número igual al que obtenemos si multiplicamos (n * 2) y le restamos 1 (un impar). Entonces usando n, sin el cuadrado, tomamos: **f(n-1) + 2(n) - 1 = f(n)** 

[Imágen de Análisis](/entregas/alvaradoCarlos/images/elevarAlCuadrado.jpeg)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION elevarAlCuadrado(n)

    SI n == 0 ENTONCES
        Devolver 0
    FIN SI

    SI n == 1 ENTONCES
        Devolver 1
    FIN SI

    Devolver elevarAlCuadrado(n - 1) + (2 * n) - 1

FIN FUNCIÓN
```

</details>
