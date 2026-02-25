# 2Think – Sección: Estructuración Recursiva

---

## 8. En una lista, sumar elementos en posiciones pares

### Análisis Recursivo

Las posiciones pares son los índices 0, 2, 4, … (base 0).

- **Caso base:** Si la lista está vacía, retornar `0`.
- **Caso base 2:** Si la lista tiene un solo elemento, retornar ese elemento (índice 0 es par).
- **Caso recursivo:** Sumar `lista[0]` (posición par) y llamar recursivamente saltando dos posiciones.

```
sumarPares([10, 3, 20, 7, 30]) = 10 + sumarPares([20, 30])
                                = 10 + 20 + sumarPares([30])
                                = 10 + 20 + 30
                                = 60
```

### Pseudocódigo

```
FUNCIÓN sumarPares(lista):
    SI lista está vacía:
        RETORNAR 0
    SI longitud(lista) == 1:
        RETORNAR lista[0]
    RETORNAR lista[0] + sumarPares(lista[2:])
```
