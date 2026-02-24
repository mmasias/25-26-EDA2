# Reemplazar una letra por otra

Dada una palabra o frase, reemplazar todas las apariciones de una letra por otra.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

Ejemplo: reemplazar 'a' por 'o' en "casa"

|        | cadena | f(cadena) |
| ------ | ------ | --------- |
| CB     | ""     | ""        |
| ...    | ...    | ...       |
| CR n-1 | "asa"  | "oso"     |
| CR n   | "casa" | "coso"    |

"coso" = "c" + "oso"

Si la primera letra es igual a la letra a reemplazar ⇒  
resultado = letraNueva + reemplazar(resto)

Si la primera letra es distinta ⇒  
resultado = primeraLetra + reemplazar(resto)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION reemplazarLetra(cadena, letraOriginal, letraNueva)

    SI cadena ESTA VACIA ENTONCES
        Resultado = ""
    SINO
        primera = cadena[0]
        resto = subcadena desde posicion 1

        SI primera == letraOriginal ENTONCES
            Resultado = letraNueva + reemplazarLetra(resto, letraOriginal, letraNueva)
        SINO
            Resultado = primera + reemplazarLetra(resto, letraOriginal, letraNueva)
        FIN SI
    FIN SI

    DEVOLVER Resultado

FIN FUNCION
