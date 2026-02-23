### 5. En una palabra/frase, reemplazar una letra por otra

Dada una cadena `s`, reemplazar todas las apariciones de la letra `c1` por `c2`.

<details open>
<summary>Ver análisis recursivo</summary>

Asumiendo que queremos reemplazar "a" por "o" en "casa":

| | n | f(n) |
| :--- | :---: | :---: |
| CB | "" | "" |
| ... | | |
| CR n-1 | "asa" | "oso" = "o" + "so" |
| CR n | "casa" | "coso" = "c" + "oso" |

<br>
<center>"coso" = "c" + f(n-1)
</details>

### Pseudocódigo & código

<details open>
<summary>Ver pseudocódigo</summary>

```text
FUNCION reemplazarLetra(n, c1, c2)

    SI longitud(s) es 0 ENTONCES
        Devolver ""
    FIN SI
    
    SI s[0] es igual a c1 ENTONCES
        Devolver c2 + reemplazarLetra(restoDeCadena(n), c1, c2)
    SINO
        Devolver s[0] + reemplazarLetra(restoDeCadena(n), c1, c2)
    FIN SI
    
FIN FUNCIÓN
```
</details>