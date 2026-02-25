# 2Think – Sección: Estructuración Recursiva

---

## 2. Contar las cifras de un número

### Análisis Recursivo

- **Caso base:** Si `n < 10` (solo tiene un dígito), retornar `1`.
- **Caso recursivo:** Dividir `n` entre 10 (elimina el último dígito) y sumar `1`.

```
contarCifras(4523) = 1 + contarCifras(452)
                   = 1 + 1 + contarCifras(45)
                   = 1 + 1 + 1 + contarCifras(4)
                   = 1 + 1 + 1 + 1
                   = 4
```

### Pseudocódigo

```
FUNCIÓN contarCifras(n):
    SI n < 10:
        RETORNAR 1
    RETORNAR 1 + contarCifras(n / 10)  // división entera
```
