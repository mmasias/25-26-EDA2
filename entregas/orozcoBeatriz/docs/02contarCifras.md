# CONTAR LAS CIFRAS DE UN NÚMERO

Contar cuántas cifras tiene n (n >= 0), sin dividir entre 10.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|Caso|n|f(n)|
|---|---:|---:|
|CB|0|1|
|CB|7|1|
|...|...|...|
|n-1|34|2|
|n|234|3|

f(n) = 1 + f(cociente10(n))   (si n >= 10)

</div>

</details>

## Pseudocódigo

```text
FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        DEVOLVER 1
    FIN SI

    DEVOLVER 1 + contarCifras(cociente10(n))

FIN FUNCION
```