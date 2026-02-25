# En una palabra/frase, reeemplazar una letra por otra

## Analisis recursivo

<div align=center>

| Tipo    | palabra , x , y| f(n) |
|---------|---------|----------------|
| CB      | ""      | ""             |
| ...     | ...     | ...            |
| CR n-1  | "dinon" , "n" "l" | "dilol"         |
| CR n    | "dinona" ,"n" , "l" | "dilola"        |

</div>

## Pseudocodigo

```text

FUNCTION reemplazarLetra(word, oldLetter newLetter)

    IF word IS empty THEN
        Result = ""
    ELSE
        head = word[0]
        missing = word[1...]
    
        IF cabeza  == oldLetter THEN
            Result = oldLetter + reemplazarLetra(missing, oldLetter, newLetter )
        ELSE
            Result = head + reemplazarLetra(missing, oldLetter, newLetter )
        
        ENDIF
    END IF

    RETURN Result
END FUNCTION
