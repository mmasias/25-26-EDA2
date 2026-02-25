### Invertir cadena

Invertir una cadena de texto dada.

## Análisis recursivo

<div align=center>

| Tipo   | cadena | f(cadena) |
|--------|--------|-----------|
| CB     | ""     | ""        |
| ...    | ...    | ...       |
| CR n-1 | "bcd"  | "dcb"     |
| CR n   | "abcd" | "dcba"    |

"dcba" = "dcb" + "a" → **f(resto) + cabeza**

</div>

> Idea: **cabeza** = primer carácter, **resto** = subcadena desde la posición 1 hasta el final.

## Pseudocódigo

```text
FUNCION invertirCadena(cadena)

    SI longitud(cadena) == 0 ENTONCES

        Resultado = ""

    SI NO

        cabeza = primer carácter de cadena
        resto = subcadena desde la posición 1 hasta el final

        Resultado = invertirCadena(resto) + cabeza

    FIN SI

    Devolver Resultado

FIN FUNCIÓN