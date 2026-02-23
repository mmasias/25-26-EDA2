# contarCifras

Contar la cantidad de dígitos o cifras que tiene un número entero positivo. Por definición, si el número es menor a 10, solo tiene 1 cifra.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|        | n   | f(n)         |
|--------|----:|--------------|
| CB     | 5   | 1            |
| CB     | 9   | 1            |
| ...    | ... | ...          |
| CR n-1 | 42  | 2 = 1 + 1    |
| CR n   | 428 | 3 = 1 + f(42)|

f(n) = 1 + f(n-1) / 10 --> division euclidiana

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        Devolver 1
    FIN SI

    Devolver 1 + contarCifras(n / 10)  // división entera

FIN FUNCIÓN
```

</details>