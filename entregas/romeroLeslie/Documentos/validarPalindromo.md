## Validar si una palabra es un palíndromo

Comprobar si una palabra o cadena de texto se lee  igual de izquierda a derecha que de derecha a izquierda. 

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Tipo | n (cadena) | f(n) |
|------|------------|------|
| CB | "o" | Verdadero |
| ... | ... | ... |
| CR n-1 | "on" | Falso |
| CR n | "mono" | Falso (m ≠ o) |

Si primero == ultimo:
f(n) = f(resto)

Si primero != ultimo:
f(n) = Falso

</div>

</details>

## Pseudocódigo
<details>
<summary>Ver pseudocódigo</summary>

FUNCION esPalindromo(cadena)

    SI longitud de cadena <= 1 ENTONCES
        Devolver Verdadero
    FIN SI

    SI cadena[0] == cadena[último] ENTONCES
        Devolver esPalindromo(subcadena(cadena, 1, último - 1))
    SI NO
        Devolver Falso
    FIN SI

FIN FUNCIÓN