# En una palabra/frase, eliminar todas las apariciones de una letra

Eliminar todas las apariciones de una letra dada en una palabra o frase. La función toma dos entradas: la cadena (texto) y el carácter a eliminar. Se devolverá una nueva cadena igual a la original pero sin ninguna ocurrencia del carácter objetivo.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||entrada (s)|f(s, c)|
|-|-:|-|
CB|""|""   # cadena vacía → devolver cadena vacía
CB|"a" con c='a'|""   # eliminar la única letra
CB|"b" con c='a'|"b"  # no hay coincidencia
...|  | 
CR primer símbolo coincide|"aX..." con c='a'|f("X...", 'a')  # se elimina el primer carácter
CR primer símbolo no coincide|"bX..." con c='a'|"b" + f("X...", 'a')  # se conserva el primer carácter

</div>

</details>

## Pseudocódigo 
<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION eliminarLetra(s, c)

    SI s es cadena vacía ENTONCES
        Devolver ""
    FIN SI

    primer <- primer carácter de s
    resto  <- s sin el primer carácter

    SI primer == c ENTONCES
        Devolver eliminarLetra(resto, c)   # descartamos primer
    SINO
        Devolver primer + eliminarLetra(resto, c)   # conservamos primer
    FIN SI

FIN FUNCIÓN
```

</details>

