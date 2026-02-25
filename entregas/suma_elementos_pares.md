# Sumar elementos en posiciones pares

Dada una lista de números, devolver la suma de los elementos que se encuentran en los índices pares (0, 2, 4...).

## Análisis recursivo

<div align=center>

| Tipo    | lista            | f(lista) |
|---------|------------------|---------:|
| CB      | []               |        0 |
| ...     | ...              |      ... |
| CR n-1  | [30, 40]         |       30 |
| CR n    | [10, 20, 30, 40] |       40 |

La suma de pares de `[30, 40]` es 30 (solo el índice 0)  
La suma de pares de `[10, 20, 30, 40]` es 40 (índices 0 y 2: 10 + 30)  

40 = 10 + 30  
→ **f(lista) = cabeza + f(lista saltando el segundo elemento)** </div>

## Pseudocódigo

```text
FUNCION sumarPosicionesPares(lista)

    SI longitud(lista) == 0 ENTONCES
        Resultado = 0
    SINO SI longitud(lista) == 1 ENTONCES
        // Si solo queda un elemento, está en posición par (índice 0)
        Resultado = lista[0]
    SINO
        Cabeza = lista[0]
        // Nos saltamos la posición 1 y tomamos desde la 2 en adelante
        RestoLista = lista[2...longitud(lista)-1]
        Resultado = Cabeza + sumarPosicionesPares(RestoLista)
    FIN SI

    Devolver Resultado

FIN FUNCIÓN