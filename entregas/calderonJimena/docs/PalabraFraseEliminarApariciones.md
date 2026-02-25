# En una palabra/frase, eliminar todas las apariciones de una letra

## Análisis recursivo

<div align=center>

| Tipo | Cadena | letra | f(cadena) |
|------|--------|-------|-----------|
| CB   | ""     | "a"   | ""        |
| ...  | ...    | ...   | ...       |
| CR   | "casa" | "a"   | "cs"      |

Si primer == letra → f(resto)  
Si no → primer + f(resto)

</div>

## Pseudocódigo

```text
FUNCION eliminarLetra(cadena, letra)

    SI cadena == "" ENTONCES

        Resultado = ""

    SI NO

        primer = PRIMER_CARACTER(cadena)
        resto  = RESTO(cadena)

        SI primer == letra ENTONCES

            Resultado = eliminarLetra(resto, letra)

        SINO

            Resultado = primer + eliminarLetra(resto, letra)

        FIN SI

    FIN SI

    Devolver Resultado

FIN FUNCIÓN