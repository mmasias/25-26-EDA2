# Palíndromo

Validar si una palabra es un palíndromo

## Análisis Recursivo

<details>
<summary>Ver análisis</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|""|TRUE
CB|"A"|TRUE
...
...
n-1|"BCCB"|TRUE
n|"ABCCBA"|TRUE
...
...
n-1|"ALA"|TRUE
n|"SALAS"|TRUE

Será palíndroma, siempre y cuando al reducir un grado (en el inicio y en el final) el centro sea palíndromo igualmente. Se representa de la siguiente forma: **f(n) = (cabeza == cola) Y f(centro)**

[Imágen de Análisis](/entregas/alvaradoCarlos/images/palindromas.jpeg)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION esPalindromo(n)

    SI n.length() <= 1 ENTONCES
        Devolver TRUE
    FIN SI

    SI n[primera] == n[ultima] ENTONCES
        //Si los extremos son iguales, revisamos el centro
        Devolver esPalindromo( centro de n )
    SI NO
        Devolver FALSE
    FIN SI

FIN FUNCIÓN
```

</details>
