## Eliminar letras repetidas

Reemplazar todas las repeticiones de una letra específica por una letra nueva en una cadena de texto.


<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Tipo | n (cadena), 'o', 'x' | f(n) |
|------|----------------------|------|
| CB | "", 'o', 'x' | "" |
| ... | ... | ... |
| CR n-1 | "oso", 'o', 'x' | "xsx" |
| CR n | "coso", 'o', 'x' | "cxsx" |

Si cabeza == letraVieja:
f(n) = letraNueva + f(resto)

Si cabeza != letraVieja:
f(n) = cabeza + f(resto)$

</div>

</details>

## Pseudocódigo
<details>
<summary>Ver pseudocódigo</summary>

FUNCIÓN reemplazarLetra(cadena, vieja, nueva)

    SI cadena está vacía ENTONCES
        Devolver ""
    FIN SI

    SI cadena[0] == vieja ENTONCES
        Devolver nueva + reemplazarLetra(subcadena(cadena, 1), vieja, nueva)
    SINO
        Devolver cadena[0] + reemplazarLetra(subcadena(cadena, 1), vieja, nueva)
    FIN SI

FIN FUNCIÓN