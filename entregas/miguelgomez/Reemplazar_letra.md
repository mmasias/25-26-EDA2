# sustituirCaracter

Intercambiar una letra determinada por una nueva dentro de un texto.

## Análisis recursivo

<div align=center>

| Tipo    | palabra | f(n, 'c', 'k') |
|---------|---------|----------------|
| CB       | ""      | ""             |
| ...      | ...     | ...            |
| CR n-1   | "coco"  | "koko"         |
| CR n     | "acoco" | "akoko"        |

"akoko" surge de unir 'a' con el resultado de "koko".

Lógica recursiva:
- Si el inicio es la letra a cambiar → **nuevaLetra + f(resto)**
- Si el inicio es diferente → **inicio + f(resto)**

</div>

## Pseudocódigo

```text
FUNCION reemplazarLetra(texto, vieja, nueva)

    SI texto está vacío ENTONCES
        Resultado = ""
    SINO
        inicial = texto[0]
        cola = texto[1...]

        SI inicial == vieja ENTONCES
            Resultado = nueva + reemplazarLetra(cola, vieja, nueva)
        SINO
            Resultado = inicial + reemplazarLetra(cola, vieja, nueva)
        FIN SI
    FIN SI

    Devolver Resultado

FIN FUNCIÓN