# Reemplazar una letra por otra

Reemplazar todas las apariciones de una letra específica por otra nueva en una cadena de texto.

## Análisis recursivo
(Ejemplo reemplazando la 'a' por la 'o')

<div align=center>

| Tipo    | cadena | f(cadena) |
|---------|-------:|----------:|
| CB      |     "" |        "" |
| ...     |    ... |       ... |
| CR n-1  |  "apa" |     "opo" |
| CR n    | "mapa" |    "mopo" |

"mopo" = 'm' + "opo" → cabeza + f(resto) (si cabeza ≠ letraVieja)
"opo" = 'o' + "po" → letraNueva + f(resto) (si cabeza == letraVieja)

</div>

## Pseudocódigo

```text
FUNCION reemplazarLetra(cadena, letraVieja, letraNueva)

    SI cadena == "" ENTONCES

        Devolver ""

    SINO

        cabeza = primera letra de cadena
        resto = resto de la cadena

        SI cabeza == letraVieja ENTONCES

            Devolver letraNueva + reemplazarLetra(resto, letraVieja, letraNueva)

        SINO

            Devolver cabeza + reemplazarLetra(resto, letraVieja, letraNueva)

        FIN SI

    FIN SI

FIN FUNCIÓN