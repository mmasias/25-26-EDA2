# Eliminar todas las apariciones de una letra

Dada una palabra o frase, eliminar todas las apariciones de una letra determinada.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

Ejemplo: eliminar 'a' de "casa"

|        | cadena | f(cadena) |
| ------ | ------ | --------- |
| CB     | ""     | ""        |
| ...    |  ...   | ...       |
| CR     | "sa"   | "s"       |
| CR     | "casa" | "cs"      |

Si la primera letra es igual a la letra a eliminar ⇒  
resultado = eliminar(resto)

Si la primera letra es distinta ⇒  
resultado = primeraLetra + eliminar(resto)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION eliminarLetra(cadena, letra)

    SI cadena ESTA VACIA ENTONCES
        Resultado = ""
    SINO
        primera = cadena[0]
        resto = subcadena desde posicion 1

        SI primera == letra ENTONCES
            Resultado = eliminarLetra(resto, letra)
        SINO
            Resultado = primera + eliminarLetra(resto, letra)
        FIN SI
    FIN SI

    DEVOLVER Resultado

FIN FUNCION
```

</details>