## Duplicar los elementos de una lista

Dada una lista, generar una nueva lista en la que cada valor aparezca repetido dos veces de manera consecutiva.

**Ejemplo:**  
[1,2,3] → [1,1,2,2,3,3]

---

## Análisis recursivo

Ejemplo con `[1,2,3]`

| Caso | lista     | f(lista)        |
|------|-----------|-----------------|
| CB   | []        | []              |
| ...  | ...       | ...             |
| CR   | [2,3]     | [2,2,3,3]       |
| CR   | [1,2,3]   | [1,1,2,2,3,3]   |

La regla recursiva es:

Resultado = `[primero, primero] + duplicarLista(resto)`

Donde:
- **primero** es el primer elemento de la lista.
- **resto** es la lista sin el primer elemento.

Si la lista está vacía → devolver `[]`.

---

## Pseudocódigo

```text
FUNCION duplicarLista(lista)

    SI lista ESTA VACIA ENTONCES
        retornar []
    SINO
        primero = lista[0]
        resto = sublista desde posicion 1

        retornar [primero, primero] + duplicarLista(resto)
    FIN SI

FIN FUNCION