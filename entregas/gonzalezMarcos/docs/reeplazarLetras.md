# En una palabra/frase, reemplazar una letra por otra

En una palabra o frase, reemplazar una letra dada por otra.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|"", 'a', 'o'|""
...|...|...
n-1|"gta", 'a', 'o'|"gto"
n|"gata", 'a', 'o'|"goto"

</div>

- Si Cabeza == letraVieja --> letraNueva + f(n-1)
- Si Cabeza != letraVieja --> Cabeza + f(n-1)


</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION reemplazarLetra(cadena, vieja, nueva)

    SI longitud(cadena) es 0 ENTONCES
        Devolver ""
    FIN SI

    cabeza = primer carácter de cadena
    resto = subcadena desde la posición 1 hasta el final

    resultadoResto = reemplazarLetra(resto, vieja, nueva)

    SI cabeza es igual a vieja ENTONCES
        Devolver nueva + resultadoResto
    SI NO
        Devolver cabeza + resultadoResto
    FIN SI

FIN FUNCIÓN
```

</details>