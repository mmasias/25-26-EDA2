# Palíndromo

Calcular la cantidad de cifras de un número entero positivo.

---

| Caso   | n      | f(n) |
| ------ | ------ | ---- |
| CB     | "  "   | TRUE |
| ...    |        |      |
| CR n-1 | bccb   | TRUE |
| CR n   | abccba | TRUE |

| Caso   | n       | f(n) |
| ------ | ------- | ---- |
| CB     | "x"     | TRUE |
| ...    |         |      |
| CR n-1 | bcdcb   | TRUE |
| CR n   | abcdcba | TRUE |

Patrón de recursividad:

f(n) = cabeza == cola & f(n-1) 

---

## Pseudocódigo

```
FUNCION palindromo(palabra)

    SI palabra <= 1 ENTONCES
        Devolver TRUE
    FIN SI

    SI cabeza(palabra) != cola(palabra) ENTONCES
        DEVOLVER FALSE
    FIN SI

    DEVOLVER palindromo(
        cadena_palabra(palabra, 2, longitud(palabra) - 1)
    )

FIN FUNCIÓN
```