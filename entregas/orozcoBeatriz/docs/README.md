# RETO-004 - Búsqueda en matriz ordenada

La propuesta de clase está subida [aquí](https://github.com/beatriizorozco/25-26-EDA2/blob/reto-004/entregas/orozcoBeatriz/images/RETO-004_ALGORITMO.svg)

## 2Think

### 1. Algoritmo propuesto

Como las filas estan ordenadas de izquierda a derecha y las columnas de arriba abajo, deberíamps empezar en una esquina donde se pueda descartar una fila o una columna completa con una sola comparacion.

Una buena opcion es empezar en la esquina superior derecha:

```text
fila = 0
columna = ultima columna
```

En cada paso se compara `k` con el valor actual:

- Si el valor actual es igual a `k`, se encontro.
- Si el valor actual es mayor que `k`, se descarta esa columna y se mueve una posicion a la izquierda.
- Si el valor actual es menor que `k`, se descarta esa fila y se mueve una posicion hacia abajo.

Ya que desde la esquina superior derecha, todo lo que esta debajo es mayor, todo lo que esta a la izquierda es menor y por eso, cada comparacion elimina una fila o una columna completa.

Matriz:

```text
 2   5   9  14  21
 4   7  11  17  25
 8  12  15  20  30
13  18  22  27  35
19  24  28  33  40
```

Traza buscando `22`:

```text
21 < 22  -> bajar
25 > 22  -> izquierda
17 < 22  -> bajar
20 < 22  -> bajar
27 > 22  -> izquierda
22 = 22  -> encontrado
```

Recorrido:

```text
 2   5   9  14 [21]
 4   7  11 [17][25]
 8  12  15 [20] 30
13  18 [22][27] 35
19  24  28  33  40
```

Comparaciones: `6`.

### 2. Mejor y peor caso

Mejor caso: `1` comparacion.

Es cuando `k` esta justo en la posicion inicial. En este algoritmo, seria `21`.

Peor caso: como la matriz tiene `5` filas y `5` columnas, el recorrido puede hacer como maximo:

```text
filas + columnas - 1 = 5 + 5 - 1 = 9 comparaciones
```

Un elemento que provoca ese peor caso es `19`.

Traza buscando `19`:

```text
21 > 19  -> izquierda
14 < 19  -> bajar
17 < 19  -> bajar
20 > 19  -> izquierda
15 < 19  -> bajar
22 > 19  -> izquierda
18 < 19  -> bajar
24 > 19  -> izquierda
19 = 19  -> encontrado
```

Recorrido:

```text
 2   5   9 [14][21]
 4   7  11 [17] 25
 8  12 [15][20] 30
13 [18][22] 27  35
[19][24] 28  33  40
```

Comparaciones: `9`.

### 3. Puede existir otro algoritmo con menos comparaciones en el peor caso?

No, no existe. En el peor caso necesitas al menos 2n−1 = 9 comparaciones, y el algoritmo de la esquina ya las hace exactas.
Ya que cada comparación solo descarta una fila o una columna, nunca las dos. Con 5 filas y 5 columnas, si haces menos de 9 siempre quedan celdas sin explorar y no puedes afirmar nada con certeza.

## 2Think^2

### 1. Busqueda de 21

Traza:

```text
21 = 21 -> encontrado
```

Recorrido:

```text
 2   5   9  14 [21]
 4   7  11  17  25
 8  12  15  20  30
13  18  22  27  35
19  24  28  33  40
```

Comparaciones: `1`.

### 2. Busqueda de 16

Traza:

```text
21 > 16  -> izquierda
14 < 16  -> bajar
17 > 16  -> izquierda
11 < 16  -> bajar
15 < 16  -> bajar
22 > 16  -> izquierda
18 > 16  -> izquierda
13 < 16  -> bajar
19 > 16  -> izquierda
```

La busqueda termina porque la columna queda fuera de la matriz. Por lo tanto, `16` no existe en la matriz.

Recorrido:

```text
 2   5   9 [14][21]
 4   7 [11][17] 25
 8  12 [15] 20  30
[13][18][22] 27  35
[19] 24  28  33  40
```

Comparaciones: `9`.

### 3. Hay algun caso concreto donde arrancar del centro sea mejor?

De un caso concreto, si existe.

Por ejemplo, buscando `15`:

- Si se empieza desde el centro, se encuentra en `1` comparacion.
- Si se empieza desde la esquina superior derecha:

```text
21 > 15 -> izquierda
14 < 15 -> bajar
17 > 15 -> izquierda
11 < 15 -> bajar
15 = 15 -> encontrado
```

Comparaciones desde la esquina: `5`.

Asi que, para el caso concreto `k = 15`, arrancar del centro es mejor.

## 2Think^3

### Codigo del algoritmo en Java

```java
class ResultadoBusqueda {
    boolean encontrado;
    int fila;
    int columna;
    int comparaciones;

    ResultadoBusqueda(boolean encontrado, int fila, int columna, int comparaciones) {
        this.encontrado = encontrado;
        this.fila = fila;
        this.columna = columna;
        this.comparaciones = comparaciones;
    }
}

class BuscadorMatrizOrdenada {

    public ResultadoBusqueda buscar(int[][] matriz, int k) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return new ResultadoBusqueda(false, -1, -1, 0);
        }

        int filas = matriz.length;
        int columnas = matriz[0].length;

        int fila = 0;
        int columna = columnas - 1;
        int comparaciones = 0;

        while (fila < filas && columna >= 0) {
            int actual = matriz[fila][columna];
            comparaciones++;

            if (actual == k) {
                return new ResultadoBusqueda(true, fila, columna, comparaciones);
            } else if (actual > k) {
                columna--;
            } else {
                fila++;
            }
        }

        return new ResultadoBusqueda(false, -1, -1, comparaciones);
    }
}

public class Main {

    public static void mostrarResultado(int k, ResultadoBusqueda resultado) {
        if (resultado.encontrado) {
            System.out.println(k + " encontrado en posicion ("
                    + resultado.fila + ", " + resultado.columna + ")");
        } else {
            System.out.println(k + " no esta en la matriz");
        }

        System.out.println("Comparaciones: " + resultado.comparaciones);
    }

    public static void main(String[] args) {
        int[][] matriz = {
            {2, 5, 9, 14, 21},
            {4, 7, 11, 17, 25},
            {8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        BuscadorMatrizOrdenada buscador = new BuscadorMatrizOrdenada();

        mostrarResultado(22, buscador.buscar(matriz, 22));
        System.out.println();

        mostrarResultado(21, buscador.buscar(matriz, 21));
        System.out.println();

        mostrarResultado(16, buscador.buscar(matriz, 16));
        System.out.println();

        mostrarResultado(19, buscador.buscar(matriz, 19));
    }
}
```

Prueba:

```text
Para k = 22:
Encontrado en posicion (3, 2)
Comparaciones: 6

Para k = 21:
Encontrado en posicion (0, 4)
Comparaciones: 1

Para k = 16:
16 no esta en la matriz
Comparaciones: 9

Para k = 19:
Encontrado en posicion (4, 0)
Comparaciones: 9
```
### Diagrama UML

<img src="https://raw.githubusercontent.com/beatriizorozco/25-26-EDA2/reto-004/entregas/orozcoBeatriz/images/busqueda_matriz_ordenada.svg" width="700">