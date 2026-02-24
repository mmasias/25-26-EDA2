# sumarPosicionesPares

En una lista, sumar los elementos que se encuentran en posiciones pares (0, 2, 4, etc.).

## Análisis recursivo

<div align=center>

| Tipo    | lista           | f(n) |
|---------|-----------------|------|
| CB      | []              | 0    |
| CB      | [9]             | 9    |
| ...     | ...             | ...  |
| CR n-1  | [8, 1, 5]       | 13   |
| CR n    | [4, 7, 8, 1, 5] | 17   |

En el grado anterior:  
[8, 1, 5] → 8 + 5 = 13  

En el grado actual:  
[4, 7, 8, 1, 5] → 4 + 13 = 17  

Patrón de recursividad:  
**f(lista) = cabeza + f(lista desde la posición 2)**

</div>

## Pseudocódigo

```text
FUNCION sumarPosicionesPares(lista)

    SI longitud(lista) == 0 ENTONCES
        Resultado = 0

    SINO SI longitud(lista) == 1 ENTONCES
        Resultado = lista[0]

    SINO
        cabeza = lista[0]
        restoDesde2 = lista[2...longitud(lista)-1]

        Resultado = cabeza + sumarPosicionesPares(restoDesde2)
    FIN SI

    Devolver Resultado

FIN FUNCIÓN