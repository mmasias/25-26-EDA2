# Validar palíndromo

Determinar si una palabra es un palíndromo.

## Análisis recursivo

<div align=center>
| Tipo    | palabra  | f(n)  |
|---------|----------|-------|
| CB      | ""       | TRUE  |
| ...     | ...      | ...   |
| CR n-1  | "alla"   | TRUE  |
| CR n    | "rallar" | TRUE  |

Patrón de recursividad:  
**f(n) = (cabeza == cola) AND f(n - 1)**

</div>

## Pseudocódigo

```text
FUNCION palindromo(palabra)

    SI longitud(palabra) <= 1 ENTONCES
        DEVOLVER TRUE
    FIN SI

    SI cabeza(palabra) != cola(palabra) ENTONCES
        DEVOLVER FALSE
    FIN SI

    DEVOLVER palindromo(
        subcadena(palabra, 2, longitud(palabra) - 1)
    )

FIN FUNCIÓN