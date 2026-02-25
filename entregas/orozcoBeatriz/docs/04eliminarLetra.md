# ELIMINAR TODAS LAS APARICIONES DE UNA LETRA

Eliminar todas las apariciones de una letra en una cadena.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|Caso|cadena|f(cadena)|
|---|---|---|
|CB|""|""|
|...|...|...|
|n-1|"abc"|"bc"|
|n|"abcd"|"bcd"|

Se procesa el primer carácter:
- si coincide → se ignora
- si no → se conserva

</div>

</details>

## Pseudocódigo

```text
FUNCION eliminarLetra(cadena, letra)

    SI cadena == "" ENTONCES
        DEVOLVER ""
    FIN SI

    primero = cadena[0]
    resto = subcadena desde posición 1

    SI primero == letra ENTONCES
        DEVOLVER eliminarLetra(resto, letra)
    SINO
        DEVOLVER primero + eliminarLetra(resto, letra)
    FIN SI

FIN FUNCION
```