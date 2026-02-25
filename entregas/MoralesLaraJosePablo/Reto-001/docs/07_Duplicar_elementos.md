# 2Think – Sección: Estructuración Recursiva

---

## 7. En una lista, duplicar sus elementos ([1,2,3] → [1,1,2,2,3,3])

### Análisis Recursivo

- **Caso base:** Si la lista está vacía, retornar `[]`.
- **Caso recursivo:** Tomar el primer elemento, repetirlo dos veces, y concatenar con el resultado sobre el resto de la lista.

```
duplicar([1, 2, 3]) = [1, 1] + duplicar([2, 3])
                    = [1, 1] + [2, 2] + duplicar([3])
                    = [1, 1] + [2, 2] + [3, 3] + duplicar([])
                    = [1, 1, 2, 2, 3, 3]
```

### Pseudocódigo

```
FUNCIÓN duplicar(lista):
    SI lista está vacía:
        RETORNAR []
    RETORNAR [lista[0], lista[0]] + duplicar(lista[1:])
```
