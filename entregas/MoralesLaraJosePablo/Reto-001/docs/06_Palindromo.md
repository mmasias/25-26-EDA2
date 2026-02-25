# 2Think – Sección: Estructuración Recursiva

---

## 6. Validar si una palabra es un palíndromo

### Análisis Recursivo

- **Caso base:** Si la cadena tiene 0 o 1 caracteres, es palíndromo → retornar `verdadero`.
- **Caso recursivo:** Si el primer y último carácter son iguales, verificar el interior de la cadena. Si no son iguales, retornar `falso`.

```
esPalindromo("radar") → 'r' == 'r' → esPalindromo("ada")
esPalindromo("ada")   → 'a' == 'a' → esPalindromo("d")
esPalindromo("d")     → longitud 1  → verdadero
```

### Pseudocódigo

```
FUNCIÓN esPalindromo(cadena):
    SI longitud(cadena) <= 1:
        RETORNAR verdadero
    SI cadena[0] != cadena[último]:
        RETORNAR falso
    RETORNAR esPalindromo(cadena[1 : último-1])
```
