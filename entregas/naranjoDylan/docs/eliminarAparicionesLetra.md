# Eliminar apariciones de una letra en una palabra

En una palabra/frase, eliminar todas las apariciones de una letra
---


| Caso   | n      | f(n) |
| ------ | ------ | ---- |
| CB     | ""     | ""   |
| ...    |        |      |
| CR n-1 | "olor"  | "lr"  |
| CR n   | "color" | "clr" |

Si la cabeza es la letra aque buscamos eliminar → f(n) = f(n-1)

Si la cabeza no es la letra → f(n) = cabeza + f(n-1)


## Pseudocódigo

```

FUNCION eliminarLetra(palabra, letra)

    SI palabra es vacía ENTONCES
        Devuelve " "
    SINO

        SI palabra[0] == letra ENTONCES

            Resultado = eliminarLetra(palabra[1...longitud(palabra)-1], letra)
        SINO
        
            Resultado = palabra[0] + eliminarLetra(palabra[1...longitud(palabra)-1], letra)
        FIN SI

    FIN SI

    Devolver Resultado
FIN FUNCIÓN
```