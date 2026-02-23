### 4. En una palabra/frase, eliminar todas las apariciones de una letra

Dada una cadena `s` y una letra `c`, devolver una nueva cadena sin las apariciones de `c`.

<details open>
<summary>Ver análisis recursivo</summary>

Asumiendo que queremos eliminar la letra "o" de "hola":

| | n | f(n) |
| :--- | :---: | :---: |
| CB | "" | "" |
| ... | | |
| CR n-1 | "ola" | "la" (se omite la 'o') |
| CR n | "hola" | "hla" = "h" + "la" |

<br>
<center>"hla" = "h" + f(n-1) <i>o lo que es igual</i> <b>n[0] + eliminarLetra(n-1, c)</b></center>
</details>

### Pseudocódigo & código

<details open>
<summary>Ver pseudocódigo</summary>

```text
FUNCION eliminarLetra(n, c)

    SI longitud(n) es 0 ENTONCES
        Devolver ""
    FIN SI
    
    SI s[0] es igual a c ENTONCES
        Devolver eliminarLetra(restoDeCadena(s), c)
    SINO
        Devolver n[0] + eliminarLetra(restoDeCadena(s), c)
    FIN SI
    
FIN FUNCIÓN
```
</details>
