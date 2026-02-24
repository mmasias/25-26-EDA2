# palindromo

Validar si una palabra es palíndromo.

Ejemplo: "radar"

## Análisis recursivo

| Caso | texto | f(texto) |
|------|--------|-----------|
| CB | "" | verdadero |
| ... | ... | ... |
| CR n-1 | "ada" | verdadero |
| CR n | "radar" | verdadero |

Patrón:

Comparar extremos.

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION esPalindromo(texto)

    SI longitud(texto) <= 1 ENTONCES
        devolver VERDADERO
    FIN SI

    SI texto[0] != texto[longitud(texto)-1] ENTONCES
        devolver FALSO
    FIN SI

    devolver esPalindromo(texto[1:longitud(texto)-1])

FIN FUNCION