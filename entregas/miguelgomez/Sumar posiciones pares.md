# sumarIndicesPares

Realizar la suma de los componentes de una lista ubicados en los índices 0, 2, 4, etc.

## Análisis recursivo

<div align=center>

| Tipo    | lista           | f(n) |
|---------|-----------------|------|
| CB       | []              | 0    |
| CB       | [9]             | 9    |
| ...      | ...             | ...  |
| CR n-1   | [8, 1, 5]       | 13   |
| CR n     | [4, 7, 8, 1, 5] | 17   |

Ejemplo anterior:  
[8, 1, 5] → 8 + 5 = 13  

Ejemplo actual:  
[4, 7, 8, 1, 5] → 4 + 13 = 17  

Regla recursiva:  
**f(lista) = inicial + f(lista a partir del índice 2)**

</div>

## Pseudocódigo

```text
FUNCION sumaPares(lista)

    SI longitud(lista) == 0 ENTONCES
        Resultado = 0

    SINO SI longitud(lista) == 1 ENTONCES
        Resultado = lista[0]

    SINO
        primero = lista[0]
        salto = lista[2...final]

        Resultado = primero + sumaPares(salto)
    FIN SI

    Devolver Resultado

FIN FUNCIÓN
