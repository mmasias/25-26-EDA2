# Reemplazar una letra por otra

Reemplazar todas las apariciones de una letra por otra.

## Analisis recursivo

<div align=center>

||texto|f(texto)|
|-|-|-|
CB|""|""
CR|"asa"|"oso"|

</div>

Se analiza carácter a carácter.

## Pseudocódigo

```text
FUNCION reemplazar(texto, original, nueva)

    SI texto está vacío ENTONCES
        Devolver ""
    FIN SI

    SI primer caracter es igual a original ENTONCES
        Devolver nueva + reemplazar(resto, original, nueva)
    SINO
        Devolver primer caracter + reemplazar(resto, original, nueva)
    FIN SI

FIN FUNCIÓN