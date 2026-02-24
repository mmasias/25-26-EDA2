# Sumar posiciones pares

En una lista, sumar los elementos que se encuentran en posiciones pares (0, 2, 4, etc.).

<details>

<summary>Ver análisis recursivo</summary>

<div align=center>

| Tipo    | lista            | f(n) |
|---------|------------------|------|
| CB      | []               | 0    |
| CB      | [8]              | 8    |
| ...     | ...              | ...  |
| CR n-1  | [4,7,2,9]        | 6    |
| CR n    | [8,4,7,2,9]      | 14   |

En el grado anterior:  
[4,7,2,9] → 4 + 2 = 6  

En el grado actual:  
[8,4,7,2,9] → 8 + 6 = 14  

Patrón de recursividad:  
**f(lista) = cabeza + f(lista desde la posición 2)**

</div>

</details>

## Pseudocódigo

<details>

<summary>Ver pseudocódigo</summary>

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
