# 8. Sumar elementos en posiciones pares

Suma los elementos en índices 0, 2, 4...

## Análisis recursivo

| Caso | lista | f(lista) |
|------|-------|----------|
| CB | [] | 0 |
| ... | ... | ... |
| n−2 | [3,4,5] | 8 |
| n | [1,2,3,4,5] | 9 |

Análisis de pasos:
- La suma par de [1, 2, 3, 4, 5] es 9 ($1+3+5$).
- La suma par de [3, 4, 5] es 8 ($3+5$).
- Por lo tanto: $9 = 1 + (resultado\ de\ [3, 4, 5])$.

**Relación:** $f(n) = cabeza + f(cola.cola)$

## Pseudocódigo
```text
FUNCION sumarPosicionesPares(lista)
    SI lista es vacía ENTONCES
        Devolver 0
    FIN SI

    cabeza = obtenerCabeza(lista)
    restoPar = obtenerCola(obtenerCola(lista))

    Devolver cabeza + sumarPosicionesPares(restoPar)
FIN FUNCION