# Validar si una palabra es un palíndromo

Determinar si una palabra es un palíndromo (se lee igual de izquierda a derecha que de derecha a izquierda).

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

Ejemplo: "reconocer"

|        | cadena        | f(cadena) |
| ------ | ------------- | --------- |
| CB     | "" o 1 letra  | VERDADERO |
| ...    | ...           | ...       |
| CR     | "econoce"     | VERDADERO |
| CR     | "reconocer"   | VERDADERO |

Si la primera y última letra son iguales ⇒  
resultado = esPalindromo(subcadena sin primera y última)

Si son distintas ⇒  
resultado = FALSO

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION esPalindromo(cadena)

    SI longitud(cadena) <= 1 ENTONCES
        Resultado = VERDADERO
    SINO
        primera = cadena[0]
        ultima = cadena[longitud(cadena) - 1]
        sub = subcadena desde 1 hasta longitud - 2

        SI primera != ultima ENTONCES
            Resultado = FALSO
        SINO
            Resultado = esPalindromo(sub)
        FIN SI
    FIN SI

    DEVOLVER Resultado

FIN FUNCION
```

</details>