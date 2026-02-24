# Validar su una palabra es un palíndromo


Validar si una palabra es un palíndromo (se lee igual de izquierda a derecha que de derecha a izquierda).

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|"" o "a"|Verdadero
...|...|...
n-1|"ada"|Verdadero
n|"radar"|Verdadero

</div>


- Si Cabeza == Cola --> f(n-1) *(centro de la cadena)*
- Si Cabeza != Cola --> Falso


</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION esPalindromo(cadena)

    SI longitud(cadena) <= 1 ENTONCES
        Devolver Verdadero
    FIN SI

    cabeza = primer carácter de cadena
    cola = último carácter de cadena
    centro = subcadena sin el primer ni el último carácter

    SI cabeza es igual a cola ENTONCES
        Devolver esPalindromo(centro)
    SI NO
        Devolver Falso
    FIN SI

FIN FUNCIÓN
```

</details>