# eliminarLetra

Eliminar todas las apariciones de una letra específica en una cadena de texto. Por definición, si la cadena está vacía, devuelve una cadena vacía.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|        | n (cadena) | f(n)         |
|--------|------------|--------------|
| CB     | "", 'a'    | ""           |
| ...    | ...        | ...          |
| CR n-1 | "ana", 'a' | "n"          |
| CR n   | "nana", 'a'| "n" + "n" = "nn" |

Si cabeza == letra:
f(n) = f(n-1)

Si cabeza != letra:
f(n) = cabeza + f(n-1)

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION eliminarLetra(cadena, letra)

    SI cadena está vacía ENTONCES
        Devolver ""
    FIN SI

    cabeza = primer carácter de cadena
    resto = subcadena desde posición 1 hasta el final

    SI cabeza es igual a letra ENTONCES
        Devolver eliminarLetra(resto, letra)
    SI NO
        Devolver cabeza + eliminarLetra(resto, letra)
    FIN SI

FIN FUNCIÓN
```

</details>