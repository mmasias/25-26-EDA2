# Validar si una palabra es un palíndromo

## Análisis recursivo

| Tipo | Entrada | Salida |
|------|---------|--------|
| CB | "" | true |
| CB | "a" | true |
| CR n-1 | "ana" | true |
| CR n | "anana" | true |
| CR n-1 | "oro" | true |
| CR n | "toro" | false |

**Observación en aspa:**
- Comparo el primer y último carácter
- Si son iguales, verifico el substring interno
- Si son diferentes, no es palíndromo

**Relación recursiva:**
```
si texto[0] == texto[n-1]: palindromo(texto[1:n-1])
sino: false
```

## Pseudocódigo

```
funcion esPalindromo(texto)
    si longitud(texto) <= 1 entonces
        devolver true
    sino
        si texto[0] == texto[longitud(texto) - 1] entonces
            devolver esPalindromo(texto[1:longitud(texto) - 1])
        sino
            devolver false
        fin si
    fin si
fin funcion
```
