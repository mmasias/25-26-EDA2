# Suma Pares n

Calcular el producto de todos los números pares positivos hasta n.

## Analisis recursivo

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|0
...
...
...
CR n-1|4|6
CR n|5|6


f(5) = 6 = 5*(int)((5+1)%2) + f(n-1) *o lo que es igual* *sumar numeros **pares***

</div>

## Pseudocódigo


```text
FUNCION sumapares(n)

    SI n es 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver n*(int)((n+1)%2) + sumapares(n - 1)

FIN FUNCIÓN
```

