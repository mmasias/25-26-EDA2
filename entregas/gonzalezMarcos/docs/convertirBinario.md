# Conversor a binario

Convertir un número entero decimal a su representación en formato de texto binario.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|0|"0"
CB|1|"1"
...|...|...
n-1|2|"10"
n|5|"101"

</div>

f(n / 2) + (n módulo 2)


</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION aBinario(n)

    SI n es 0 ENTONCES
        Devolver "0"
    FIN SI
    
    SI n es 1 ENTONCES
        Devolver "1"
    FIN SI

    cociente = n división entera entre 2
    restoModulo = n módulo 2 (convertido a texto)

    Devolver aBinario(cociente) + restoModulo

FIN FUNCIÓN
```

</details>