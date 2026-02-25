# 2Think – Sección: Estructuración Recursiva

---

## 5. Reemplazar una letra por otra en una palabra/frase

### Análisis Recursivo

- **Caso base:** Si la cadena está vacía, retornar `""`.
- **Caso recursivo:** Si el primer carácter es igual a la letra original, concatenar la letra nueva con el resultado sobre el resto. Si no, concatenar el primer carácter sin cambios.

```
reemplazar("casa", 'a', 'o') = "c" + reemplazar("asa", 'a', 'o')
                             = "c" + "o" + reemplazar("sa", 'a', 'o')
                             = "c" + "o" + "s" + reemplazar("a", 'a', 'o')
                             = "c" + "o" + "s" + "o"
                             = "coso"
```

### Pseudocódigo

```
FUNCIÓN reemplazar(cadena, original, nueva):
    SI cadena está vacía:
        RETORNAR ""
    SI cadena[0] == original:
        RETORNAR nueva + reemplazar(cadena[1:], original, nueva)
    RETORNAR cadena[0] + reemplazar(cadena[1:], original, nueva)
```
