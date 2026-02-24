## 1. Producto de pares hasta n
Calcular el producto de todos los números pares desde 2 hasta un número $n$.

**▼ Análisis recursivo**

| | n | f(n) |
| :--- | :--- | :--- |
| CB | 1 | 1 |
| ... | | |
| n-1 | 3 | 2 |
| n | 4 | 8 |
| ... | | |
| n-1 | 5 | 8 |
| n | 6 | 48 |

* `n` es impar ==> `f(n-1)`
* `n` es par ==> `n * f(n-1)`

**▼ Pseudocódigo**
```text
FUNCION productoParesHastaN(n)

    SI n <= 1 ENTONCES
        Devolver 1
    FIN SI

    SI n módulo 2 no es 0 ENTONCES
        Devolver productoParesHastaN(n - 1)
    SI NO
        Devolver n * productoParesHastaN(n - 1)
    FIN SI

FIN FUNCIÓN
```

---

## 2. Contar las cifras de un número
Contar la cantidad de dígitos que tiene un número entero positivo.

**▼ Análisis recursivo**

| | n | f(n) |
| :--- | :--- | :--- |
| CB | 5 | 1 |
| ... | | |
| n-1 | 12 | 2 |
| n | 123 | 3 |
| ... | | |
| n-1 | 405 | 3 |
| n | 4059 | 4 |

* `n < 10` ==> `1`
* `n >= 10` ==> `1 + f(n / 10)`  // división entera

**▼ Pseudocódigo**
```text
FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        Devolver 1
    FIN SI

    entero_sin_ultimo_digito = n dividido entre 10 
    Devolver 1 + contarCifras(entero_sin_ultimo_digito)

FIN FUNCIÓN
```

---

## 3. Elevar n al cuadrado
Calcular $n^2$ utilizando la propiedad matemática recursiva: $n^2 = (n-1)^2 + 2n - 1$.

**▼ Análisis recursivo**

| | n | f(n) |
| :--- | :--- | :--- |
| CB | 0 | 0 |
| ... | | |
| n-1 | 2 | 4 |
| n | 3 | 9 |
| ... | | |
| n-1 | 4 | 16 |
| n | 5 | 25 |

* `n > 0` ==> `f(n-1) + 2*n - 1`

**▼ Pseudocódigo**
```text
FUNCION elevarAlCuadrado(n)

    SI n == 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver elevarAlCuadrado(n - 1) + (2 * n) - 1

FIN FUNCIÓN
```

---

## 4. Eliminar todas las apariciones de una letra
En una palabra o frase, eliminar todas las apariciones de una letra específica.

**▼ Análisis recursivo**

| | n | f(n) |
| :--- | :--- | :--- |
| CB | "", "a" | "" |
| ... | | |
| n-1 | "na", "a" | "n" |
| n | "ana", "a" | "n" |
| ... | | |
| n-1 | "elota", "e" | "lota" |
| n | "pelota", "e" | "plota" |

* `cabeza == letra` ==> `f(resto)`
* `cabeza != letra` ==> `cabeza + f(resto)`

**▼ Pseudocódigo**
```text
FUNCION eliminarApariciones(cadena, letra)

    SI cadena está vacía ENTONCES
        Devolver ""
    FIN SI

    cabeza = primer carácter de cadena
    resto = subcadena desde posición 1 hasta el final

    SI cabeza es igual a letra ENTONCES
        Devolver eliminarApariciones(resto, letra)
    SI NO
        Devolver cabeza + eliminarApariciones(resto, letra)
    FIN SI

FIN FUNCIÓN
```

---

## 5. Reemplazar una letra por otra
En una palabra o frase, reemplazar todas las apariciones de una letra vieja por una nueva.

**▼ Análisis recursivo**

| | n | f(n) |
| :--- | :--- | :--- |
| CB | "" | "" |
| ... | | |
| n-1 | "asa", "s", "z" | "aza" |
| n | "casa", "s", "z" | "caza" |
| ... | | |
| n-1 | "ato", "g", "p" | "ato" |
| n | "gato", "g", "p" | "pato" |

* `cabeza == vieja` ==> `nueva + f(resto)`
* `cabeza != vieja` ==> `cabeza + f(resto)`

