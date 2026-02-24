# Quitar todas las ocurrencias de una letra

Dada una palabra o frase, construir una nueva cadena eliminando todas las veces que aparezca una letra específica.

---

## Análisis recursivo

Ejemplo: eliminar `'a'` de `"casa"`

| Caso | cadena  | f(cadena) |
|------|---------|-----------|
| CB   | ""      | ""        |
| ...  | ...     | ...       |
| CR   | "sa"    | "s"       |
| CR   | "casa"  | "cs"      |

Regla recursiva:

- Si la cadena está vacía → devolver `""`
- Si la primera letra es igual a la que se desea eliminar →  
  resultado = `eliminarLetra(resto, letra)`
- Si la primera letra es diferente →  
  resultado = `primera + eliminarLetra(resto, letra)`

---

## Pseudocódigo

```text
FUNCION eliminarLetra(cadena, letra)

    SI cadena ESTA VACIA ENTONCES
        retornar ""
    SINO
        primera = cadena[0]
        resto = subcadena desde posicion 1

        SI primera == letra ENTONCES
            retornar eliminarLetra(resto, letra)
        SINO
            retornar primera + eliminarLetra(resto, letra)
        FIN SI
    FIN SI

FIN FUNCION