# En una palabra/frase, reemplazar una letra por otra

## Análisis recursivo

<div align=center>

| Tipo | Cadena | vieja | nueva | f(cadena) |
|------|--------|-------|-------|-----------|
| CB   | ""     | "a"   | "e"   | ""        |
| ...  | ...    | ...   | ...   | ...       |
| CR   | "casa" | "a"   | "e"   | "cese"    |

Si primer == vieja → nueva + f(resto)  
Si no → primer + f(resto)

</div>

## Pseudocódigo

```text
FUNCION reemplazarLetra(cadena, letraVieja, letraNueva)

    SI cadena == "" ENTONCES

        Resultado = ""

    SI NO

        primer = PRIMER_CARACTER(cadena)
        resto  = RESTO(cadena)

        SI primer == letraVieja ENTONCES

            Resultado = letraNueva + reemplazarLetra(resto, letraVieja, letraNueva)

        SINO

            Resultado = primer + reemplazarLetra(resto, letraVieja, letraNueva)

        FIN SI

    FIN SI

    Devolver Resultado

FIN FUNCIÓN