# Binario

Calcular la representación binaria de un número entero positivo.

## Análisis recursivo

<div align=center>

Aquí lo tienes con el formato exacto, listo para copiar y pegar en tu archivo .md:

Markdown
# Binario
Calcular la representación binaria de un número entero positivo.
## Análisis recursivo
<div align=center>
| Tipo    | n  | f(n)     |
|---------|---:|----------|
| CB      | 1  | "1"      |
| ...     | .. | ...      |
| CR n-1  | 6  | "110"    |
| CR n    | 13 | "1101"   |


6 en binario es 110 
13 en binario es 1101
1101 = 110 y 1
→ **f(n) = f(n-1) y último bit**  


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