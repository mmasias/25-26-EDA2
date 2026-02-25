# esPalindromo
Comprobar si una cadena de texto se lee igual de izquierda a derecha que de derecha a izquierda usando recursividad.

## Análisis recursivo
<div align=center>

| Tipo        | cadena  | f(cadena) |
|-------------|--------:|----------:|
| CB          | "d"     | VERDADERO |
| CR centro   | "ada"   | VERDADERO |
| CR centro   | "radar" | VERDADERO |

"radar" es Verdadero porque 'r' == 'r' y f("ada") es Verdadero
"ada" es Verdadero porque 'a' == 'a' y f("d") es Verdadero
"d" es Verdadero por ser caso base (longitud <= 1)
→ **f(cadena) = (primera == última) Y f(centro)**
(donde *centro* es la cadena original sin su primera ni su última letra)

</div>

## Pseudocódigo
```text
FUNCION esPalindromo(cadena)
    SI longitud(cadena) <= 1 ENTONCES
        Resultado = VERDADERO
    SINO
        primeraLetra = obtenerPrimerCaracter(cadena)
        ultimaLetra = obtenerUltimoCaracter(cadena)
        
        SI primeraLetra != ultimaLetra ENTONCES
            Resultado = FALSO
        SINO
            centro = cadenaSinExtremos(cadena) // Elimina índice 0 y el último
            Resultado = esPalindromo(centro)
        FIN SI
    FIN SI
    Devolver Resultado
FIN FUNCIÓN