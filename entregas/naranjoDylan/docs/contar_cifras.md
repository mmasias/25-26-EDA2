# contarCifrasNumero

Ver cuantas cifras tiene un numero entero.

## Análisis recursivo

<div align=center>

| Tipo    | n   | f(n) |
|---------|----:|------:|
| CB      | 9   |    1 |
| ...     | ... |  ... |
| CR n-1  | 972 |   3  |
| CR n    | 9721|    4 |

9721 tiene 4 cifras y 972 tiene 2 cifras 
 

4 = 1 + 3 
→ **f(n) = 1 + f(n-1)**  
En otras palabras la n-1 es n pero sin la ultima cifra

</div>

## Pseudocódigo

```text
FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        Resultado = 1
    SINO
        Resultado = 1 + contarCifras(n / 10)
    FIN SI

    Devolve Resultado

FIN FUNCIÓN