## Sumar Posiciones Pares

En una lista, sumar los elementos que se encuentran en posiciones pares (0, 2, 4, etc.).

## Análisis recursivo

<div align=center>

| Tipo    | lista                  | f(n) |
|---------|------------------------|------|
| CB      | []                     | 0    |
| CB      | [50]                   | 50   |
| ...     | ...                    | ...  |
| CR n-2  | [30, 40, 50]           | 80   |
| CR n    | [10, 20, 30, 40, 50]   | 90   |

En el grado anterior:  
[30, 40, 50] → Cabeza es 30. El resto desde la posición 2 es [50]. Devuelve 30 + 50 = 80.

En el grado actual:  
[10, 20, 30, 40, 50] → Cabeza es 10. El resto desde la posición 2 es [30, 40, 50]. Devuelve 10 + 80 = 90.

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