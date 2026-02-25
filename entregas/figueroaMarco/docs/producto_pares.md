# Product de pares hasta n

## Analisis recursivo

<div align=center>

| Tipo    |   n |   f(n) |
|---------|----:|--------:|
| CB      |   2 |       2 |
| ...     | ... |     ... |
| CR n-1  |   8 |    1152 |
| CR n    |  10 |    11520|


n * f(n -1)


</div>


```text

FUNCTION productoPares(n)

    IF n == 2 THEN

        Result = 2
    
    ELSE
        IF n % 2 != 0 THAN

            Result = productoPares(n - 1)
        ELSE
            Result = n * productoPares(n - 2)
        ENDIF
    ENDIF

    RETURN Result
END FUNCTION
