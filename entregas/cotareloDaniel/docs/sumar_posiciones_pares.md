# sumarPosicionesPares

En una lista, sumar los elementos que se encuentran en posiciones pares (0, 2, 4, etc.).

## Análisis recursivo

<div align=center>

| Tipo    | lista       | f(n) |
|---------|-------------|------|
| CB      | []          | 0    |
| CB      | [7]         | 7    |
| ...     | ...         | ...  |
| CR n-1  | [5,6,7]     | 12   |
| CR n    | [2,5,6,7]   | 14   |

En el grado anterior:  
[5,6,7] → 5 + 7 = 12  

En el grado actual:  
[2,5,6,7] → 2 + 12 = 14  

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
