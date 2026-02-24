# duplicar elementos


Dada una lista, duplicar cada uno de sus elementos (ej: [1,2,3] -> [1,1,2,2,3,3]).



|          |   lista | f(lista)      |
| -------- | ------: | ------------- |
| CB       |      [] | []            |
| ...      |     ... | ...           |
| CR n-1 |   [2,3] | [2,2,3,3]     |
| CR n     | [1,2,3] | [1,1,2,2,3,3] |



[1,1,2,2,3,3] = [1,1] + [2,2,3,3] *o lo que es igual* **[elemento, elemento] + duplicarElementos(resto)**


# Pseudocódigo



```

FUNCION duplicarElementos(lista)


    SI lista es vacía ENTONCES

        Resultado = []

    SINO

        Elemento = lista[0]

        RestoDuplicado = duplicarElementos(lista[1...longitud(lista)-1])

        Resultado = [Elemento, Elemento] + RestoDuplicado

    FIN SI


    Devolver Resultado


FIN FUNCIÓN

