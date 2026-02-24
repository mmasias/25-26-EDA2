# Duplicar elementos de una lista

Dada una lista, devolver una nueva lista donde cada elemento aparezca duplicado.
Ejemplo: [1,2,3] → [1,1,2,2,3,3]

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

Ejemplo: [1,2,3]

|        | lista     | f(lista)        |
| ------ | --------- | --------------- |
| CB     | []        | []              |
| ...    | ...       | ...             |
| CR     | [2,3]     | [2,2,3,3]       |
| CR     | [1,2,3]   | [1,1,2,2,3,3]   |

Resultado = [primero, primero] + duplicar(resto)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION duplicarLista(lista)

    SI lista ESTA VACIA ENTONCES
        Resultado = []
    SINO
        primero = lista[0]
        resto = sublista desde posicion 1

        Resultado = [primero, primero] + duplicarLista(resto)
    FIN SI

    DEVOLVER Resultado

FIN FUNCION
```

</details>