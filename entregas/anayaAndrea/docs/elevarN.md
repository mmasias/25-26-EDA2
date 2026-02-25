# elevarCuadrado

Calcular n² usando recursividad.

## Análisis recursivo

Ejemplo: n = 11

| Caso | n | f(n) |
|------|----|------|
| CB | 0 | 0 |
| ... | ... | ... |
| CR n-1 | 10 | 100 |
| CR n | 11 | 121 |

Patrón de recursividad:

f(0) = 0  
f(n) = f(n-1) + 2n - 1

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION cuadrado(n)

    SI n == 0 ENTONCES
        devolver 0
    FIN SI

    devolver cuadrado(n-1) + 2*n - 1

FIN FUNCION