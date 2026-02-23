# Pares Hasta N

En una lista, sumar elementos en posiciones pares.

---

| Caso   | n   | f(n)           |
| ------ | --- | -------------- |
| CB     | 0   | 0              |
| ...    |     |                |
| CR n-1 | 4   | 2 + 4 = 6      |
| CR n   | 6   | f(4) + 6 = 12  |

Patrón de recursividad:

f(n) = f(n - 2) + n (si n es par)

---

## Pseudocódigo

```
FUNCION sumarPares(n)

    SI n < 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver sumarPares(n - 2) + n

FIN FUNCIÓN
```