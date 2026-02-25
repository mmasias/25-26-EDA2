## Reemplazar Letra

Reemplazar todas las apariciones de una letra específica por otra letra nueva en una cadena de texto.

## Análisis recursivo

<div align=center>

| Tipo    | palabra | f(n,'a','o') |
|---------|---------|--------------|
| CB      | ""      | ""           |
| ...     | ...     | ...          |
| CR n-1  | "ata"   | "oto"        |
| CR n    | "pata"  | "poto"       |

En "pata" (cambiar 'a' por 'o'):

- cabeza = 'p' (no es la letra a reemplazar)  
- resto = "ata" → f(n-1) = "oto"

Patrón de recursividad:

- Si la palabra está vacía → **f(n) = ""**
- Si la Cabeza **es** la letra vieja → **f(n) = letraNueva + f(n-1)** - Si la Cabeza **no es** la letra vieja → **f(n) = Cabeza + f(n-1)**

</div>

## Pseudocódigo

```text
FUNCION reemplazarLetra(palabra, vieja, nueva)

    SI palabra es vacía ENTONCES
        Resultado = ""
    SINO
        cabeza = palabra[0]
        resto  = palabra[1...longitud(palabra)-1]

        SI cabeza == vieja ENTONCES
            Resultado = nueva + reemplazarLetra(resto, vieja, nueva)
        SINO
            Resultado = cabeza + reemplazarLetra(resto, vieja, nueva)
        FIN SI
    FIN SI

    Devolver Resultado

FIN FUNCIÓN