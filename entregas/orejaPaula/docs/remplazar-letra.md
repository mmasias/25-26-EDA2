# Reemplazar una letra

En una palabra o frase, reemplazar una letra por otra.

<details>

<summary>Ver análisis recursivo</summary>

<div align=center>

| Tipo    | palabra | f(n, 'a', 'o') |
|---------|---------|----------------|
| CB      | ""      | ""             |
| ...     | ...     | ...            |
| CR n-1  | "hala"  | "holo"         |
| CR n    | "ahala" | "oholo"        |

"oholo" = 'o' + "holo"

Patrón de recursividad:

- Si la Cabeza es la letra vieja → **letraNueva + f(n-1)**
- Si la Cabeza es distinta → **Cabeza + f(n-1)**

</div>

</details>

## Pseudocódigo

<details>

<summary>Ver pseudocódigo</summary>

```text
FUNCION reemplazarUnaLetra(palabra, letraVieja, letraNueva)

    SI palabra es vacía ENTONCES
        Resultado = ""
    SINO
        cabeza = palabra[0]
        resto  = palabra[1...]

        SI cabeza == letraVieja ENTONCES
            Resultado = letraNueva + reemplazarUnaLetra(resto, letraVieja, letraNueva)
        SINO
            Resultado = cabeza + reemplazarUnaLetra(resto, letraVieja, letraNueva)
        FIN SI
    FIN SI

    Devolver Resultado

FIN FUNCIÓN