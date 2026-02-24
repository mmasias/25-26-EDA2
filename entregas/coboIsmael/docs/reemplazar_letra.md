# Reemplazar una letra por otra

Reemplazar todas las apariciones de una letra vieja por otra nueva.

## Análisis recursivo

| texto | resultado |
|-------|----------|
| CB: "" | "" |
| "ada",'a','x' | "xdx" |
| "bcdada",'a','x' | "bcdxdx" |

Si cabeza == vieja → nueva + f(resto)
Si cabeza != vieja → cabeza + f(resto)

## Pseudocódigo

FUNCION reemplazarLetra(texto, vieja, nueva)

    SI texto está vacío ENTONCES
        Devolver ""
    FIN SI

    cabeza = primer carácter de texto
    resto = subcadena desde posición 1 hasta el final

    SI cabeza es igual a vieja ENTONCES
        Devolver nueva + reemplazarLetra(resto, vieja, nueva)
    SI NO
        Devolver cabeza + reemplazarLetra(resto, vieja, nueva)
    FIN SI

FIN FUNCIÓN