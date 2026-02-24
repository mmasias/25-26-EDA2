# Sumar elementos en posiciones pares

Dada una lista, calcular la suma de los elementos que están en posiciones pares.
(Considerando que la primera posición es la 0).

Ejemplo: [10,20,30,40,50]

Posiciones pares: 0,2,4 → 10 + 30 + 50 = 90

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|        | lista              | f(lista) |
| ------ | ------------------ | -------- |
| CB     | []                 | 0        |
| CB     | [50]               | 50       |
| ...    | ...                | ...      |
| CR n-1 | [30,40,50]         | 80       |
| CR n   | [10,20,30,40,50]   | 90       |

90 = 10 + 80  
resultado = lista[0] + sumarPosicionesPares(lista desde posición 2)

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
        Resultado = lista[0] + sumarPosicionesPares(sublista desde posicion 2)
    FIN SI

    DEVOLVER Resultado

FIN FUNCION
