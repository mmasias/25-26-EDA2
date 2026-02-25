# 7. Duplicar elementos de una lista

Toma una lista [a, b, c] y devuelve [a, a, b, b, c, c].

## Análisis recursivo

| Caso | lista | f(lista) |
|------|-------|----------|
| CB | [] | [] |
| ... | ... | ... |
| cola | [2,3] | [2,2,3,3] |
| n | [1,2,3] | [1,1,2,2,3,3] |

**Relación:** $f(n) = [cabeza, cabeza] + f(cola)$

## Pseudocódigo
```text
FUNCION duplicarElementos(lista)
    SI lista es vacía ENTONCES
        Devolver []
    FIN SI

    cabeza = obtenerCabeza(lista)
    Devolver [cabeza, cabeza] + duplicarElementos(obtenerCola(lista))
FIN FUNCION