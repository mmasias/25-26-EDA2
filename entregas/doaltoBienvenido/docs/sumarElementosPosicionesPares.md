# Sumar Elementos en Posiciones Pares

En una lista, sumar los elementos que se encuentran en posiciones pares (0, 2, 4, etc.).

---

| Caso   | n        | f(n)         |
| ------ | -------- | ------------ |
| CB     | " "      | 0            |
| ...    |          |              |
| CR n-1 | [1,2,3]  | 1 + 3 = 4    |
| CR n   | [1,2,3,4]| 1 + 3 = 4    |

Patrón de recursividad:

f(n) = lista[n] + sumarPares(n-2)

---

## Pseudocódigo

```
FUNCION sumarPares(lista)

    SI longitud(lista) < 2 ENTONCES

        Resultado = 0
    SINO

        Resultado = lista[1] + sumarPares(lista[2...longitud(lista)-2])
    FIN SI

    Devolver Resultado

FIN FUNCIÓN
```