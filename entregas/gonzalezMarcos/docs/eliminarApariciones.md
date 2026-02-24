# En una palabra/frase, eliminar todas las apariciones de una letra

En una palabra o frase, eliminar todas las apariciones de una letra específica.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|"", 'a'|""
...|...|...
n-1|"gto", 'a'|"gto"
n|"gato", 'a'|"gto"

</div>

- Si Cabeza == letra --> f(n-1)
- Si Cabeza != letra --> Cabeza + f(n-1)


</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION eliminarLetra(cadena, letra)

    SI longitud(cadena) es 0 ENTONCES
        Devolver ""
    FIN SI

    cabeza = primer carácter de cadena
    resto = subcadena desde la posición 1 hasta el final

    resultadoResto = eliminarLetra(resto, letra)

    SI cabeza es igual a letra ENTONCES
        Devolver resultadoResto
    SI NO
        Devolver cabeza + resultadoResto
    FIN SI

FIN FUNCIÓN
```

</details>