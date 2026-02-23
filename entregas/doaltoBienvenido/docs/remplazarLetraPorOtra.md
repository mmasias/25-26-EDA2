# Reemplazar Letra por Otra

En una palabra/frase, reemplazar una letra por otra

---

| Caso   | n        |   f(n)    |
| ------ | -------- |-----------|
| CB     | "  "     |  " "      |
| ...    |          |           |
| CR n-1 | "pepe"   |  "papa"   |
| CR n   | "epepe"  |  "apapa"  |

Patrón de recursividad:

f(n) = cabeza(letra nueva) & f(n - 1) -> Siendo cabeza misma letra vieja

f(n) = cabeza & f(n - 1)

---

## Pseudocódigo

```
FUNCION reemplazarLetra(palabra, letraVieja, letraNueva)

    SI palabra es vacía ENTONCES
        Devolver " "
    FIN SI

    SI palabra[0] == letraVieja ENTONCES
        Resultado = letraNueva + reemplazarLetra(palabra[1...], letraVieja, letraNueva)
    SINO
        Resultado = palabra[0] + reemplazarLetra(palabra[1...], letraVieja, letraNueva)
    FIN SI

    Devolver Resultado

FIN FUNCIÓN
```