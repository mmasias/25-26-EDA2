# Validar si una palabra es un palíndromo

Verifica si una cadena de texto se lee igual de izquierda a derecha que de derecha a izquierda. La función recibe la cadena de entrada y devuelve un valor booleano (`Verdadero` o `Falso`).

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Caso               | (`s`, `inicio`, `fin`) | `f(s, inicio, fin)`                     |
| :----------------- | :--------------------- | :-------------------------------------- |
| **Base (CB)**      | ("radar", 2, 2)        | Verdadero                               |
| **Base (CB)**      | ("hola", 0, 3)         | Falso (porque 'h' $\neq$ 'a')           |
| **Recursivo (CR)** | ("radar", 1, 3)        | `f("radar", 2, 2)` (porque 'a' $=$ 'a') |
| **Recursivo (CR)** | ("radar", 0, 4)        | `f("radar", 1, 3)` (porque 'r' $=$ 'r') |

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION esPalindromo(s, inicio = 0, fin = -1)

    # Configuración inicial del puntero 'fin' en la primera llamada
    SI fin == -1 ENTONCES
        fin <- longitud de s - 1
    FIN SI

    # Caso Base 1: Hemos cruzado o alcanzado el centro sin encontrar diferencias
    SI inicio >= fin ENTON
```
