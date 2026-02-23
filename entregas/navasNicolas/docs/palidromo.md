# Validar si una palabra es un palíndromo

Verifica si una cadena de texto se lee igual de izquierda a derecha que de derecha a izquierda. La función recibe la cadena de entrada y devuelve un valor booleano (`Verdadero` o `Falso`).

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||entrada (s)|f(s)|
|-|-:|-|
CB|""|Verdadero   # cadena vacía es palíndromo
CB|"a"|Verdadero   # un único carácter es palíndromo
CR extremos iguales|"a...a"|f("...")   # quitar primer y último carácter y evaluar resto
CR extremos distintos|"a...b"|Falso   # al no coincidir, se rompe el palíndromo

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION esPalindromo(s)

    SI longitud de s <= 1 ENTONCES
        Devolver VERDADERO
    FIN SI

    primer <- primer carácter de s
    ultimo <- último carácter de s
    resto  <- s sin el primer y último carácter

    SI primer == ultimo ENTONCES
        Devolver esPalindromo(resto)
    SINO
        Devolver FALSO
    FIN SI

FIN FUNCIÓN