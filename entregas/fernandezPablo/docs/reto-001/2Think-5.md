## 5. En una palabra/frase, reemplazar una letra por otra

<details>
<summary>Ver análisis recursivo</summary>

| | palabra (p) | f(p, 'a', 'x') |
| :--- | :--- | :--- |
| **CB** | "" | "" |
| ... | | |
| **CR n-1**| "la" | "lx" |
| **CR n** | "ala" | "xlx" |

`"xlx" = "x" + f(p[1:]) o lo que es igual letraNueva + reemplazarLetra(p[1:], letraVieja, letraNueva)`

</details>

### 🔗 Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION reemplazarLetra(palabra, letraVieja, letraNueva)
    SI longitud(palabra) == 0 ENTONCES
        Devolver ""
    FIN SI
    
    SI palabra[0] == letraVieja ENTONCES
        Devolver letraNueva + reemplazarLetra(palabra[1:], letraVieja, letraNueva)
    SINO
        Devolver palabra[0] + reemplazarLetra(palabra[1:], letraVieja, letraNueva)
    FIN SI
FIN FUNCION