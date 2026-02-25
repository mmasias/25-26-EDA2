# Conversor a binario

Calcular la representación binaria de un número entero positivo y devolverla como una cadena de texto.

## Análisis recursivo

<div align=center>

| Tipo    | n  | f(n)    |
|---------|---:|---------|
| CB      | 1  | "1"     |
| ...     | .. | ...     |
| CR n-1  | 9  | "1001"  |
| CR n    | 18 | "10010" |

9 en binario es "1001"  
18 en binario es "10010"

"10010" = "1001" + "0"  
→ **f(n) = f(n / 2) + string(n % 2)** *(f(cociente) concatenado con el último bit)*

</div>

## Pseudocódigo

```text
FUNCION binario(n)

    SI n < 2 ENTONCES
        Resultado = string(n)
    SINO
        // n / 2 es la división entera
        // n % 2 obtiene el resto (0 o 1)
        Resultado = binario(n / 2) CONCAT string(n % 2)
    FIN SI

    Devolver Resultado

FIN FUNCIÓN