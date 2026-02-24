### 6. Validar si una palabra es un palíndromo

<details open>
<summary>Ver análisis recursivo</summary>

Asumiendo la palabra "radar":

| | n| f(n) |
| :--- | :---: | :---: |
| CB | "d" | Verdadero |
| ... | | |
| CR n-1 | "ada" | Verdadero = ('a'=='a' y Verdadero) |
| CR n | "radar" | Verdadero = ('r'=='r' y Verdadero) |

<br>
<center>Verdadero = ('r'=='r') y f(n-1) <i>o lo que es igual</i> <b>(cabeza == cola) Y esPalindromo(f[n-1])</b></center>
</details>

### Pseudocódigo

<details open>
<summary>Ver pseudocódigo</summary>

```text
FUNCION esPalindromo(n)

    SI esta vacío || palabra <= 1 ENTONCES
        Devolver Verdadero
    FIN SI
    
    cabeza = palabra[0]
    cola   = palabra[longitud(palabra) - 1]
    
    SI cabeza == cola ENTONCES
        centro = subcadena(palabra, primer_indice)
        Devolver esPalindromo(centro)
    SINO
        Devolver Falso
    FIN SI
    
FIN FUNCIÓN
```
</details>