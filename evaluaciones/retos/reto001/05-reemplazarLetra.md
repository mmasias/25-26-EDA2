# En una palabra/frase, reemplazar una letra por otra

## Análisis recursivo

| Tipo | Entrada (texto, vieja, nueva) | Salida |
|------|-------------------------------|--------|
| CB | "", 'a', 'o' | "" |
| CR n-1 | "cas", 'a', 'o' | "cos" |
| CR n | "casa", 'a', 'o' | "cosa" |

**Observación en aspa:**
- Si el primer carácter es la letra a reemplazar, uso la letra nueva
- Si no, mantengo el carácter original

**Relación recursiva:**
```
si texto[0] == vieja: nueva + reemplazar(texto[1:], vieja, nueva)
sino: texto[0] + reemplazar(texto[1:], vieja, nueva)
```

## Pseudocódigo

```
funcion reemplazarLetra(texto, vieja, nueva)
    si texto == "" entonces
        devolver ""
    sino
        si texto[0] == vieja entonces
            devolver nueva + reemplazarLetra(texto[1:], vieja, nueva)
        sino
            devolver texto[0] + reemplazarLetra(texto[1:], vieja, nueva)
        fin si
    fin si
fin funcion
```
