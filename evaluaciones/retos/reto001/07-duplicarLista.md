# En una lista, duplicar sus elementos ([1,2,3] convertirla en [1,1,2,2,3,3])

## Análisis recursivo

| Tipo | Entrada | Salida |
|------|---------|--------|
| CB | [] | [] |
| CR n-1 | [2, 3] | [2, 2, 3, 3] |
| CR n | [1, 2, 3] | [1, 1, 2, 2, 3, 3] |

**Observación en aspa:**
- Tomo el primer elemento y lo duplico
- Concateno con el resultado recursivo del resto

**Relación recursiva:** `duplicar([x, ...resto]) = [x, x] + duplicar(resto)`

## Pseudocódigo

```
funcion duplicarElementos(lista)
    si lista == [] entonces
        devolver []
    sino
        devolver [lista[0], lista[0]] + duplicarElementos(lista[1:])
    fin si
fin funcion
```
