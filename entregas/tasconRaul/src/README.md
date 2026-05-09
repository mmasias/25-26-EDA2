# Reto-004
Se busca encontrar un algoritmo que minimice el número de comparaciones.

## El Algoritmo

El algoritmo propuesto se conoce como **Búsqueda en Silla de Montar**. 

### Lógica
Para optimizar la búsqueda, empezamos en la **esquina superior derecha** (fila 0, última columna). En cada paso:
1. Si el valor es **igual** al objetivo: Hemos terminado.
2. Si el valor es **mayor** al objetivo: Descartamos la columna actual (todos los valores debajo son aún mayores). Movemos a la **izquierda**.
3. Si el valor es **menor** al objetivo: Descartamos la fila actual (todos los valores a la izquierda son menores). Movemos hacia **abajo**.

### Trazas de ejemplo

#### Buscando el valor 22:
1. Inicio en **21** (0,4): $22 > 21 \\rightarrow$ abajo.
2. Valor **25** (1,4): $22 < 25 \\rightarrow$ izquierda.
3. Valor **17** (1,3): $22 > 17 \\rightarrow$ abajo.
4. Valor **20** (2,3): $22 > 20 \\rightarrow$ abajo.
5. Valor **27** (3,3): $22 < 27 \\rightarrow$ izquierda.
6. Valor **22** (3,2): **¡Encontrado!** (6 comparaciones).

## Análisis de Complejidad

| Caso | Comparaciones | Ejemplo |
| :--- | :--- | :--- |
| **Mejor Caso** | $1$ | El valor está en la esquina de inicio (ej. 21). |
| **Peor Caso** | $N + M - 1$ | El valor está en la esquina opuesta (ej. 19) o no existe. |


### ¿Se puede mejorar?
En términos de complejidad asintótica del peor caso ($O(n)$), **no**. Cualquier algoritmo debe ser capaz de seguir la "frontera" entre elementos mayores y menores, que en el peor de los casos tiene una longitud de $2N - 1$.

## ¿Es mejor empezar en el centro?

Arrancar desde el centro es mejor **solo si el valor buscado es exactamente el elemento central**. 
- Para buscar el **15**, empezar en el centro toma **1 comparación**.
- Empezar en la esquina toma **5 comparaciones**.

Sin embargo, para la mayoría de los casos y para mantener una lógica de descarte simple y lineal, el algoritmo de la esquina es el estándar de oro.

## Implementación en Java

```java
public class BusquedaMatriz {
    public static boolean buscar(int[][] matriz, int objetivo) {
        if (matriz == null || matriz.length == 0) return false;

        int fila = 0;
        int col = matriz[0].length - 1;
        int comps = 0;

        while (fila < matriz.length && col >= 0) {
            comps++;
            if (matriz[fila][col] == objetivo) {
                System.out.println("Encontrado tras " + comps + " comparaciones.");
                return true;
            }
            if (matriz[fila][col] > objetivo) col--;
            else fila++;
        }
        System.out.println("No encontrado tras " + comps + " comparaciones.");
        return false;
    }
}