
---

## duplicar_elemento.md

```markdown
# duplicarElementos

Duplicar los elementos de una lista (ej: [1,2,3] → [1,1,2,2,3,3]).

## Análisis recursivo

<div align=center>

| Tipo    | lista     | f(n)            |
|---------|-----------|-----------------|
| CB      | []        | []              |
| ...     | ...       | ...             |
| CR n-1  | [4,8]     | [4,4,8,8]       |
| CR n    | [1,4,8]   | [1,1,4,4,8,8]   |

[1,1,4,4,8,8] = [1,1] + [4,4,8,8]  
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