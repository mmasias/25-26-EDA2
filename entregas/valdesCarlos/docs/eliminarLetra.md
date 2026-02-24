# eliminarLetra

Eliminar todas las apariciones de una letra en una palabra o frase.

## Análisis recursivo

<div align=center>

| Tipo    | palabra      | f(n,'e')  |
|---------|--------------|-----------|
| CB      | ""           | ""        |
| ...     | ...          | ...       |
| CR n-1  | "lefante"    | "lfant"   |
| CR n    | "elefante"   | "lfant"   |

En "elefante":

- cabeza = 'e' (es la letra a eliminar)  
- resto = "lefante" → f(n-1) = "lfant"

Patrón de recursividad:

- Si la palabra está vacía → **f(n) = ""**
- Si la Cabeza **es** la letra a eliminar → **f(n) = f(n-1)** 
- Si la Cabeza **no es** la letra → **f(n) = Cabeza + f(n-1)**

</div>

## Pseudocódigo

```text
FUNCION eliminarLetra(palabra, letra)

    SI palabra es vacía ENTONCES
        Resultado = ""
    SINO
        cabeza = palabra[0]
        resto  = palabra[1...longitud(palabra)-1]

        SI cabeza == letra ENTONCES
            Resultado = eliminarLetra(resto, letra)
        SINO
            Resultado = cabeza + eliminarLetra(resto, letra)
        FIN SI
    FIN SI

    Devolver Resultado

FIN FUNCIÓN