## 6. Validar si una palabra es un palíndromo

<details>
<summary>Ver análisis recursivo</summary>

| | palabra (p) | f(p) |
| :--- | :--- | :--- |
| **CB** | "" o "s" | Verdadero |
| ... | | |
| **CR n-2**| "s" | Verdadero |
| **CR n** | "oso" | Verdadero |

`Verdadero = (p[0] == p[ultimo]) Y f(p[1:-1])`

</details>

### 🔗 Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION esPalindromo(palabra)
    SI longitud(palabra) <= 1 ENTONCES
        Devolver Verdadero
    FIN SI
    
    SI palabra[0] == palabra[ultimo] ENTONCES
        Devolver esPalindromo(palabra[1:-1])
    SINO
        Devolver Falso
    FIN SI
FIN FUNCION