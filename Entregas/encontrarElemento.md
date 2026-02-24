### Encontrar elemento

Buscar si un elemento existe en una lista.

## Análisis recursivo

<div align=center>

| Tipo | lista, numero     | f(lista, numero) |
|------|-------------------|------------------|
| CB   | [], 3             | false            |
| CB   | [3,...], 3        | true             |
| ...  | ...               | ...              |
| CR n-1 | [6,3,5,2,4], 3   | true             |
| CR n | [5,6,3,5,2,4], 3  | true             |

Si **cabeza == numero** → **true**  
Si **cabeza != numero** → **f(resto, numero)**

</div>

> Idea: **cabeza** = primer elemento, **resto** = lista sin el primer elemento.

## Pseudocódigo

```text
FUNCION encontrarElemento(lista, numero)

    SI lista está vacía ENTONCES

        Resultado = FALSO

    SI NO

        cabeza = primer elemento de la lista

        SI cabeza == numero ENTONCES

            Resultado = VERDADERO

        SI NO

            resto = lista sin el primer elemento
            Resultado = encontrarElemento(resto, numero)

        FIN SI

    FIN SI

    Devolver Resultado

FIN FUNCIÓN