# productoParesHastaN

Calcular el producto de los números pares desde 2 hasta n .

## Análisis recursivo

Ejemplo: n = 14

| Caso | n | f(n) |
|------|----|------|
| CB | 0 | 1 |
| ... | ... | ... |
| CR n-1 | 12 | 46080 |
| CR n | 14 | 645120 |

Patrón de recursividad:

f(n) = 1 si n < 2  
f(n) = f(n-1) si n es impar  
f(n) = n * f(n-2) si n es par

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION productoPares(n)

    SI n < 2 ENTONCES
        devolver 1
    FIN SI

    SI n % 2 != 0 ENTONCES
        devolver productoPares(n - 1)
    FIN SI

    devolver n * productoPares(n - 2)

FIN FUNCION