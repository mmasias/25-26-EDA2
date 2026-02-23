### 6. Validar si una palabra es un palíndromo

Verificar si una cadena `s` se lee igual de izquierda a derecha que de derecha a izquierda.

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
<center>Verdadero = ('r'=='r') y f(n-1) <i>o lo que es igual</i> <b>(s[0] == s[ultimo]) Y esPalindromo(s[n-1])</b></center>
</details>

### Pseudocódigo & código

<details open>
<summary>Ver pseudocódigo</summary>

```text
FUNCION esPalindromo(n)

    SI longitud(n) <= 1 ENTONCES
        Devolver Verdadero
    FIN SI
    
    SI s[0] es igual a s[longitud(n) - 1] ENTONCES
        Devolver esPalindromo(subcadena(s, 1, longitud(s) - 2)) 
    SINO
        Devolver FalsoValidar su una palabra es un palíndromo
    FIN SI
    
FIN FUNCIÓN
```
</details>