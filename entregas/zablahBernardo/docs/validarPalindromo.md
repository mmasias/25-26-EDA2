# esPalindromo

Validar si una palabra o cadena de texto se lee exactamente igual de izquierda a derecha que de derecha a izquierda. Por definición, una cadena vacía o con un solo carácter es un palíndromo.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|        | n (cadena) | f(n)             |
|--------|------------|------------------|
| CB     | ""         | Verdadero        |
| CB     | "a"        | Verdadero        |
| ...    | ...        | ...              |
| CR n-1 | "oso"      | Verdadero        |
| CR n   | "sosos"    | Verdadero (s == s y f("oso")) |

Si primero == ultimo:
f(n) = f(n-1)

Si primero != ultimo:
f(n) = Falso

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION esPalindromo(cadena)

    SI longitud de cadena <= 1 ENTONCES
        Devolver Verdadero
    FIN SI

    primero = primer carácter de cadena
    ultimo = último carácter de cadena
    resto = subcadena excluyendo el primer y el último carácter

    SI primero es igual a ultimo ENTONCES
        Devolver esPalindromo(resto)
    SI NO
        Devolver Falso
    FIN SI

FIN FUNCIÓN
```

</details>