# Contar las cifras de un numero

## Analisis recursivo

<div align=center>

| Tipo    | n   | f(n) |
|---------|----:|------:|
| CB      | 6   |    1 |
| ...     | ... |  ... |
| CR n-1  | 685 |    3  |
| CR n    | 6853|    4 |


** f(n) = f(n-1) **

</div>


### Pseudocodigo

```text 

FUNTION contarCifras(n)

    IF n < 10 THEN
        Result = 1
    ELSE 
        RESULT = 1 + contarCifras(n / 10)
    END SI

    RETURN Result

END FUNCTION