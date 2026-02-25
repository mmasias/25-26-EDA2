# En una palabra/frase, reemplazar una letra por otra

Reemplazar todas las apariciones de un carácter dado por otro en una palabra o frase. La función recibe la cadena de entrada y dos caracteres: el carácter a reemplazar (old) y el carácter nuevo (new). Devuelve una nueva cadena con los reemplazos aplicados.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Caso               | (`s`, `old`, `new`, `acc`) | `f(s, old, new, acc)`                             |
| ------------------ | -------------------------: | ------------------------------------------------- |
| **Base (CB)**      |     ("", "a", "o", "coso") | "coso"                                            |
| **Recursivo (CR)** |     ("a", "a", "o", "cos") | `f("", "a", "o", "coso")` (sustituye 'a' por 'o') |
| **Recursivo (CR)** |     ("sa", "a", "o", "co") | `f("a", "a", "o", "cos")` (conserva la 's')       |
| **Recursivo (CR)** |     ("asa", "a", "o", "c") | `f("sa", "a", "o", "co")` (sustituye 'a' por 'o') |
| **Recursivo (CR)** |     ("casa", "a", "o", "") | `f("asa", "a", "o", "c")` (conserva la 'c')       |

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION reemplazarLetra(s, old, new, acc = "")

    # Caso Base: Si ya procesamos toda la cadena, devolvemos el texto acumulado
    SI s es cadena vacía ENTONCES
        Devolver acc
    FIN SI

    primer <- primer carácter de s
    resto  <- s sin el primer carácter

    # Evaluamos si el carácter actual debe ser reemplazado
    SI primer == old ENTONCES
        # Hay coincidencia: concatenamos el carácter 'new' al acumulador
        Devolver reemplazarLetra(resto, old, new, acc + new)
    SINO
        # No hay coincidencia: conservamos el original concatenándolo al acumulador
        Devolver reemplazarLetra(resto, old, new, acc + primer)
    FIN SI

FIN FUNCIÓN
```

</details>
