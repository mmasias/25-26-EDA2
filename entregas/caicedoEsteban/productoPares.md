# Producto de pares hasta n

Calcular el producto de todos los números pares desde 2 hasta n. Por definición, el producto de pares hasta 0 es 1.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Caso               | (n, acc) | f(n, acc)      |
| :----------------- | :------- | :------------- |
| **Base (CB)**      | (0, 48)  | 48             |
| **Recursivo (CR)** | (1, 1)   | `f(0, 1)`      |
| ...                |          |                |
| **Recursivo (CR)** | (2, 24)  | `f(0, 24 * 2)` |
| **Recursivo (CR)** | (4, 6)   | `f(2, 6 * 4)`  |
| **Recursivo (CR)** | (6, 1)   | `f(4, 1 * 6)`  |

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION productoPares(n, acc = 1)

    # Caso Base: Si n llega a 0 o menos, devolvemos el total acumulado
    SI n <= 0 ENTONCES
        Devolver acc
    FIN SI

    # Si n es impar, restamos 1 para volverlo par y no alteramos el acumulador
    SI n MOD 2 != 0 ENTONCES
        Devolver productoPares(n - 1, acc)
    FIN SI

    # Llamada recursiva de cola sin operaciones pendientes.
    # Multiplicamos el número par actual por el acumulador.
    Devolver productoPares(n - 2, acc * n)

FIN FUNCIÓN
```

</details>
