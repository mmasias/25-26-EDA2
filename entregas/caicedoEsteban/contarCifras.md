# Contar cifras de un número

Calcular el número de cifras (dígitos) que tiene un número entero en base 10. Por convención, el número 0 tiene 1 cifra. Para números negativos, se considera su valor absoluto.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Caso               | (n, acc) | f(n, acc)  |
| :----------------- | :------- | :--------- |
| **Base (CB)**      | (5, 0)   | 1          |
|                    | (15, 0)  | 2          |
| **Recursivo (CR)** | (315, 0) | $f(31, 1)$ |

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contarCifras(n, acc = 0)

    # Se aplica el valor absoluto solo en la primera llamada
    SI acc es igual a 0 ENTONCES
        n <- valor absoluto de n
    FIN SI

    SI n es menor o igual a 9 ENTONCES
        Devolver acc + 1
    FIN SI

    # Llamada recursiva de cola (sin operaciones pendientes)
    Devolver contarCifras(n DIV 10, acc + 1)

FIN FUNCIÓN
```

</details>
