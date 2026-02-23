# En una palabra/frase, eliminar todas las apariciones de una letra

Eliminar todas las apariciones de una letra dada en una palabra o frase. La función toma dos entradas: la cadena (texto) y el carácter a eliminar. Se devolverá una nueva cadena igual a la original pero sin ninguna ocurrencia del carácter objetivo.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Caso | entrada ($s$) | $f(s, c)$ |
| :--- | :--- | :--- |
| **CB** | "" | "" |
| **CB** | $s$ (si $s = c$) | "" |
| **CB** | $s$ (si $s \neq c$) | $s$ |
| ... | | |
| **CR** | $s$ (si $s[0] = c$) | $f(s_{resto}, c)$ |
| **CR** | $s$ (si $s[0] \neq c$) | $s[0] + f(s_{resto}, c)$ |

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

