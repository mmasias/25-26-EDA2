# En una lista, sumar elementos en posiciones pares

Calcula la suma de los elementos que se encuentran en los índices pares de una lista (posiciones 0, 2, 4...). La función recibe una lista de números y devuelve un número entero con la suma.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Caso               |           (`L`, `acc`) | `f(L, acc)`             |
| ------------------ | ---------------------: | ----------------------- |
| **Base (CB)**      |              (`[]`, 9) | 9                       |
| **Base (CB)**      |             (`[5]`, 4) | 9 (devuelve `acc + 5`)  |
| **Recursivo (CR)** |       (`[3, 4, 5]`, 1) | `f([5], acc + 3)`       |
| **Recursivo (CR)** | (`[1, 2, 3, 4, 5]`, 0) | `f([3, 4, 5], acc + 1)` |

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION sumarPosicionesPares(L, acc = 0)

    # Caso Base 1: Si la lista está vacía, devolvemos el total acumulado
    SI L está vacía ENTONCES
        Devolver acc
    FIN SI

    # Caso Base 2: Si queda solo un elemento, lo sumamos al acumulador y terminamos
    SI longitud de L == 1 ENTONCES
        Devolver acc + primer elemento de L
    FIN SI

    par   <- primer elemento de L (el que está en la posición par actual)
    resto <- L sin los dos primeros elementos (saltamos la posición impar)

    # Llamada recursiva de cola sin operaciones pendientes.
    # Sumamos el elemento 'par' al acumulador.
    Devolver sumarPosicionesPares(resto, acc + par)

FIN FUNCIÓN
```

</details>
