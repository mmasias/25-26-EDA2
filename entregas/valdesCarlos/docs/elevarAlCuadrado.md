# elevarCuadrado

Calcular el cuadrado de `n` (n²) de forma recursiva basándose en la fórmula matemática: `n² = (n-1)² + 2n - 1`.

## Análisis recursivo

<div align=center>

| Tipo    | n | f(n) |
|---------|---|------|
| CB      | 0 | 0    |
| ...     |...| ...  |
| CR n-1  | 2 | 4    |
| CR n    | 3 | 9    |


Patrón de recursividad:

- Si `n == 0` → **f(n) = 0**
- Para cualquier otro `n` → **f(n) = f(n-1) + (2 * n) - 1**

</div>

## Pseudocódigo

```text
FUNCION elevarCuadrado(n)

    SI n == 0 ENTONCES
        Resultado = 0
    SINO
        Resultado = elevarCuadrado(n - 1) + (2 * n) - 1
    FIN SI

    Devolver Resultado

FIN FUNCIÓN