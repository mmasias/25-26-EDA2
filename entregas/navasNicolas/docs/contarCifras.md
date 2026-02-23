# Contar cifras de un número

Calcular el número de cifras (dígitos) que tiene un número entero en base 10. Por convención, el número 0 tiene 1 cifra. Para números negativos, se considera su valor absoluto.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>


| Caso | n | f(n) |
| :--- | :--- | :--- |
| **Base (CB)** |  5 | 1 |
|  |  15 | 2 |                
| **Recursivo (CR)** | 315 | 3 ($1 + f(n -1)$) | 

</div>

</details>

## Pseudocódigo

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