# sumarPosicionesPares

Sumar elementos en posiciones pares.

Ejemplo: [5,3,8,1,4]

## Análisis recursivo

| Caso | lista | f(lista) |
|------|--------|-----------|
| CB | [] | 0 |
| ... | ... | ... |
| CR n-1 | [8,1,4] | 12 |
| CR n | [5,3,8,1,4] | 17 |

Patrón:

Sumar índice 0 + recursión i+2.

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION sumaPares(lista, i)

    SI i >= tamaño(lista) ENTONCES
        devolver 0
    FIN SI

    devolver lista[i] + sumaPares(lista, i+2)

FIN FUNCION