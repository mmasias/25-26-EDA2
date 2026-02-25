# Elevar n al cuadrado

## Analisis recursivo

<div align=center>


| Tipo    | n   | f(n) |
|---------|----:|------:|
| CB      | 0   |    0  |
| ...     | ... |  ...  |
| CR n-1  | 5   |    25 |
| CR n    | 6   |    36 |

f(n) = f(n - 1) + 2n - 1

</div>

### Pseudocodigo

```text 

FUNCTION nAlCuarado(n)

    IF n == 0 THEN
        Result = 0
    ELSE
        Result = nAlCuadrado (n -1) + (2 * n) - 1
    ENDIF

    Return Result
    
END FUNCTION