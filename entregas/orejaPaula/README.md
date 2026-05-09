# 2Think

## 1. Algoritmo propuesto

La matriz ya está ordenada ya que los números aumentan tanto hacia la derecha como hacia abajo.  
Por eso no hace falta recorrer toda la matriz número por número.

La idea es empezar desde una esquina que nos permita decidir rápidamente hacia dónde movernos y, al mismo tiempo, descartar partes enteras de la matriz.

Las dos esquinas que funcionan bien son:

- la esquina superior derecha
- la esquina inferior izquierda

Porque desde esas posiciones siempre tenemos una dirección con números mayores y otra con números menores.

Las otras dos esquinas no sirven tan bien, porque no permiten decidir claramente hacia dónde ir.

Para este ejercicio comparé las dos opciones válidas buscando el número 22:

- Empezando desde la esquina superior derecha se necesitan 6 comparaciones.
- Empezando desde la esquina inferior izquierda solo se necesitan 4.

Por eso elijo empezar desde la esquina inferior izquierda.

Las reglas del algoritmo son:

- Si el valor actual es igual a k, ya lo hemos encontrado.
- Si k es mayor que el valor actual, nos movemos a la derecha.
- Si k es menor que el valor actual, subimos.
- Si nos salimos de la matriz, significa que el número no existe.

Traza para buscar k = 22:

19 → 24 → 18 → 22

Resultado: 22 sí existe.  
Comparaciones realizadas: 4.


## 2. Mejor caso y peor caso

El mejor caso ocurre cuando el número que buscamos está justo en la posición donde empezamos.

Por ejemplo:

k = 19

En ese caso solo hace falta 1 comparación.

---

El peor caso ocurre cuando tenemos que recorrer prácticamente todo el camino posible antes de encontrar el valor o comprobar que no existe.

En una matriz de 5 x 5, el máximo número de comparaciones es:

5 + 5 - 1 = 9

Un ejemplo que provoca este peor caso es buscar el valor 21.

Traza:

19 → 24 → 18 → 22 → 15 → 20 → 30 → 25 → 21


## 3. Algoritmo con menos comparaciones en peor caso

No existe un algoritmo mejor para este problema si solo usamos comparaciones y aprovechamos el orden de la matriz.

Aunque algunas posiciones iniciales puedan ser mejores para casos concretos, en el peor caso siempre habrá que recorrer un camino de tamaño:

filas + columnas - 1

En esta matriz:

5 + 5 - 1 = 9 comparaciones.


# 2Think²

## 1. Prueba buscando 21

Recorrido:

19 → 24 → 18 → 22 → 15 → 20 → 30 → 25 → 21

Resultado: 21 sí existe.  
Comparaciones realizadas: 9.


## 2. Prueba buscando 16

Recorrido:

19 → 13 → 18 → 12 → 15 → 20 → 17 → 14 → 21

Después de eso nos salimos de la matriz, así que el valor 16 no existe.

Resultado: 16 no existe.  
Comparaciones realizadas: 9.


## 3. Arrancar desde el centro

Sí existe algún caso concreto en el que empezar desde el centro sea mejor.

Por ejemplo, si buscamos el valor 15, que está justo en el centro de la matriz, lo encontraríamos en una sola comparación.

Sin embargo, empezar desde el centro no suele ser la mejor opción, porque desde ahí no siempre podemos descartar filas o columnas completas como sí hacemos desde las esquinas válidas.


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