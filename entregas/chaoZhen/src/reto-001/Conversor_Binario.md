### 9. Conversor a binario

Convertir un número entero positivo decimal a su representación binaria en formato de cadena de texto.

<details open>
<summary>Ver análisis recursivo</summary>

Asumiendo `n = 6` (cuyo binario es "110"):

| | n | f(n) |
| :--- | :---: | :---: |
| CB | 1 | "1" |
| ... | | |
| CR n-1 | 3 | "11" = "1" + "1" |
| CR n | 6 | "110" = "11" + "0" |

<br>
<center>"110" = f(n/2) + "0" <i>o lo que es igual</i> <b>binario(n / 2) + cadena(n%2)</b></center>
</details>

### Pseudocódigo

<details open>
<summary>Ver pseudocódigo</summary>

```text
FUNCION binario(n)

    SI n es 0 ENTONCES
        Devolver "0"
    FIN SI
    
    SI n es 1 ENTONCES
        Devolver "1"
    FIN SI
    
    Devolver binario(n / 2) + convertirACadena(n%2)
    
FIN FUNCIÓN
```
</details>