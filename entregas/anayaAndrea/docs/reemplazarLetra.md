# reemplazarLetra

Reemplazar una letra por otra.

Ejemplo: reemplazar("estructura",'e','a')

## Análisis recursivo

| Caso | texto | f(texto) |
|------|--------|-----------|
| CB | "" | "" |
| ... | ... | ... |
| CR n-1 | "structura" | "structura" |
| CR n | "estructura" | "astructura" |

Patrón:

Procesar carácter inicial.

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION reemplazar(texto, a, b)

    SI texto == "" ENTONCES
        devolver ""
    FIN SI

    SI texto[0] == a ENTONCES
        devolver b + reemplazar(texto[1:], a, b)
    FIN SI

    devolver texto[0] + reemplazar(texto[1:], a, b)

FIN FUNCION