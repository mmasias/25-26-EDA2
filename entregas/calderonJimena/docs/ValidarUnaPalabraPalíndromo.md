# Validar si una palabra es un palíndromo

## Análisis recursivo

<div align=center>

| Tipo | Cadena | f(cadena) |
|------|--------|-----------|
| CB   | ""     | VERDADERO |
| CB   | "a"    | VERDADERO |
| ...  | ...    | ...       |
| CR   | "reconocer" | VERDADERO |

Si primero != último → FALSO  
Si primero == último → f(subcadena sin extremos)

</div>

## Pseudocódigo

```text
FUNCION esPalindromo(cadena)

    SI LONGITUD(cadena) <= 1 ENTONCES

        Resultado = VERDADERO

    SI NO

        primero = PRIMER_CARACTER(cadena)
        ultimo  = ULTIMO_CARACTER(cadena)

        SI primero != ultimo ENTONCES

            Resultado = FALSO

        SINO

            sub = SUBCADENA(cadena, 1, LONGITUD(cadena) - 2)
            Resultado = esPalindromo(sub)

        FIN SI

    FIN SI

    Devolver Resultado

FIN FUNCIÓN