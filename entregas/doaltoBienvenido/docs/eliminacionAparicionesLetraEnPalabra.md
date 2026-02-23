# Eliminar apariciones de una letra en una palabra

En una palabra/frase, eliminar todas las apariciones de una letra
---


| Caso   | n      | f(n) |
| ------ | ------ | ---- |
| CB     | ""     | ""   |
| ...    |        |      |
| CR n-1 | "ana"  | "n"  |
| CR n   | "nana" | "nn" |

resultado = cabeza + f(n-1)


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