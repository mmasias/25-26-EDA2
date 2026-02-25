# Eliminar aparaciones de un letra en una palabra

<div align='center'>

| Caso   | n      | f(n) |
| ------ | ------ | ---- |
| CB     | ""     | ""   |
| ...    |        |      |
| CR n-1 | "olor"  | "lr"  |
| CR n   | "dolor" | "dlr" |

</div>

* Para el caso en el que la cabeza sea lo que buscamos eliminar -> fn = f(n-1)
* Para el caso que la cabeza no es la letra que buscamos eliminar -> f(n) = cabeza + f(n -1)

## Pseudocodigo 

```text

FUNCTION eliminarLetra(word, letter)

    IF word IS empty THEN
        RETURN " "
    ELSE
        IF word[0] == letter THEN
            Result = eliminarLetra(word[longitud(word)-1], letter)
        ELSE
            Result = word[0] + eliminarLetra(word[longitud(word)-1], letter)
        ENDIF
    ENIF

    RETURN Result
END FUNCTION

    