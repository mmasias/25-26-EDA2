# Sumar elementos en posiciones pares
Dada una lista de números, calcular la suma de los elementos que se encuentran en posiciones pares 
## Análisis recursivo
(Ejemplo con la lista [5, 10, 15, 20])
<div align=center>
| Tipo    |           lista | f(lista) |
|---------|----------------:|---------:|
| CB      |             [5] |        0 |
| ...     |             ... |      ... |
| CR n-1  |        [15, 20] |       20 |
| CR n    | [5, 10, 15, 20] |       30 |
30 = 10 + 20 → segundo + f(resto)
</div>
## Pseudocódigo
```text
FUNCION sumarPosicionesPares(lista)

    SI longitud(lista) < 2 ENTONCES

        Devolver 0

    SINO

        segundo = segundo elemento de lista
        resto = lista sin los dos primeros elementos

        Devolver segundo + sumarPosicionesPares(resto)

    FIN SI

FIN FUNCIÓN
```