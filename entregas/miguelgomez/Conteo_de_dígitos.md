# longitudDeEntero

Determinar la cantidad de dígitos que integran un número entero.

## Análisis recursivo

<div align=center>

| Tipo    | n   | f(n) |
|---------|----:|------:|
| CB       | 9   |     1 |
| ...      | ... |   ... |
| CR n-1   | 972 |   3   |
| CR n     | 9721|     4 |

El valor 9721 consta de 4 cifras, mientras que 972 posee 3.
 

4 = 1 + 3 
→ **f(n) = 1 + f(n / 10)** Básicamente, el caso n-1 consiste en el número original tras haberle removido su última cifra.

</div>

## Pseudocódigo

```text
FUNCION calcularCifras(n)

    SI n < 10 ENTONCES
        Resultado = 1
    SINO
        Resultado = 1 + calcularCifras(n / 10)
    FIN SI

    Devolver Resultado

FIN FUNCIÓN