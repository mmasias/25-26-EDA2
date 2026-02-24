## Eliminar letras repetidas

Eliminar las letras repetidas en una cadena de texto.


<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Tipo | n (cadena), 'o' | f(n) |
|------|------------------|------|
| CB | "", 'o' | "" |
| CB | "o", 'o' | "" |
| CR | "so", 'o' | "s" |
| CR n-1 | "oso", 'o' | "s" |
| CR n | "coso", 'o' | "cs" |

Si cabeza == letra:

f(n) = f(resto)

Si cabeza != letra:

f(n) = cabeza + f(resto)

</div>

</details>

## Pseudocódigo
<details>
<summary>Ver pseudocódigo</summary>

FUNCIÓN eliminarLetra(cadena, letra)

    SI cadena está vacía ENTONCES
        Devolver ""
    FIN SI

    SI cadena[0] == letra ENTONCES
        Devolver eliminarLetra(subcadena(cadena, 1), letra)
    SINO
        Devolver cadena[0] + eliminarLetra(subcadena(cadena, 1), letra)
    FIN SI

FIN FUNCIÓN