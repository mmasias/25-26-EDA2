# sumar posiciones pares


Sumar los elementos de una lista que se encuentran en posiciones pares (segunda, cuarta, sexta...).


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|          |         lista | f(lista)                          |
| -------- | ------------: | --------------------------------- |
| CB       |        [a, b] | b                                 |
| ...      |           ... | ...                               |
| CR n-1 |     [3,4,5,6] | 8           |
| CR n     | [1,2,3,4,5,6] | 9 |



Leemos la posición en el indice 0 y se la sumamos a f(n-1).

n-1 es n quitandole dos veces la cabeza.


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION sumarPares(lista)


    SI longitud(lista) < 1 ENTONCES

        Resultado = lista[0];

    SINO

        Resultado = lista[0] + sumarPares(lista[2...longitud(lista)])

    FIN SI


    Devolver Resultado


FIN FUNCIÓN

```


</details>
