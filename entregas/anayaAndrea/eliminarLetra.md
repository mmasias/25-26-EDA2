# eliminarLetra

Eliminar todas las apariciones de una letra en una palabra.

Ejemplo: eliminar("recursividad",'i')

## Análisis recursivo

| Caso | texto | f(texto) |
|------|-------|-----------|
| CB | "" | "" |
| ... | ... | ... |
| CR n-1 | "dad" | "dad" |
| CR n | "recursividad" | "recursvdad" |

Patrón:

Procesar carácter inicial y llamar al resto.

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION eliminar(texto, letra)

    SI texto == "" ENTONCES
        devolver ""
    FIN SI

    SI texto[0] == letra ENTONCES
        devolver eliminar(texto[1:], letra)
    FIN SI

    devolver texto[0] + eliminar(texto[1:], letra)

FIN FUNCION