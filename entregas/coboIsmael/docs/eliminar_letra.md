# Eliminar todas las apariciones de una letra

Dada una palabra o frase, eliminar todas las apariciones de una letra.

## Análisis recursivo

| texto, letra | f(texto, letra) |
|--------------|----------------|
| CB: "" | "" |
| "da",'a' | "d" |
| "ada",'a' | "d" |
| "bcdada",'a' | "bcdd" |

Si cabeza == letra → f(resto)
Si cabeza != letra → cabeza + f(resto)

## Pseudocódigo

FUNCION eliminarLetra(texto, letra)

    SI texto está vacío ENTONCES
        Devolver ""
    FIN SI

    cabeza = primer carácter de texto
    resto = subcadena desde posición 1 hasta el final

    SI cabeza es igual a letra ENTONCES
        Devolver eliminarLetra(resto, letra)
    SI NO
        Devolver cabeza + eliminarLetra(resto, letra)
    FIN SI

FIN FUNCIÓN