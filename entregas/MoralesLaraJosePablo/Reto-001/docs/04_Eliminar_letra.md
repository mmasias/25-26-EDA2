# 2Think – Sección: Estructuración Recursiva

---

## 4. Eliminar todas las apariciones de una letra en una palabra/frase

### Análisis Recursivo

- **Caso base:** Si la cadena está vacía, retornar `""`.
- **Caso recursivo:** Si el primer carácter es igual a la letra a eliminar, retornar el resultado sobre el resto. Si no, concatenar el primer carácter con el resultado sobre el resto.

```
eliminar("banana", 'a') = "" + eliminar("anana", 'a')
                        = "" + "" + eliminar("nana", 'a')
                        = "" + "" + "n" + eliminar("ana", 'a')
                        = ... = "bnn"
```

### Pseudocódigo

```
FUNCIÓN eliminar(cadena, letra):
    SI cadena está vacía:
        RETORNAR ""
    SI cadena[0] == letra:
        RETORNAR eliminar(cadena[1:], letra)
    RETORNAR cadena[0] + eliminar(cadena[1:], letra)
```
