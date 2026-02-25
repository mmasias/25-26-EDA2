# En una palabra/frase, eliminar todas las apariciones de una letra

Eliminar todas las apariciones de una letra dada en una palabra o frase. La función toma dos entradas: la cadena (texto) y el carácter a eliminar. Se devolverá una nueva cadena igual a la original pero sin ninguna ocurrencia del carácter objetivo.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Caso               | (`s`, `c`, `acc`) | `f(s, c, acc)`      |
| :----------------- | :---------------- | :------------------ |
| **Base (CB)**      | ("", "o", "hla")  | "hla"               |
| **Recursivo (CR)** | ("ola", "o", "h") | `f("la", "o", "h")` |
| **Recursivo (CR)** | ("la", "o", "h")  | `f("a", "o", "hl")` |
| **Recursivo (CR)** | ("a", "o", "hl")  | `f("", "o", "hla")` |

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION eliminarLetra(s, c, acc = "")

    # Caso Base: Si ya procesamos toda la cadena, devolvemos el texto limpio acumulado
    SI s es cadena vacía ENTONCES
        Devolver acc
    FIN SI

    primer <- primer carácter de s
    resto  <- s sin el primer carácter

    # Evaluamos el carácter actual para decidir si lo acumul
```
