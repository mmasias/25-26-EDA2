# 9. CONVERSOR A BINARIO

Convertir n a binario (como texto), sin DIV ni MOD.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|Caso|n|f(n)|
|---|---:|---|
|CB|0|"0"|
|CB|1|"1"|
|...|...|...|
|n-1|5|"101"|
|n|6|"110"|

Idea:
- el “último bit” es 0 si n es par, 1 si n es impar
- el “siguiente n” es ⌊n/2⌋, y sin dividir lo hacemos con mitadEntera(n)

f(n) = f(mitadEntera(n)) + bitFinal

</div>

</details>

## Pseudocódigo

```text
FUNCION aBinario(n)

    SI n == 0 ENTONCES
        DEVOLVER "0"
    FIN SI

    SI n == 1 ENTONCES
        DEVOLVER "1"
    FIN SI

    SI esPar(n) ENTONCES
        bit = "0"
    SINO
        bit = "1"
    FIN SI

    DEVOLVER aBinario(mitadEntera(n)) + bit

FIN FUNCION
```