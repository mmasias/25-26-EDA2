# 2Think – Sección: Estructuración Recursiva

---

## 3. Elevar n al cuadrado

### Análisis Recursivo

Basado en la identidad: `n² = (n-1)² + (2n - 1)`

- **Caso base:** Si `n == 0`, retornar `0`.
- **Caso recursivo:** Retornar `cuadrado(n - 1) + 2*n - 1`.

```
cuadrado(4) = cuadrado(3) + 7
            = cuadrado(2) + 5 + 7
            = cuadrado(1) + 3 + 5 + 7
            = cuadrado(0) + 1 + 3 + 5 + 7
            = 0 + 1 + 3 + 5 + 7
            = 16
```

### Pseudocódigo

```
FUNCIÓN cuadrado(n):
    SI n == 0:
        RETORNAR 0
    RETORNAR cuadrado(n - 1) + (2 * n - 1)
```
