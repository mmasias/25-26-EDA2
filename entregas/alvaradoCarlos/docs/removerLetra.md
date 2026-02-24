# Remover apariciones de una letra

En una palabra/frase, eliminar todas las apariciones de una letra

## Análisis Recursivo

<details>
<summary>Ver análisis</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|"", a|""
...
...
...
n-1|Ama|m
n|Cama|Cm
...
...
n-1|mar|mr
n|Amar|mr

El patrón aqui se compone principalmente de que si la cadena que se ingresa, tiene la letra a remover en la cabeza, *f(n)* será igual. Mientras que si la cadena ingresada no tiene la letra en la cabeza el razonamiento pasa a ser: **cabeza + f(n-1)**

[Imágen de Análisis](/entregas/alvaradoCarlos/images/removerLetra.jpeg)

</div>

</details>

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION removerLetra(n, letra)

    SI n == "" ENTONCES
        Devolver ""
    FIN SI

    SI n[0] == letra ENTONCES
        Devolver removerLetra(n[1...], letra)
    SI NO 
        Devolver n[0] + removerLetra(n[1...], letra)
    FIN SI

FIN FUNCIÓN
```

</details>