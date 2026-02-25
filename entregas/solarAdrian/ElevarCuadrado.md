## Potencia cuadrada de un valor

Calcular el cuadrado de un número entero positivo `x` de forma recursiva, utilizando la relación matemática entre cuadrados consecutivos. Por definición, el cuadrado de 0 es 0.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||x|F(x)|
|-|-:|-|
CB|0|0
...
...
...
CR x-1|4|16 = 9 + 8 - 1
CR x|5|25 = 16 + 10 - 1


25 = 16 + 10 - 1 *o lo que es igual* **potencia_dos(x-1) + 2*x - 1**

</div>

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION potencia_dos(x)

    SI x es 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver potencia_dos(x - 1) + 2 * x - 1

FIN FUNCIÓN