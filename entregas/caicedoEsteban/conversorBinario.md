# Conversor a binario

Convierte un número entero positivo de base 10 a su representación binaria (cadena).

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

| Caso               | (n, acc)    | f(n, acc)   |
| :----------------- | :---------- | :---------- |
| **Base especial**  | (0, "")     | "0"         |
| **Base (CB)**      | (0, "1010") | "1010"      |
| **Recursivo (CR)** | (10, "")    | $f(5, "0")$ |

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION convertirABinario(n, acc = "")

    # Caso especial para el cero puro en la llamada inicial
    SI n == 0 Y acc == "" ENTONCES
        DEVOLVER "0"
    FIN SI

    # Caso base real para detener la recursión
    SI n == 0 ENTONCES
        DEVOLVER acc
    FIN SI

    # Llamada recursiva de cola sin operaciones pendientes.
    # El nuevo bit (0 o 1) se concatena a la IZQUIERDA del acumulador.
    DEVOLVER convertirABinario(n DIV 2, convertirATexto(n MOD 2) + acc)

FIN FUNCIÓN
```

</details>
