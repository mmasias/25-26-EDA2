# duplicarElementos

En una lista, duplicar sus elementos (ej: [1,2,3] → [1,1,2,2,3,3]).

## Análisis recursivo

<div align=center>

| Tipo    | lista     | f(n)              |
|---------|-----------|-------------------|
| CB      | []        | []                |
| ...     | ...       | ...               |
| CR n-1  | [3,5]     | [3,3,5,5]         |
| CR n    | [2,3,5]   | [2,2,3,3,5,5]     |

[2,2,3,3,5,5] = [2,2] + [3,3,5,5]  
→ **2 veces la Cabeza + f(n-1)**

</div>

## Pseudocódigo

```text
FUNCION duplicarElementos(lista)

    SI lista es vacia ENTONCES
        Resultado = []
    SINO
        Elemento = lista[0]
        RestoDuplicado = duplicarElementos(lista[1...longitud(lista)-1])
        Resultado = [Elemento, Elemento] + RestoDuplicado
    FIN SI

    Devolver Resultado

FIN FUNCIÓN
