# esPalindromo
Comprobar si una palabra o frase se lee igual de izquierda a derecha que de derecha a izquierda.

## Análisis recursivo
<div align=center>

| Tipo        | cadena      | f(cadena) |
|-------------|------------:|----------:|
| CB          | "" o "a"    | Verdadero |
| ...         | ...         | ...       |
| CR centro   | "c c"       | Verdadero |
| CR centro   | "bc cb"     | Verdadero |
| CR cadena   | "abc cba"   | Verdadero |

"abc cba" es Verdadero porque 'a' == 'a' y f("bc cb") es Verdadero.
"bc cb" es Verdadero porque 'b' == 'b' y f("c c") es Verdadero.
→ **f(n) = (primera == última) Y f(n_sin_extremos)**
(donde *n_sin_extremos* es la cadena sin su cabeza ni su cola)

</div>

## Pseudocódigo
```text
FUNCION esPalindromo(cadena)
    SI longitud(cadena) <= 1 ENTONCES
        Resultado = VERDADERO
    SINO SI primerCaracter(cadena) != ultimoCaracter(cadena) ENTONCES
        Resultado = FALSO
    SINO
        Resultado = esPalindromo(cadenaSinExtremos(cadena))
    FIN SI
    Devolver Resultado
FIN FUNCIÓN