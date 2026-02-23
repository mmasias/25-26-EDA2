# contarCifrasNumero

Calcular la cantidad de cifras de un número entero positivo.

---

| Caso | n  | f(n) |
|------|----|------|
| CB   | " "| 0    |
| ...  |    |      |
| CR n-1 | 45 | 2  |
| CR n | 456 | 1 + contarCifras(45) = 3 |

Patrón de recursividad:

f(n) = f(n - 1) + 1

---

## Pseudocódigo

```
FUNCION contarCifras(n)

    SI n = 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver f(n - 1) + 1

FIN FUNCIÓN
```