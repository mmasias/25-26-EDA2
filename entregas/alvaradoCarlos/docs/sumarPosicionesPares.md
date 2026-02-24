# Sumar elementos en posiciones pares

En una lista, sumar elementos en posiciones pares hasta n

## Análisis Recursivo

<details>
<summary>Ver análisis</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|""|0
...
...
n-2|"**1**, 2, **3**, 4, **5**"|9
n-1|"**1**, 2, **3**, 4, **5**, 6"|9
n|"**1**, 2, **3**, 4, **5**, 6, **7**"|16
...
...
n-2|"**1**, 2, **3**, 4, **5**, 6, **7**"|16
n-1|"**1**, 2, **3**, 4, **5**, 6, **7**, 8"|16
n|"**1**, 2, **3**, 4, **5**, 6, **7**, 8, **9**"|25

Tomando en cuenta al 0 como par, y que la lista se inicia desde 0, cada vez que se avanza un grado el resultado no cambia, pero cada 2 grados si cambia y el valor sumado al resultado es la cola de la lista.

[Imágen de Análisis](/entregas/alvaradoCarlos/images/sumarPosicionesPares.jpeg)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION sumarPosicionesPares(n)

    SI n == "" ENTONCES
        Devolver 0
    FIN SI

    PosicionActual = longitud(lista) - 1

    SI PosicionActual % 2 == 0 ENTONCES
        Devolver lista[PosicionActual] + sumarPosicionesPares(lista sin el ultimo)
    SI NO
        Devolver sumarPosicionesPares(lista sin el ultimo)
    FIN SI

FIN FUNCIÓN
```

</details>

