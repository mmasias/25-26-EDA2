
# Conversor Binario

Calcular la representación binaria de un número entero positivo.

---

| Caso | n   | f(n)                         |
| ---- | --- | ---------------------------- |
| CB   | 0   | "0"                          |
| CB   | 1   | "1"                          |
| ...  |     |                              |
| CR n | 9   | f(9 / 2) & (9 % 2) = 1001    |
| CR n | 18  | f(18 / 2) & (18 % 2) = 10010 |

Patrón de recursividad:

f(n) = f(n / 2) & (n % 2)


## Pseudocódigo

```
FUNCION binario(n)

    SI n < 2 ENTONCES
        Devolver n
    FIN SI

    Devolver binario(n / 2) CONCAT (n % 2)

FIN FUNCIÓN
```

