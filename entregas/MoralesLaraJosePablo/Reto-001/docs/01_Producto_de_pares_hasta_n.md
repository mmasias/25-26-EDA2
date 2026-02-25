# 2Think – Sección: Estructuración Recursiva

---

## 1. Producto de pares hasta n

### Análisis Recursivo

- **Caso base:** Si `n < 2`, el producto es `1` (no hay pares).
- **Caso recursivo:** Si `n` es par, multiplicar `n` por el resultado de llamar la función con `n - 2`. Si `n` es impar, llamar directamente con `n - 1`.

```
productoPares(6) = 6 * productoPares(4)
                 = 6 * 4 * productoPares(2)
                 = 6 * 4 * 2 * productoPares(0)
                 = 6 * 4 * 2 * 1
                 = 48
```

### Pseudocódigo

```
FUNCIÓN productoPares(n):
    SI n < 2:
        RETORNAR 1
    SI n es impar:
        RETORNAR productoPares(n - 1)
    RETORNAR n * productoPares(n - 2)
```
