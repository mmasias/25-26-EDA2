# eliminarLetra

Eliminar todas las apariciones de una letra en una palabra o frase.

## Análisis recursivo

<div align=center>

| Tipo    | palabra | f(n,'a') |
|---------|---------|----------|
| CB      | ""      | ""       |
| ...     | ...     | ...      |
| CR n-1  | "luna"  | "lun"    |
| CR n    | "aluna" | "lun"    |

En "aluna":

- cabeza = 'a' (es la letra a eliminar)  
- resto = "luna" → f(n-1) = "lun"

Patrón de recursividad:

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
