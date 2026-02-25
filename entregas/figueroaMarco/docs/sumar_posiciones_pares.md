# En una lista, sumar elementos en posiciones pares.

## Analisis recursivo

<div align=center>

| Tipo    | n           | f(n) |
|---------|-----------------|------|
| CB      | []              | 0    |
| CB      | [9]             | 9    |
| ...     | ...             | ...  |
| CR n-1  | [3, 7, 5]       | 8   |
| CR n    | [3, 7, 5, 2, 10] | 18   |


f(n) = cabeza + f(n - 1)

</div>


## Pseudocodigo

```text
FUNCTION sumarPosicionesPares(list)

    IF length(list) == 0 THEN
        Result = 0

    ELSE IF length(list) == 1 ELSE
        Result = list[0]

    ELSE
        head = list[0]
        missingSince2 = list[2..length(list)-1]
    END IF 

    Return Result

    END FUNCTION