# Validar palindromo

## Analisis recursivo


<div align=center>

| Tipo    | palabra  | f(n)  |
|---------|----------|-------|
| CB      | ""       | TRUE  |
| ...     | ...      | ...   |
| CR n-1  | "ada"   | TRUE  |
| CR n    | "radar" | TRUE  |

f(n) = (cabeza = cola) AND f(n - 1)

</div>


```text

FUNCTION palindromo(word)

    IF length(word) <= 1 THEN
        RETURN TRUE
    END IF

    IF head(word) != tail(word) THEN
        RETURN false
    END IF

    RETURN palindromo(substring(word, 2, length(word) - 1))

END FUNCTION
