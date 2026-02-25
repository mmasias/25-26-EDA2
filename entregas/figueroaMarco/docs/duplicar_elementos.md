# En una lista, duplicar sus elementos ([1,2,3] convertirla en [1,1,2,2,3,3])

<div align=center>

| Tipo    | lista     | f(n)              |
|---------|-----------|-------------------|
| CB      | []        | []                |
| ...     | ...       | ...               |
| CR n-1  | [5,10]     | [5,5,10,10]         |
| CR n    | [2,5,10]   | [2,2,5,5,10,10]     |


f(n) = 2 * cabeza + f(n-1)

</div>

```text

FUNCTION duplicarElementos(list)

    IF list IS empty THEN
        Result = []
    ELSE
        Element =  list[0]
        MissingDuplicate = duplicarElementos(list[1...lenth(list)-1)])
        Result = [Element, Element] + MissingDuplicate
    END IF

    RETURN Result

END FUNCTION