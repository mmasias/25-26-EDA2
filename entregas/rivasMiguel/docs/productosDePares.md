## productoPares (Fórmula Única)

<details>
<summary>Ver análisis recursivo</summary>

<div align="center">

| n | f(n-1) | Operación     | Resultado f(n) |
|---|--------|--------------|----------------|
| 2 | —      | Caso Base    | 2              |
| 3 | 2      | 1 × 2        | 2              |
| 4 | 2      | 4 × 2        | 8              |
| 5 | 8      | 1 × 8        | 8              |
| 6 | 8      | 6 × 8        | 48             |

((((n+1) % 2) x (n-1)) + 1) x f(n-1)

</div>

</details>

---

## Pseudocódigo

<details>
<summary>Ver pseudocódigo (Fórmula Única)</summary>

FUNCION productoPares(n)

    SI n <= 2 ENTONCES
        DEVOLVER 2
    FIN SI

    acumuladoAnterior ← productoPares(n - 1)

    M ← ((n + 1) MOD 2) * (n - 1) + 1

    DEVOLVER M * acumuladoAnterior

FIN FUNCION
</details>

## Implementación

<details>
<summary>Ver código Java</summary>

```java
public static int f(int n) {
    if (n <= 2) return 2;

    int multiplicador = ((n + 1) % 2) * (n - 1) + 1;

    return multiplicador * f(n - 1);
}