# Elevar n al cuadrado

Calcular el cuadrado de un número entero positivo *n* utilizando recursividad.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|        | n | f(n) |
| ------ | -:| ---- |
| CB     | 0 | 0    |
| ...    | ..| ...  |
| CR n-1 | 3 | 9    |
| CR n   | 4 | 16   |

16 = 9 + 7, *siendo*  
**n² = (n − 1)² + 2n − 1**

Si n == 0 ⇒ 0  
Si n > 0 ⇒ cuadrado(n − 1) + (2n − 1)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION cuadrado(n)

    SI n == 0 ENTONCES
        Resultado = 0
    SINO
        Resultado = cuadrado(n - 1) + (2 * n - 1)
    FIN SI

    DEVOLVER Resultado

FIN FUNCION
```

</details>