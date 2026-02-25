# Validar palíndromo

Determinar si una palabra es igual al revés.

## Analisis recursivo

<div align=center>

||texto|f(texto)|
|-|-|-|
CB|""|true|
CB|"a"|true|
CR|"oso"|true|

</div>

Se comparan extremos y se analiza el interior.

## Pseudocódigo

```text
FUNCION es_palindromo(texto)

    SI longitud <= 1 ENTONCES
        Devolver verdadero
    FIN SI

    SI primer caracter ≠ ultimo caracter ENTONCES
        Devolver falso
    FIN SI

    Devolver es_palindromo(texto sin extremos)

FIN FUNCIÓN