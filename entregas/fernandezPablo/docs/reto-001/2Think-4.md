## 4. En una palabra/frase, eliminar todas las apariciones de una letra

<details>
<summary>Ver análisis recursivo</summary>

| | palabra (p) | f(p, 'a') |
| :--- | :--- | :--- |
| **CB** | "" | "" |
| ... | | |
| **CR n-1**| "la" | "l" |
| **CR n** | "ala" | "l" |

`"l" = f(p sin la 1º letra) o lo que es igual eliminarLetra(p[1:], letra)`

</details>

### 🔗 Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION eliminarLetra(palabra, letra)
    SI longitud(palabra) == 0 ENTONCES
        Devolver ""
    FIN SI
    
    SI palabra[0] == letra ENTONCES
        Devolver eliminarLetra(palabra[1:], letra)
    SINO
        Devolver palabra[0] + eliminarLetra(palabra[1:], letra)
    FIN SI
FIN FUNCION