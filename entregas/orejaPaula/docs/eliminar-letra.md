# Eliminar una letra

Eliminar todas las apariciones de una letra en una palabra o frase.

<details>

<summary>Ver análisis recursivo</summary>

<div align=center>

| Tipo    | palabra | f(n,'a') |
|---------|---------|----------|
| CB      | ""      | ""       |
| ...     | ...     | ...      |
| CR n-1  | "real"  | "rel"    |
| CR n    | "areal" | "rel"    |

En "areal":

- cabeza = 'a' (es la letra a eliminar)  
- resto = "real" → f(n-1) = "rel"

Patrón de recursividad:

- Si la Cabeza **es** la letra a eliminar → **f(n) = f(n-1)**  
- Si la Cabeza **no es** la letra → **f(n) = Cabeza + f(n-1)**

</div>

</details>

## Pseudocódigo

<details>

<summary>Ver pseudocódigo</summary>

```text
FUNCION eliminarUnaLetra(palabra, letra)

    SI palabra es vacía ENTONCES
        Resultado = ""
    SINO
        cabeza = palabra[0]
        resto  = palabra[1...longitud(palabra)-1]

        SI cabeza == letra ENTONCES
            Resultado = eliminarUnaLetra(resto, letra)
        SINO
            Resultado = cabeza + eliminarUnaLetra(resto, letra)
        FIN SI
    FIN SI

    Devolver Resultado

FIN FUNCIÓN