# Validar si una palabra es un palíndromo

Comprobar si una palabra se lee igual de izquierda a derecha que de derecha a izquierda.

## Análisis recursivo

<div align=center>

| Tipo    | palabra | f(palabra) |
|---------|---------|------------|
| CB      | "d"     | verdadero  |
| ...     | ...     | ...        |
| CR n-1  | "ada"   | verdadero  |
| CR n    | "radar" | verdadero  |

"ada" es palíndromo porque la primera y última letra son 'a', y el centro ("d") es palíndromo.  
"radar" es palíndromo porque la primera y última letra son 'r', y el centro ("ada") es palíndromo.  

→ **f(palabra) = (primera == última) Y f(palabra sin la primera ni la última letra)** *(Nota: El caso base se alcanza cuando queda 1 letra o ninguna, en cuyo caso siempre es verdadero).*
</div>

## Pseudocódigo

```text
FUNCION esPalindromo(palabra)

    SI longitud(palabra) <= 1 ENTONCES
        Resultado = VERDADERO
    SINO
        PrimeraLetra = palabra[0]
        UltimaLetra = palabra[longitud(palabra) - 1]
        
        SI PrimeraLetra == UltimaLetra ENTONCES
            // Extraemos el centro quitando el primer y el último carácter
            Centro = subcadena(palabra, 1, longitud(palabra) - 2)
            Resultado = esPalindromo(Centro)
        SINO
            Resultado = FALSO
        FIN SI
    FIN SI

    Devolver Resultado

FIN FUNCIÓN