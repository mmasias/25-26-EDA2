# REEMPLAZAR UNA LETRA POR OTRA

Reemplazar todas las apariciones de letraVieja por letraNueva.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|Caso|cadena|f(cadena)|
|---|---|---|
|CB|""|""|
|...|...|...|
|n-1|"casa"|"c*sa"|
|n|"casas"|"c*s*s"|

Se procesa el primer carácter:
- si es letraVieja → se pone letraNueva
- si no → se deja igual

</div>

</details>

## Pseudocódigo

```text
FUNCION reemplazarLetra(cadena, letraVieja, letraNueva)

    SI cadena == "" ENTONCES
        DEVOLVER ""
    FIN SI

    primero = cadena[0]
    resto = subcadena desde posición 1

    SI primero == letraVieja ENTONCES
        DEVOLVER letraNueva + reemplazarLetra(resto, letraVieja, letraNueva)
    SINO
        DEVOLVER primero + reemplazarLetra(resto, letraVieja, letraNueva)
    FIN SI

FIN FUNCION
```
