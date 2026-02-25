# replicarElementosLista

Duplicar la presencia de cada ítem dentro de un arreglo (ej: [1,2,3] → [1,1,2,2,3,3]).

## Análisis recursivo

<div align=center>
| Tipo    | lista     | f(n)               |
|---------|-----------|-------------------|
| CB       | []        | []                |
| ...      | ...       | ...               |
| CR n-1   | [4,8]     | [4,4,8,8]         |
| CR n     | [1,4,8]   | [1,1,4,4,8,8]     |

[1,1,4,4,8,8] es la unión de [1,1] con el resultado de [4,4,8,8].

**Doble cabeza + f(resto_de_lista)**

</div>

## Pseudocódigo

```text
FUNCION duplicarItems(lista)

    SI lista está vacía ENTONCES
        Resultado = []
    SINO
        Cabeza = lista[0]
        ColaProcesada = duplicarItems(lista[1...final])
        Resultado = [Cabeza, Cabeza] + ColaProcesada
    FIN SI

    Devolver Resultado

FIN FUNCIÓN