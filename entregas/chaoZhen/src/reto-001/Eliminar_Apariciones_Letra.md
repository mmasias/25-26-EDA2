# Reemplazar una letra

En una palabra o frase, reemplazar una letra por otra.

## Análisis recursivo

<div align=center>

| Tipo    | palabra | f(n, 'a', 'e') |
|---------|---------|----------------|
| **CB** | ""      | ""             |
| ...     | ...     | ...            |
| **CR n-1** | "asa"   | "ese"          |
| **CR n** | "casa"  | "cese"         |

<br>

"cese" = 'c' + f("asa") → 'c' + "ese"

**Patrón de recursividad:**

- Si la Cabeza == letraVieja → **letraNueva + f(n-1)**
- Si la Cabeza != letraVieja → **Cabeza + f(n-1)**

</div>



## Pseudocódigo

<details open>
<summary>Ver pseudocódigo</summary>

```text
FUNCION reemplazarUnaLetra(palabra, letraVieja, letraNueva)

    SI palabra es vacía ENTONCES
        Resultado = ""
    SINO
        cabeza = palabra[0]
        resto  = palabra[1...]

        SI cabeza == letraVieja ENTONCES
            Resultado = letraNueva + reemplazarUnaLetra(resto, letraVieja, letraNueva)
        SINO
            Resultado = cabeza + reemplazarUnaLetra(resto, letraVieja, letraNueva)
        FIN SI
    FIN SI

    Devolver Resultado

FIN FUNCIÓN