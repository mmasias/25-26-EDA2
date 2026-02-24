# Conversor a binario

Convertir un número entero positivo *n* a su representación en binario utilizando recursividad.

Ejemplo: 13 → 1101

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

Ejemplo: 13

|        |  n  | f(n) |
| ------ | ---:| ---- |
| CB     |  0  | ""   |
| CB     |  1  | "1"  |
| ...    | ... | ...  |
| CR     |  6  | "110"|
| CR     | 13  | "1101"|

"1101" = convertirBinario(n / 2) + (n % 2)

Si n < 2 ⇒ devolver n  
Si n ≥ 2 ⇒ convertirBinario(n / 2) + (n % 2)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION convertirBinario(n)

    SI n < 2 ENTONCES
        Resultado = convertir n a texto
    SINO
        Resultado = convertirBinario(n / 2) + (n % 2)
    FIN SI

    DEVOLVER Resultado

FIN FUNCION
```

</details>