# Conversor a binario

Convierte un número entero positivo de base 10 a su representación binaria en formato de cadena de texto. La función recibe el número entero y devuelve un texto compuesto de ceros y unos.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||entrada (n)|f(n)|
|-|-:|-|
CB|0|"0"   # el binario de 0 es 0
CB|1|"1"   # el binario de 1 es 1
CR dividir y tomar módulo|n >= 2|f(n // 2) + texto(n mod 2)  # divide entre 2 y concatena el resto

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION convertirABinario(n)

    SI n == 0 ENTONCES
        Devolver "0"
    FIN SI
    
    SI n == 1 ENTONCES
        Devolver "1"
    FIN SI

    cociente <- división entera de n entre 2
    residuo  <- n módulo 2

    Devolver convertirABinario(cociente) + convertirATexto(residuo)

FIN FUNCIÓN