**▼ Pseudocódigo**
```text
FUNCION reemplazarLetra(cadena, vieja, nueva)

    SI cadena está vacía ENTONCES
        Devolver ""
    FIN SI

    cabeza = primer carácter de cadena
    resto = subcadena desde posición 1 hasta el final

    SI cabeza es igual a vieja ENTONCES
        Devolver nueva + reemplazarLetra(resto, vieja, nueva)
    SI NO
        Devolver cabeza + reemplazarLetra(resto, vieja, nueva)
    FIN SI

FIN FUNCIÓN
```

---

## 6. Validar si una palabra es un palíndromo
Comprobar si una palabra se lee igual de izquierda a derecha que de derecha a izquierda.

**▼ Análisis recursivo**

| | n | f(n) |
| :--- | :--- | :--- |
| CB | "", "a" | Verdadero |
| ... | | |
| n-1 | "s" | Verdadero |
| n | "oso" | Verdadero |
| ... | | |
| n-1 | "enocen" | Falso |
| n | "reconocer" | Verdadero |

* `primero != ultimo` ==> `Falso`
* `primero == ultimo` ==> `f(medio)`

**▼ Pseudocódigo**
```text
FUNCION esPalindromo(cadena)

    SI longitud(cadena) <= 1 ENTONCES
        Devolver Verdadero
    FIN SI

    primero = primer carácter de cadena
    ultimo = último carácter de cadena
    medio = subcadena sin el primero ni el último

    SI primero != ultimo ENTONCES
        Devolver Falso
    SI NO
        Devolver esPalindromo(medio)
    FIN SI

FIN FUNCIÓN
```

---

## 7. Duplicar elementos de una lista
En una lista, duplicar cada uno de sus elementos de forma adyacente (ej. `[1,2]` a `[1,1,2,2]`).

**▼ Análisis recursivo**

| | n | f(n) |
| :--- | :--- | :--- |
| CB | [] | [] |
| ... | | |
| n-1 | [3] | [3, 3] |
| n | [2, 3] | [2, 2, 3, 3] |
| ... | | |
| n-1 | [2, 3] | [2, 2, 3, 3] |
| n | [1, 2, 3] | [1, 1, 2, 2, 3, 3] |

* `lista con elementos` ==> `[cabeza, cabeza] + f(resto)`

**▼ Pseudocódigo**
```text
FUNCION duplicarElementos(lista)

    SI lista está vacía ENTONCES
        Devolver []
    FIN SI

    cabeza = primer elemento de lista
    resto = lista desde posición 1 hasta el final

    Devolver [cabeza, cabeza] concatenado con duplicarElementos(resto)

FIN FUNCIÓN
```

---

## 8. Sumar elementos en posiciones pares
En una lista, sumar únicamente los elementos que se encuentran en posiciones/índices pares (0, 2, 4...).

**▼ Análisis recursivo**

| | n | f(n) |
| :--- | :--- | :--- |
| CB 1 | [] | 0 |
| CB 2 | [5] | 5 |
| ... | | |
| n-1 | [20, 30] | 20 |
| n | [10, 20, 30] | 40 |

* `longitud == 0` ==> `0`
* `longitud == 1` ==> `cabeza`
* `longitud >= 2` ==> `cabeza + f(lista sin primeros dos elementos)`

**▼ Pseudocódigo**
```text
FUNCION sumarPosicionesPares(lista)

    SI longitud(lista) == 0 ENTONCES
        Devolver 0
    FIN SI

    SI longitud(lista) == 1 ENTONCES
        Devolver lista[0]
    FIN SI

    cabeza = lista[0]
    resto_del_resto = lista desde posición 2 hasta el final

    Devolver cabeza + sumarPosicionesPares(resto_del_resto)

FIN FUNCIÓN
```

---

## 9. Conversor a binario
Convertir un número decimal entero en su representación binaria (como cadena de texto).

**▼ Análisis recursivo**

| | n | f(n) |
| :--- | :--- | :--- |
| CB 1 | 0 | "0" |
| CB 2 | 1 | "1" |
| ... | | |
| n-1 | 2 | "10" |
| n | 5 | "101" |
| ... | | |
| n-1 | 5 | "101" |
| n | 11 | "1011" |

* `n > 1` ==> `f(n / 2) + cadena(n módulo 2)`

**▼ Pseudocódigo**
```text
FUNCION conversorBinario(n)

    SI n == 0 ENTONCES
        Devolver "0"
    FIN SI
    
    SI n == 1 ENTONCES
        Devolver "1"
    FIN SI

    mitad = n dividido entre 2 (división entera)
    residuo = n módulo 2

    Devolver conversorBinario(mitad) concatenado con convertirACadena(residuo)

FIN FUNCIÓN
```