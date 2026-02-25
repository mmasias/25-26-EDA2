# En una lista, duplicar sus elementos

Toma una lista de elementos y devuelve una nueva lista donde cada elemento original aparece duplicado consecutivamente (ej. `[1,2,3]` pasa a ser `[1,1,2,2,3,3]`). La función recibe una lista como entrada.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Caso               |               (L, acc) | f(L, acc)                       |
| ------------------ | ---------------------: | ------------------------------- |
| **Base (CB)**      |    ([ ], [a, a, b, b]) | [a, a, b, b]                    |
|                    |    ([c], [a, a, b, b]) | $f([ ], acc + [c, c])$          |
|                    |                    ... | ...                             |
| **Recursivo (CR)** | ([a, b, c, d, e], [ ]) | $f([b, c, d, e], acc + [a, a])$ |

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION duplicarElementos(L, acc = [])

    # Caso Base: Si la lista original está vacía, devolvemos lo acumulado
    SI L está vacía ENTONCES
        Devolver acc
    FIN SI

    primero <- primer elemento de L
    resto   <- L sin el primer elemento

    # Llamada recursiva de cola sin operaciones pendientes.
    # Agregamos el par duplicado al final del acumulador en el propio llamado.
    Devolver duplicarElementos(resto, acc concatenado con [primero, primero])

FIN FUNCIÓN
```

</details>
