# sumarPosicionesPares
Sumar únicamente los números que se encuentran en índices pares (0, 2, 4...) de una lista utilizando recursividad.

## Análisis recursivo
<div align=center>

| Tipo        | lista                | f(lista) |
|-------------|---------------------:|---------:|
| CB (vacía)  | []                   | 0        |
| CB (1 elem) | [50]                 | 50       |
| ...         | ...                  | ...      |
| CR resto    | [30, 40, 50]         | 80       |
| CR lista    | [10, 20, 30, 40, 50] | 90       |

[10, 20, 30, 40, 50] sumando pares es 10 + 80
[30, 40, 50] sumando pares es 30 + 50
[50] sumando pares es 50 (está en el índice 0 de su sublista)
→ **f(lista) = primero + f(resto)**
(donde *primero* es el elemento en el índice 0, y *resto* es la lista cortada desde el índice 2 en adelante)

</div>

## Pseudocódigo
```text
FUNCION sumarPosicionesPares(lista)
    SI longitud(lista) == 0 ENTONCES
        Resultado = 0
    SINO SI longitud(lista) == 1 ENTONCES
        Resultado = lista[0]
    SINO
        primero = lista[0]
        resto = listaSinLosDosPrimeros(lista) // Extrae desde el índice 2
        
        Resultado = primero + sumarPosicionesPares(resto)
    FIN SI
    Devolver Resultado
FIN FUNCIÓN