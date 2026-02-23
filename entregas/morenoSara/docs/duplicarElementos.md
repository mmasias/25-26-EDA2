# DUPLICAR ELEMENTOS

En una lista, duplicar sus elementos ([1,2,3] convertirla en [1,1,2,2,3,3]).

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|0|0
...
n-1|1,2|1,1,2,2
n|1,2,3|1,1,2,2,3,3

cabeza(n) & cabeza(n) & f(n-1) 

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION duplicarElementos(n)

    SI n es 0 ENTONCES
        Devolver "0"
    FIN SI

    Devolver cabeza(n) + ", " + cabeza(n) + ", " + f(n-1)

FIN FUNCIÓN
```

</details>
