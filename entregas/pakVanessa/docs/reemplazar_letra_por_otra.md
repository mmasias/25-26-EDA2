# reemplazarLetra

 reemplazar una letra por otra en una palabra o frase.

## Análisis recursivo

<div align=center>
| Tipo    | palabra | f(n, 'c', 'k') |
|---------|---------|----------------|
| CB      | ""      | ""             |
| ...     | ...     | ...            |
| CR n-1  | "coco"  | "koko"         |
| CR n    | "acoco" | "akoko"        |

"akoko" = 'a' + "koko"

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