# Contar cifras de un número

Calcular el número de cifras (dígitos) que tiene un número entero en base 10. Por convención, el número 0 tiene 1 cifra. Para números negativos, se considera su valor absoluto.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|1
CB|1|1
CB|7|1
...|  | 
CR n/10|15|2 = 1 + f(1)
CR n|123|3 = 1 + f(12)

3 = 1 + 2 *o lo que es igual* **1 + contarCifras(12)** *(cuando n tiene más de una cifra)*

</div>

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contarCifras(n)

    n <- valor absoluto de n

    SI n es menor o igual a 9 ENTONCES
        Devolver 1
    FIN SI

    Devolver 1 + contarCifras(n DIV 10)   # División entera

FIN FUNCIÓN
```

</details>