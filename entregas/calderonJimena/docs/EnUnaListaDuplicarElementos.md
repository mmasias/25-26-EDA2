# En una lista, duplicar sus elementos ([1,2,3] → [1,1,2,2,3,3])

## Análisis recursivo

<div align=center>

| Tipo | Lista     | f(lista)          |
|------|-----------|-------------------|
| CB   | []        | []                |
| ...  | ...       | ...               |
| CR   | [1,2,3]   | [1,1,2,2,3,3]     |

f([x] + resto) = [x,x] + f(resto)

</div>

## Pseudocódigo

```text
FUNCION duplicarElementos(lista)

    SI lista ESTA VACIA ENTONCES

        Resultado = []

    SI NO

        primero = PRIMER_ELEMENTO(lista)
        resto   = RESTO(lista)

        Resultado = [primero, primero] + duplicarElementos(resto)

    FIN SI

    Devolver Resultado

FIN FUNCIÓN