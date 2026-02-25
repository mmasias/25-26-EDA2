# En una palabra/frase, eliminar todas las apariciones de una letra

## Análisis recursivo

| Tipo | Entrada (texto, letra) | Salida |
|------|------------------------|--------|
| CB | "", 'a' | "" |
| CR n-1 | "hol", 'a' | "hol" |
| CR n | "hola", 'a' | "hol" |
| CR n-1 | "cas", 'a' | "cs" |
| CR n | "casa", 'a' | "cs" |

**Observación en aspa:**
- Si el primer carácter es la letra a eliminar, no lo incluyo
- Si no es la letra, lo incluyo en el resultado

**Relación recursiva:** 
```
si texto[0] == letra: eliminar(texto[1:], letra)
sino: texto[0] + eliminar(texto[1:], letra)
```

## Pseudocódigo

```
funcion eliminarLetra(texto, letra)
    si texto == "" entonces
        devolver ""
    sino
        si texto[0] == letra entonces
            devolver eliminarLetra(texto[1:], letra)
        sino
            devolver texto[0] + eliminarLetra(texto[1:], letra)
        fin si
    fin si
fin funcion
```
