### Sumar dígitos

Calcular la suma de todos los dígitos de un número entero.

## Análisis recursivo

<div align=center>

| Tipo   |     n | f(n) |
|--------|------:|-----:|
| CB     |     5 |    5 |
| ...    |   ... |  ... |
| CR n-1 |  5342 |   14 |
| CR n   | 53421 |   15 |

15 = 5 + 14 → **cabeza + f(resto)**

</div>

> Idea: **cabeza** = primer dígito, **resto** = el número sin ese primer dígito.

## Pseudocódigo

```text
FUNCION sumaDigitos(n)

    SI n < 10 ENTONCES

        Resultado = n

    SI NO

        numeroDeDigitos = contarDigitos(n)
        divisor = 10^(numeroDeDigitos - 1)

        cabeza = n / divisor
        resto = n % divisor

        Resultado = cabeza + sumaDigitos(resto)

    FIN SI

    Devolver Resultado

FIN FUNCIÓN