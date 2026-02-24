# convertirBinario

Convertir un número entero decimal positivo a su representación binaria en formato de cadena de texto (String).

## Análisis recursivo

<div align=center>

| Tipo    | n  | f(n)  |
|---------|----|-------|
| CB      | 1  | "1"   |
|...  | ...  | ...  |
| CR n-1  | 6  | "110" |
| CR n    | 13 | "1101"|

Patrón de recursividad:

- Si `n == 0` → **f(n) = "0"**
- Si `n == 1` → **f(n) = "1"**
- Para cualquier otro n → **f(n) = f(n / 2) + ConvertirAString(n mod 2)**

</div>

## Pseudocódigo

```text
FUNCION convertirBinario(n)

    SI n == 0 ENTONCES
        Resultado = "0"
    SINO SI n == 1 ENTONCES
        Resultado = "1"
    SINO
        mitad = n / 2      // División entera
        bitActual = n MOD 2
        
        // El símbolo '+' aquí significa concatenar texto
        Resultado = convertirBinario(mitad) + bitActual
    FIN SI

    Devolver Resultado

FIN FUNCIÓN