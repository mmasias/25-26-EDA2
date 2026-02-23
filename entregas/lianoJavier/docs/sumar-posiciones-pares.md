# sumar posiciones pares


Sumar los elementos de una lista que se encuentran en posiciones pares (segunda, cuarta, sexta...).


<details>

<summary>Ver análisis recursivo</summary>


<div align=center>


|          |         lista | f(lista)                          |
| -------- | ------------: | --------------------------------- |
| CB       |        [a, b] | b                                 |
| ...      |           ... | ...                               |
| CR resto |     [3,4,5,6] | 10 (2ª pos=4, 4ª pos=6)           |
| CR n     | [1,2,3,4,5,6] | 12 (2ª pos=2, 4ª pos=4, 6ª pos=6) |



12 = 2 + 10 *o lo que es igual* **lista[n] + sumarPares(n-2)** (Siendo n par; en caso contrario se resta 1 antes de empezar a n. Siendo n el tamaño de la lista partiendo de 0.)


</div>


</details>


## Pseudocódigo


<details>

<summary>Ver pseudocódigo</summary>


```text

FUNCION sumarPares(lista)


    SI longitud(lista) < 2 ENTONCES

        Resultado = 0

    SINO

        Resultado = lista[1] + sumarPares(lista[2...longitud(lista)-2])

    FIN SI


    Devolver Resultado


FIN FUNCIÓN

```


</details>
