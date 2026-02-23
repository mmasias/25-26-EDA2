# contarCifrasNumero

Calcular la cantidad de cifras de un número entero positivo.

---

| Caso   | n   | f(n)           |
| ------ | --- | -------------- |
| CB     | " " | 0              |
| ...    |     |                |
| CR n-1 | 45  | 2              |
| CR n   | 456 | f(n-1) + 1 = 3 |

Patrón de recursividad:

f(n) = f(n - 1) + 1

---

## Pseudocódigo

```
FUNCION contarCifras(cifras)

    SI cifras = 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver f(cifras - 1) + 1

FIN FUNCIÓN
```