# 2Think

## 1. Algoritmo propuesto

La matriz está ordenada por filas y columnas. Para reducir comparaciones, no se recorre entera: se empieza en una esquina que permita descartar una fila o una columna en cada paso.

Las esquinas válidas son la superior derecha y la inferior izquierda, porque desde ellas se puede decidir entre dos movimientos útiles. No se usan la superior izquierda ni la inferior derecha porque no permiten descartar correctamente partes de la matriz.

Para este ejercicio comparo las dos esquinas válidas con el valor pedido, 22:

- Desde la superior derecha: 6 comparaciones.
- Desde la inferior izquierda: 4 comparaciones.

Por eso elijo la esquina inferior izquierda.

Reglas del algoritmo:

- Si valor = k, encontrado.
- Si k > valor, derecha.
- Si k < valor, arriba.
- Si se sale de la matriz, no existe.

Traza para k = 22:

19 → 24 → 18 → 22

Resultado: 22 existe.  
Comparaciones: 4.


## 2. Mejor caso y peor caso

Mejor caso: 1 comparación.

Ejemplo: k = 19

Peor caso: 9 comparaciones.

5 + 5 - 1 = 9

Elemento que provoca el peor caso: 21.

Traza:

19 → 24 → 18 → 22 → 15 → 20 → 30 → 25 → 21


## 3. Algoritmo con menos comparaciones en peor caso

No existe un algoritmo que mejore el peor caso usando solo comparaciones y el orden por filas y columnas.

Aunque otra elección pueda mejorar un caso concreto, el peor caso sigue siendo filas + columnas - 1.

En esta matriz:

5 + 5 - 1 = 9 comparaciones.


# 2Think²

## 1. Prueba buscando 21

19 → 24 → 18 → 22 → 15 → 20 → 30 → 25 → 21

Resultado: 21 existe.  
Comparaciones: 9.


## 2. Prueba buscando 16

19 → 13 → 18 → 12 → 15 → 20 → 17 → 14 → 21

Resultado: 16 no existe.  
Comparaciones: 9.


## 3. Arrancar desde el centro

Sí existe un caso concreto.

Si se busca 15 y se empieza en el centro, se encuentra en 1 comparación.

Pero no es mejor como algoritmo general, porque no siempre permite descartar una fila o una columna completa.


# 2Think³

public class BusquedaMatrizOrdenada {

    public static void main(String[] args) {
        int[][] matriz;

        matriz = new int[][] {
            {2, 5, 9, 14, 21},
            {4, 7, 11, 17, 25},
            {8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };

        buscar(matriz, 22);
        buscar(matriz, 21);
        buscar(matriz, 16);
    }

    public static boolean buscar(int[][] matriz, int valorBuscado) {
        int fila;
        int columna;
        int comparaciones;
        boolean encontrado;
        boolean dentroMatriz;

        fila = matriz.length - 1;
        columna = 0;
        comparaciones = 0;
        encontrado = false;
        dentroMatriz = true;

        while (dentroMatriz && !encontrado) {
            comparaciones++;

            if (matriz[fila][columna] == valorBuscado) {
                encontrado = true;
            } else {
                if (valorBuscado > matriz[fila][columna]) {
                    columna++;
                } else {
                    fila--;
                }

                dentroMatriz = fila >= 0 && columna < matriz[0].length;
            }
        }

        if (encontrado) {
            System.out.println(valorBuscado + " encontrado");
        } else {
            System.out.println(valorBuscado + " no encontrado");
        }

        System.out.println("Comparaciones: " + comparaciones);
        System.out.println();

        return encontrado;
    }
}