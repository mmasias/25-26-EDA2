# Duplicar elementos de una lista

Dada una lista, devolver una nueva lista donde cada elemento de la original aparezca dos veces consecutivas (ejemplo: `[1, 2, 3]` se convierte en `[1, 1, 2, 2, 3, 3]`).

## Análisis recursivo

<div align=center>

| Tipo    | lista     | f(lista)            |
|---------|-----------|---------------------|
| CB      | []        | []                  |
| ...     | ...       | ...                 |
| CR n-1  | [2, 3]    | [2, 2, 3, 3]        |
| CR n    | [1, 2, 3] | [1, 1, 2, 2, 3, 3]  |

Duplicar `[2, 3]` resulta en `[2, 2, 3, 3]`  
Duplicar `[1, 2, 3]` resulta en `[1, 1, 2, 2, 3, 3]`  

`[1, 1, 2, 2, 3, 3]` = `[1, 1]` + `[2, 2, 3, 3]`  
→ **f(lista) = [cabeza, cabeza] + f(resto de la lista)** </div>

## Pseudocódigo

```text
FUNCION duplicarElementos(lista)

    SI lista es vacia ENTONCES
        Resultado = []
    SINO
        Cabeza = lista[0]
        RestoLista = lista[1...longitud(lista)-1]
        
        // Añadimos la cabeza dos veces y concatenamos con el resultado del resto
        Resultado = [Cabeza, Cabeza] + duplicarElementos(RestoLista)
    FIN SI

    Devolver Resultado

FIN FUNCIÓN