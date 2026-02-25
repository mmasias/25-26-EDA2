# Contar las cifras de un número

## Análisis recursivo

| Tipo | Entrada (n) | Salida |
|------|-------------|--------|
| CB | 0 | 0 |
| CR n-1 | 123 | 3 |
| CR n | 1234 | 4 |

**Observación en aspa:**
- Para n=1234, necesito obtener 4 cifras
- Tengo disponible 1234 y el resultado de 123 que es 3
- 1 + 3 = 4

**Relación recursiva:** `contarCifras(n) = 1 + contarCifras(n / 10)`

## Pseudocódigo

```
funcion contarCifras(n)
    si n == 0 entonces
        devolver 0
    sino
        devolver 1 + contarCifras(n / 10)
    fin si
fin funcion
```
