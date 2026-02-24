# Validar si una palabra es un palíndromo

Comprobar si una palabra se lee igual de izquierda a derecha que de derecha a izquierda.

## Análisis recursivo

| Caso | n | f(n) |
|------|---|------|
| CB | "" | Verdadero |
| CB | "a" | Verdadero |
| CR | "aa" | Verdadero |
| CR | "aba" | Verdadero |
| CR | "abca" | Falso |

Si primera == última → f(texto sin extremos)
Si primera != última → Falso

## Pseudocódigo

FUNCION esPalindromo(texto)

    SI longitud(texto) es 0 o 1 ENTONCES
        Devolver Verdadero
    FIN SI

    primera = texto[0]
    ultima = texto[longitud(texto) - 1]

    SI primera != ultima ENTONCES
        Devolver Falso
    FIN SI

    interior = subcadena desde 1 hasta longitud(texto) - 2
    Devolver esPalindromo(interior)

FIN FUNCIÓN