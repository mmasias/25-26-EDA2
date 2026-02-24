# reemplazarLetra

En una palabra o frase, reemplazar una letra por otra.

## Análisis recursivo

<div align=center>

| Tipo    | palabra | f(n, 'm', 'l') |
|---------|---------|----------------|
| CB      | ""      | ""             |
| ...     | ...     | ...            |
| CR n-1  | "momo"  | "lolo"         |
| CR n    | "amomo" | "alolo"        |

"alolo" = 'a' + "lolo"

Patrón de recursividad:

- Si la Cabeza es la letra vieja → **letraNueva + f(n-1)**
- Si la Cabeza es distinta → **Cabeza + f(n-1)**

</div>

## Pseudocódigo

```text
FUNCION reemplazarLetra(palabra, letraVieja, letraNueva)

    SI palabra es vacía ENTONCES
        Resultado = ""
    SINO
        cabeza = palabra[0]
        resto  = palabra[1...]

        SI cabeza == letraVieja ENTONCES
            Resultado = letraNueva + reemplazarLetra(resto, letraVieja, letraNueva)
        SINO
            Resultado = cabeza + reemplazarLetra(resto, letraVieja, letraNueva)
        FIN SI
    FIN SI

    Devolver Resultado

FIN FUNCIÓN
