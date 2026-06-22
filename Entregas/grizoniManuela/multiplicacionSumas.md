### Multiplicación por sumas

Calcular el producto de dos números usando solo sumas.

## Análisis recursivo

<div align=center>

| Tipo |  a,b | f(a,b) |
|------|-----:|-------:|
| CB   | 5,0  |      0 |
| ...  | ...  |    ... |
| CR   | 5,1  |      5 |
| CR   | 5,2  |     10 |
| CR   | 5,3  |     15 |
| CR n-1 | 5,4  |     20 |
| CR n | 5,5  |     25 |

25 = 5 + 20 → **a + f(a, b - 1)**

</div>

## Pseudocódigo

```text
FUNCION multiplicar(a, b)

    SI b == 0 ENTONCES

        Resultado = 0

    SI NO

        Resultado = a + multiplicar(a, b - 1)

    FIN SI

    Devolver Resultado

FIN FUNCIÓN