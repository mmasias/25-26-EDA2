# Conversor a binario
Convertir un número entero decimal positivo a su representación en formato binario.
## Análisis recursivo
(Ejemplo convirtiendo el número 13)
<div align=center>
| Tipo    |   n |   f(n) |
|---------|----:|-------:|
| CB      |   1 |    "1" |
| ...     | ... |    ... |
| CR n-1  |   6 |  "110" |
| CR n    |  13 | "1101" |
"1101" = "110" + "1" → f(n / 2) + (n % 2)
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
```