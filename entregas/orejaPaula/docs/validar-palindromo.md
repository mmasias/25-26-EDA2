# Validar palíndromo

Determinar si una palabra o frase es un palíndromo.

<details>

<summary>Ver análisis recursivo</summary>

<div align=center>

| Tipo    | palabra  | f(palabra) |
|---------|----------|------------|
| CB      | ""       | TRUE       |
| CB      | "p"      | TRUE       |
| ...     | ...      | ...        |
| CR n-1  | "ymmy"   | TRUE       |
| CR n    | "pymmyp" | TRUE       |

TRUE = ('p' == 'p') AND TRUE  
*o lo que es igual*  
**(p[0] == p[n-1]) AND esPalindromo(interior)**

Patrón de recursividad:

- Si longitud(palabra) <= 1 → **TRUE**
- Si palabra[0] != palabra[longitud(palabra)-1] → **FALSE**
- Si palabra[0] == palabra[longitud(palabra)-1] → **esPalindromo(interior)**

</div>

</details>

## Pseudocódigo

<details>

<summary>Ver pseudocódigo</summary>

```text
FUNCION esPalindromo(palabra)

    SI longitud(palabra) <= 1 ENTONCES
        Resultado = TRUE
    SINO
        SI palabra[0] != palabra[longitud(palabra)-1] ENTONCES
            Resultado = FALSE
        SINO
            interior = palabra[1...longitud(palabra)-2]
            Resultado = esPalindromo(interior)
        FIN SI
    FIN SI

    Devolver Resultado

FIN FUNCIÓN