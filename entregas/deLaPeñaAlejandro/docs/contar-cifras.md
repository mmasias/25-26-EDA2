# Contar las cifras de un número

Calcular cuántas cifras tiene un número entero positivo *n*.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|        |    n | f(n) |
| ------ | ---: | ---- |
| CB     |    7 | 1    |
| ...    |  ... | ...  |
| CR n-1 |   45 | 2    |
| CR n   |  345 | 3    |

3 = 1 + 2, *siendo* **1 + contarCifras(n / 10)**

Si n < 10 ⇒ 1  
Si n ≥ 10 ⇒ 1 + contarCifras(n / 10)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        Resultado = 1
    SINO
        Resultado = 1 + contarCifras(n / 10)
    FIN SI

    DEVOLVER Resultado

FIN FUNCION
```

</details>