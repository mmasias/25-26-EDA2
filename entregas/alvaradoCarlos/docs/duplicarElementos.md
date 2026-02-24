# Duplicar elementos de una lista

En una lista, duplicar sus elementos hasta n

## Análisis Recursivo

<details>
<summary>Ver análisis</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|""|""
...
...
n-1|"1"|"1, 1"
n|"1, 2"|"1, 1, 2, 2"
...
...
n-1|"1, 2"|"1, 1, 2, 2"
n|"1, 2, 3"|"1, 1, 2, 2, 3, 3"

En esta se debe ver como la cola de cada nueva *n* es lo que le falta a la *f(n-1)* pero 2 veces. Por lo que se podría decir: **f(n-1) + cola, cola** o si se hace de forma inversa también es válido: **cabeza, cabeza + f(n-1)**

[Imágen de Análisis](/entregas/alvaradoCarlos/images/duplicarElementos.jpeg)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION duplicarElementos(n)

    SI n == "" ENTONCES
        Devolver ""
    FIN SI

    ultimoElemento = n[n.length - 1]
    restoDeLista = n[desde el inicio hasta el penúltimo]
    
    Devolver duplicarElementos(restoDeLista) + ultimoElemento + ultimoElemento

FIN FUNCIÓN
```

</details>
