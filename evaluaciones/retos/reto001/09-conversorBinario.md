# Conversor a binario

## Análisis recursivo

| Tipo | Entrada (n) | Salida |
|------|-------------|--------|
| CB | 0 | "0" |
| CB | 1 | "1" |
| CR n-1 | 5 | "101" |
| CR n | 11 | "1011" |

**Observación en aspa:**
- Para n=11: 11 / 2 = 5, resto = 1
- El binario de 5 es "101"
- Concateno: "101" + "1" = "1011"

**Relación recursiva:** `binario(n) = binario(n / 2) + (n % 2)`

## Pseudocódigo

```
funcion aBinario(n)
    si n == 0 entonces
        devolver "0"
    sino si n == 1 entonces
        devolver "1"
    sino
        devolver aBinario(n / 2) + toString(n % 2)
    fin si
fin funcion
```

**Versión optimizada:**

```
funcion aBinario(n)
    si n < 2 entonces
        devolver toString(n)
    sino
        devolver aBinario(n / 2) + toString(n % 2)
    fin si
fin funcion
```
