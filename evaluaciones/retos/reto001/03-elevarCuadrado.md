# Elevar n al cuadrado

## Análisis recursivo

| Tipo | Entrada (n) | Salida |
|------|-------------|--------|
| CB | 0 | 0 |
| CR n-1 | 4 | 16 |
| CR n | 5 | 25 |

**Observación en aspa:**
- Para n=5, necesito obtener 25
- Tengo disponible el 5 y el resultado de 4 que es 16
- 16 + 5 + 4 = 25 → También: 16 + 2×4 + 1 = 25

**Relación recursiva:** `cuadrado(n) = cuadrado(n-1) + 2(n-1) + 1`

Simplificando: `cuadrado(n) = cuadrado(n-1) + 2n - 1`

## Pseudocódigo

```
funcion cuadrado(n)
    si n == 0 entonces
        devolver 0
    sino
        devolver cuadrado(n - 1) + 2 * n - 1
    fin si
fin funcion
```
