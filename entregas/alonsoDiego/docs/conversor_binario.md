# Conversor a binario

Convertir un número entero decimal positivo a su formato binario.

## Análisis recursivo
(Ejemplo convirtiendo el número 5)

<div align=center>

| Tipo    |   n | f(n) |
|---------|----:|-----:|
| CB      |   1 |  "1" |
| ...     | ... |  ... |
| CR n-1  |   2 | "10" |
| CR n    |   5 |"101" |

"101" = "10" + "1" → f(n / 2) + (n % 2)

</div>

## Pseudocódigo

```text
FUNCION conversorBinario(n)

    SI n <= 1 ENTONCES

        Devolver n

    SINO

        Devolver conversorBinario(n / 2) + (n % 2)

    FIN SI

FIN FUNCIÓN