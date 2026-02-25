# En una lista, sumar elementos en posiciones pares

## Análisis recursivo

<div align=center>

| Tipo | Lista         | f(lista) |
|------|---------------|---------:|
| CB   | []            | 0 |
| ...  | ...           | ... |
| CR   | [5,9,2,7,4]   | 11 |

Posiciones pares (0,2,4): 5 + 2 + 4 = 11  
f(lista) = primero + f(lista desde índice 2)

</div>

## Pseudocódigo

```text
FUNCION sumaPosicionesPares(lista)

    SI lista ESTA VACIA ENTONCES

        Resultado = 0

    SI NO

        SI LONGITUD(lista) == 1 ENTONCES

            Resultado = PRIMER_ELEMENTO(lista)

        SINO

            primero = PRIMER_ELEMENTO(lista)
            resto   = SUBLISTA_DESDE_INDICE(lista, 2)

            Resultado = primero + sumaPosicionesPares(resto)

        FIN SI

    FIN SI

    Devolver Resultado

FIN FUNCIÓN