# Duplicar elementos de una lista
Dada una lista, devolver una nueva lista donde cada elemento original aparezca dos veces consecutivas.
## Análisis recursivo
(Ejemplo con la lista [1, 2, 3])
<div align=center>
| Tipo    |      lista |         f(lista) |
|---------|-----------:|-----------------:|
| CB      |         [] |               [] |
| ...     |        ... |              ... |
| CR n-1  |        [3] |           [3, 3] |
| CR n    |     [2, 3] |     [2, 2, 3, 3] |
[2, 2, 3, 3] = [2, 2] + [3, 3] → [cabeza, cabeza] + f(resto)
</div>
## Pseudocódigo
```text
FUNCION duplicarElementos(lista)

    SI longitud(lista) == 0 ENTONCES

        Devolver []

    SINO

        cabeza = primer elemento de lista
        resto = resto de la lista

        Devolver [cabeza, cabeza] + duplicarElementos(resto)

    FIN SI

FIN FUNCIÓN
```