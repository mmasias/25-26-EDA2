# Sustituir una letra por otra

Dada una palabra o frase, generar una nueva cadena donde todas las apariciones de una letra específica sean cambiadas por otra.

---

## Análisis recursivo

Ejemplo: reemplazar `'a'` por `'o'` en `"casa"`

| Caso | cadena  | f(cadena) |
|------|---------|-----------|
| CB   | ""      | ""        |
| ...  | ...     | ...       |
| CR   | "sa"    | "so"      |
| CR   | "casa"  | "coso"    |

Regla recursiva:

- Si la cadena está vacía → devolver `""`
- Si la primera letra es igual a la letra original →  
  resultado = `letraNueva + reemplazarLetra(resto)`
- Si la primera letra es diferente →  
  resultado = `primera + reemplazarLetra(resto)`

---

## Pseudocódigo

```text
FUNCION reemplazarLetra(cadena, letraOriginal, letraNueva)

    SI cadena ESTA VACIA ENTONCES
        retornar ""
    SINO
        primera = cadena[0]
        resto = subcadena desde posicion 1

        SI primera == letraOriginal ENTONCES
            retornar letraNueva + reemplazarLetra(resto, letraOriginal, letraNueva)
        SINO
            retornar primera + reemplazarLetra(resto, letraOriginal, letraNueva)
        FIN SI
    FIN SI

FIN FUNCION