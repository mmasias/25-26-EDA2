# decimalABinario
Convertir un número decimal entero positivo a su representación en binario como cadena de texto.

## Análisis recursivo
<div align=center>

| Tipo    | n    | f(n) |
|---------|-----:|-----:|
| CB      | 1    | "1"  |
| ...     | ...  | ...  |
| CR n/2  | 6    | "110"|
| CR n    | 13   | "1101"|

13 en binario es "1101"
6 en binario es "110"
"1101" = "110" + "1"
→ **f(n) = f(n / 2) + (n MOD 2)**
(donde *n/2* es la mitad del número que genera los bits previos, y *n MOD 2* es el bit actual)

</div>

## Pseudocódigo
```text
FUNCION decimalABinario(n)
    SI n < 2 ENTONCES
        Resultado = Cadena(n)
    SINO
        Resultado = decimalABinario(n / 2) + Cadena(n MOD 2)
    FIN SI
    Devolver Resultado
FIN FUNCIÓN