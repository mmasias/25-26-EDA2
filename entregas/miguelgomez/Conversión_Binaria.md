# representarBinario

Obtener la equivalencia en sistema binario de un número entero positivo.

## Análisis recursivo

<div align=center>

| Tipo    | n  | f(n)      |
|---------|---:|----------|
| CB       | 1  | "1"       |
| ...      | .. | ...       |
| CR n-1   | 6  | "110"     |
| CR n     | 13 | "1101"    |


El 6 equivale a 110 en binario. 
El 13 equivale a 1101 en binario.
1101 se compone de 110 unido a 1.
→ **f(n) = f(n/2) + residuo actual** </div>

## Pseudocódigo

```text
FUNCION convertirABinario(n)

    SI n < 2 ENTONCES
        Resultado = texto(n)
    SINO
        Resultado = convertirABinario(n / 2) CONCATENAR texto(n % 2)
    FIN SI

    Devolver Resultado

FIN FUNCIÓN
