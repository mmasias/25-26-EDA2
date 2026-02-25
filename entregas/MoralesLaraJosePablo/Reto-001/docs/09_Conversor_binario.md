# 2Think – Sección: Estructuración Recursiva

---

## 9. Conversor a binario

### Análisis Recursivo

- **Caso base:** Si `n == 0`, retornar `"0"`. Si `n == 1`, retornar `"1"`.
- **Caso recursivo:** Llamar recursivamente con `n / 2` (división entera) y concatenar el resto `n % 2` al final.

```
toBinario(13) = toBinario(6) + "1"
              = toBinario(3) + "0" + "1"
              = toBinario(1) + "1" + "0" + "1"
              = "1" + "1" + "0" + "1"
              = "1101"
```

### Pseudocódigo

```
FUNCIÓN toBinario(n):
    SI n == 0:
        RETORNAR "0"
    SI n == 1:
        RETORNAR "1"
    RETORNAR toBinario(n / 2) + CONVERTIR_A_TEXTO(n % 2)
```

---
