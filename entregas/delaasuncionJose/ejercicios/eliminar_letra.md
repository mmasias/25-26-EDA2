# Eliminar una letra de una palabra

Eliminar todas las apariciones de una letra en un texto.

## Analisis recursivo

<div align=center>

||texto|f(texto)|
|-|-|-|
CB|""|""
CR|"asa"|"s"|

</div>

Se analiza el primer carácter y se procesa el resto.

## Pseudocódigo

```text
FUNCION eliminar(texto, letra)

    SI texto está vacío ENTONCES
        Devolver ""
    FIN SI

    SI primer caracter es igual a letra ENTONCES
        Devolver eliminar(resto, letra)
    SINO
        Devolver primer caracter + eliminar(resto, letra)
    FIN SI

FIN FUNCIÓN