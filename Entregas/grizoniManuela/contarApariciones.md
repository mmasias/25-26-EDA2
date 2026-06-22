### Contar apariciones

Contar cuántas veces aparece una letra en una cadena de texto.

## Análisis recursivo

<div align=center>

| Tipo   | cadena (letra='a') | f(cadena) |
|--------|---------------------|----------:|
| CB     | ""                  |         0 |
| ...    | ...                 |       ... |
| CR n-1 | "da"                |         1 |
| CR n   | "ada"               |         2 |
| ...    | ...                 |       ... |
| CR n-1 | "cdada"             |         2 |
| CR n   | "bcdada"            |         2 |

Si **cabeza == letra** → f(cadena) = **1 + f(resto)**  
Si **cabeza != letra** → f(cadena) = **f(resto)**

</div>

> Idea: **cabeza** = primer carácter, **resto** = subcadena desde la posición 1 hasta el final.

## Pseudocódigo

```text
FUNCION contarApariciones(cadena, letra)

    SI cadena está vacía ENTONCES

        Resultado = 0

    SI NO

        cabeza = primer carácter de cadena
        resto = subcadena desde la posición 1 hasta el final

        SI cabeza == letra ENTONCES

            Resultado = 1 + contarApariciones(resto, letra)

        SI NO

            Resultado = contarApariciones(resto, letra)

        FIN SI

    FIN SI

    Devolver Resultado

FIN FUNCIÓN