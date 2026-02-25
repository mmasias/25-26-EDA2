# comprobarPalindromo

Verificar si una palabra se lee igual al derecho y al revés.

## Análisis recursivo

<div align=center>

| Tipo    | palabra  | f(n)  |
|---------|----------|-------|
| CB       | ""       | TRUE  |
| ...      | ...      | ...   |
| CR n-1   | "alla"   | TRUE  |
| CR n     | "rallar" | TRUE  |

Condición recursiva:  
**f(n) = (extremo_inicial == extremo_final) Y f(subcadena_interna)**

</div>

## Pseudocódigo

```text
FUNCION esPalindromo(palabra)

    SI longitud(palabra) <= 1 ENTONCES
        DEVOLVER VERDADERO
    FIN SI

    SI palabra[primero] != palabra[ultimo] ENTONCES
        DEVOLVER FALSO
    FIN SI

    DEVOLVER esPalindromo(
        subcadena(palabra, desde=1, hasta=longitud-2)
    )

FIN FUNCIÓN