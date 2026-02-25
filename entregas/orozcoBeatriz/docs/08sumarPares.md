# SUMAR ELEMENTOS EN POSICIONES PARES

Suma posiciones 0,2,4,...

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

|Caso|lista, i|f(lista,i)|
|---|---|---:|
|CB|[], i|0|
|...|...|...|
|n-1|[2,3],0|2|
|n|[2,3,4],0|6|

Si i es par → primero + f(resto, i+1)  
Si i es impar → f(resto, i+1)

</div>

</details>

## Pseudocódigo

```text
FUNCION sumaPosicionesPares(lista, i)

    SI lista ESTA VACIA ENTONCES
        DEVOLVER 0
    FIN SI

    primero = lista[0]
    resto = sublista desde posición 1

    SI esPar(i) ENTONCES
        DEVOLVER primero + sumaPosicionesPares(resto, i + 1)
    SINO
        DEVOLVER sumaPosicionesPares(resto, i + 1)
    FIN SI

FIN FUNCION
```
