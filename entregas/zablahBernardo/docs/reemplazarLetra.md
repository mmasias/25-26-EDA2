# reemplazarLetra

Reemplazar todas las apariciones de una letra específica por una letra nueva en una cadena de texto. Por definición, si la cadena está vacía, devuelve una cadena vacía.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|        | n (cadena) | f(n)         |
|--------|------------|--------------|
| CB     | "", 'a', 'x'| ""           |
| ...    | ...        | ...          |
| CR n-1 | "ana", 'a', 'x' | "x" + "n" + "x" = "xnx" |
| CR n   | "nana", 'a', 'x'| "n" + "xnx" = "nxnx" |

Si cabeza == letraVieja:
f(n) = letraNueva + f(n-1)

Si cabeza != letraVieja:
f(n) = cabeza + f(n-1)

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION reemplazarLetra(cadena, letraVieja, letraNueva)

    SI cadena está vacía ENTONCES
        Devolver ""
    FIN SI

    cabeza = primer carácter de cadena
    resto = subcadena desde posición 1 hasta el final

    SI cabeza es igual a letraVieja ENTONCES
        Devolver letraNueva + reemplazarLetra(resto, letraVieja, letraNueva)
    SI NO
        Devolver cabeza + reemplazarLetra(resto, letraVieja, letraNueva)
    FIN SI

FIN FUNCIÓN
```

</details>