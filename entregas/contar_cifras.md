# Contar las cifras de un número

Calcular la cantidad de cifras que tiene un número entero positivo.

## Análisis recursivo

<div align=center>

| Tipo    | n   | f(n) |
|---------|----:|-----:|
| CB      | 7   |    1 |
| ...     | ... |  ... |
| CR n-1  | 45  |    2 |
| CR n    | 456 |    3 |

456 tiene 3 cifras  
45 tiene 2 cifras  

3 = 1 + 2  
→ **f(n) = 1 + f(n / 10)** *(donde n / 10 es el número sin su última cifra)*

</div>

## Pseudocódigo

```text
FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        Resultado = 1
    SINO
        Resultado = 1 + contarCifras(n / 10) // División entera
    FIN SI

    Devolver Resultado

FIN FUNCIÓN