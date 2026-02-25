# 4. Eliminar todas las apariciones de una letra

Recorre una cadena y remueve cada instancia de un carácter específico.

## Análisis recursivo

| Caso | palabra | f(palabra) |
|------|---------|------------|
| CB | "" | "" |
| ... | ... | ... |
| cola | "ala" (sin 'a') | "l" |
| n | "bala" (sin 'a') | "bl" |

Análisis de pasos:
- "bala" sin 'a' es "bl".
- "ala" sin 'a' es "l".
- Por lo tanto: "bl" = "b" + (resultado de "ala").

**Relación:** $f(p) = (p[0] == letra\ ?\ ""\ :\ p[0]) + f(resto)$

## Pseudocódigo

```text
FUNCION eliminarLetra(palabra, letra)
    SI palabra es vacía ENTONCES
        Devolver ""
    FIN SI

    caracterActual = obtenerPrimerCaracter(palabra)
    restoPalabra = obtenerResto(palabra)

    SI caracterActual = letra ENTONCES
        Devolver eliminarLetra(restoPalabra, letra)
    SINO
        Devolver caracterActual + eliminarLetra(restoPalabra, letra)
    FIN SI
FIN FUNCION