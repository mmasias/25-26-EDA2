# ELEVAR N AL CUADRADO

Calcular n² usando la suma de impares:  
n² = (n-1)² + (2n - 1)

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|Caso|n|f(n)|
|---|---:|---:|
|CB|0|0|
|...|...|...|
|n-1|2|4|
|n|3|9|

f(n) = f(n-1) + (2n - 1)

</div>

</details>

## Pseudocódigo

```text
FUNCION cuadrado(n)

    SI n == 0 ENTONCES
        DEVOLVER 0
    FIN SI

    DEVOLVER cuadrado(n - 1) + (2*n - 1)

FIN FUNCION
```