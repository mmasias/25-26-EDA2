# 5. Reemplazar una letra por otra

Intercambia todas las ocurrencias de una letra por una nueva letra indicada.

## Análisis recursivo

| Caso | palabra | f(palabra) |
|------|---------|------------|
| CB | "" | "" |
| ... | ... | ... |
| cola | "asa" ('a'→'e') | "ese" |
| n | "casa" ('a'→'e') | "cese" |

**Relación:**  
$f(n) = (caracter == vieja ? nueva : caracter) + f(resto)$

## Pseudocódigo
```text
FUNCION reemplazarLetra(palabra, vieja, nueva)
    SI palabra es vacía ENTONCES
        Devolver ""
    FIN SI

    caracter = obtenerPrimerCaracter(palabra)
    resto = obtenerResto(palabra)

    SI caracter = vieja ENTONCES
         Devolver nueva + reemplazarLetra(resto, vieja, nueva)
    SINO
        Devolver caracter + reemplazarLetra(resto, vieja, nueva)
    FIN SI
FIN FUNCION