# conversorBinario

Convertir un número entero decimal positivo a su representación en binario. Por definición, el número 0 en binario es "0" y el 1 es "1".

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|        | n  | f(n)            |
|--------|---:|-----------------|
| CB     | 0  | "0"             |
| CB     | 1  | "1"             |
| ...    |... | ...             |
| CR n/2 | 6  | "110"           |
| CR n   | 13 | "1101" = f(6) + "1" |

f(n) = f(n / 2) + convertirACadena(n módulo 2)


</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION conversorBinario(n)

    SI n es 0 ENTONCES
        Devolver "0"
    FIN SI

    SI n es 1 ENTONCES
        Devolver "1"
    FIN SI

    resto = n módulo 2
    mitad = n / 2  // división entera

    Devolver conversorBinario(mitad) + convertirACadena(resto)

FIN FUNCIÓN
```

</details>