# Eliminar letra de una palabra

Eliminar todas las apariciones de una letra específica en una cadena de texto.

## Análisis recursivo
(Ejemplo eliminando la letra 'a')

<div align=center>

| Tipo    | cadena | f(cadena) |
|---------|-------:|----------:|
| CB      |     "" |        "" |
| ...     |    ... |       ... |
| CR n-1  |  "apa" |       "p" |
| CR n    | "mapa" |      "mp" |

"mp" = 'm' + "p" → cabeza + f(resto) (si cabeza ≠ letra)
"p" = f("pa") → f(resto) (si cabeza == letra)

</div>

## Pseudocódigo

```text
FUNCION eliminarLetra(cadena, letra)

    SI cadena == "" ENTONCES

        Devolver ""

    SINO

        cabeza = primera letra de cadena
        resto = resto de la cadena

        SI cabeza == letra ENTONCES

            Devolver eliminarLetra(resto, letra)

        SINO

            Devolver cabeza + eliminarLetra(resto, letra)

        FIN SI

    FIN SI

FIN FUNCIÓN