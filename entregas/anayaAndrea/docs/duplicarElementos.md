# duplicarElementosLista

Duplicar cada elemento de una lista.

Ejemplo: [2,4,6]

## Análisis recursivo

| Caso | lista | f(lista) |
|------|--------|-----------|
| CB | [] | [] |
| ... | ... | ... |
| CR n-1 | [4,6] | [4,4,6,6] |
| CR n | [2,4,6] | [2,2,4,4,6,6] |

Patrón:

Procesar cabeza.

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION duplicar(lista)

    SI lista vacía ENTONCES
        devolver []
    FIN SI

    devolver [lista[0], lista[0]] + duplicar(lista[1:])

FIN FUNCION