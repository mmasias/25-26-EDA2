# Producto de pares hasta n

## Análisis recursivo

| Tipo | Entrada (n) | Salida |
|------|-------------|--------|
| CB | 0 | 1 |
| CR n-1 | 4 | 8 |
| CR n | 6 | 48 |

**Observación en aspa:**
- Para n=6, necesito obtener 48
- Tengo disponible el 6 y el resultado de n-2 (4) que es 8
- 6 × 8 = 48

**Relación recursiva:** `productoPares(n) = n × productoPares(n-2)`

## Pseudocódigo

```
funcion productoPares(n)
    si n <= 0 entonces
        devolver 1
    sino
        devolver n * productoPares(n - 2)
    fin si
fin funcion
```
