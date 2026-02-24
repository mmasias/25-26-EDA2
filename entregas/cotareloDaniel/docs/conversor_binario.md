# Binario

Calcular la representación binaria de un número entero positivo.

## Análisis recursivo

<div align=center>

| Tipo    | n  | f(n)     |
|---------|---:|----------|
| CB      | 1  | "1"      |
| ...     | .. | ...      |
| CR n-1  | 9  | "1001"   |
| CR n    | 18 | "10010"  |

9 en binario es "1001"  
18 en binario es "10010"

"10010" = "1001" & "0"  
→ **f(n) = f(n-1) & último bit**  
(donde *n-1* es el cociente de dividir entre 2)

</div>

## Pseudocódigo

```text
FUNCION binario(n)

    SI n < 2 ENTONCES
        Resultado = string(n)
    SINO
        Resultado = binario(n / 2) CONCAT string(n % 2)
    FIN SI

    Devolver Resultado

FIN FUNCIÓN
