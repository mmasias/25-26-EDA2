# VALIDAR SI UNA PALABRA ES PALÍNDROMO

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||cadena|f(cadena)|
|-|-|-|
CB|""|TRUE|
CB|"a"|TRUE|
CB|"aa"|TRUE|
...|||
n-1|"caac"|TRUE|
n|"dcaacd"|TRUE|

Si cola(n) != cabeza(n) & f(n-1) = TRUE => FALSE
f(n-1) = FALSE => FALSE
Si cola(n) == cabeza(n) & f(n-1) = TRUE => TRUE


</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION esPalindromo(n)

    SI esPalindromo(n-1) = FALSE ENTONCES
        DEVOLVER FALSE
    FIN SI

    SI cola(n) != cabeza(n) ENTONCES
        DEVOLVER FALSE
    FIN SI

    DEVOLVER TRUE

FIN FUNCION