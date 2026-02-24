### 5. En una palabra/frase, reemplazar una letra por otra


<details open>
<summary>Ver análisis recursivo</summary>

Asumiendo que queremos reemplazar "a" por "o" en "casa":

| | n | f(n,"a","o") |
| :--- | :---: | :---: |
| CB | "" | "" |
| ... | | |
| CR n-1 | "asa" | "oso" |
| CR n | "casa" | "coso" |

<br>
<center>"coso" = "cabeza" + f(n-1)
</details>

### Pseudocódigo

<details open>
<summary>Ver pseudocódigo</summary>

```text
FUNCION reemplazarLetra(resto, letraVieja, letraNueva)

    SI es vacía ENTONCES
        Devolver ""
    FIN SI
    
    SI cabeza es igual a letraVieja ENTONCES
        Devolver letraNueva + reemplazarLetra(resto, letraVieja, letraNueva)
    SINO
        Devolver cabeza + reemplazarLetra(resto, letraVieja, letraNueva)
    FIN SI
    
FIN FUNCIÓN
```
</details>