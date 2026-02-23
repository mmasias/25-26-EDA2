# Duplicar Elementos

En una lista, duplicar sus elementos (ej:([1,2,3] convertirla en [1,1,2,2,3,3]))
---

| Caso   | n    | f(n)   |
| ------ | ---- | ------ |
| CB     | ""   |   ""   |
| ...    |      |        |
| CR n-1 | 12   | 1122   |
| CR n   | 123  | 112233 |

| Caso   | n     | f(n)       |
| ------ | ----- | ---------- |
| CB     | "x"   |            |
| ...    |       |            |
| CR n-1 | 234   | 223344     |
| CR n   | 12345 | 1122334455 |

Patrón de recursividad:

f(n) = f(n - 1) & 2 veces la Cola
f(n) = 2 veces la Cabeza & f(n - 1) & 2 veces la Cola

---

## Pseudocódigo

```
FUNCION duplicarElementos(lista)

    SI lista es vacia ENTONCES
        Devolver " "
    FIN SI

    Elemento = lista[0]
    resto = duplicarelementos(lista[i...i-1])
    
    Devolver [Elemento, Elemento] + resto
FIN FUNCIÓN
```