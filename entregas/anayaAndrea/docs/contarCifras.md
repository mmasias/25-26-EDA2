# contarCifrasNumero

Calcular la cantidad de cifras de un número entero positivo.

## Análisis recursivo

Ejemplo: n = 907354

| Caso | n | f(n) |
|------|----|------|
| CB | 9 | 1 |
| ... | ... | ... |
| CR n-1 | 90735 | 5 |
| CR n | 907354 | 6 |

Patrón de recursividad:

f(n) = 1 si n < 10  
f(n) = 1 + f(n / 10)

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        devolver 1
    FIN SI

    devolver 1 + contarCifras(n / 10)

FIN FUNCION