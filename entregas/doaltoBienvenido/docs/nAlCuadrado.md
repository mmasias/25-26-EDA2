# n al Cuadrado

Calcular el cuadrado de un número entero positivo recursivamente.

---

| Caso   | n   | f(n)                  |
| ------ | --- | ----------------------|
| CB     | 0   | 0                     |
| ...    |     |                       |
| CR n-1 | 4   | 16                    |
| CR n   | 5   | f(4) + 2*5 - 1 = 25   |

Patrón de recursividad:

f(n) = f(n - 1) + 2*n - 1

---

## Pseudocódigo

```
FUNCION nAlCuadrado(n)

    SI n = 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver nAlCuadrado(n - 1) + 2*n - 1

FIN FUNCIÓN
```