# RESPUESTAS:

### 2Think:

Empiezas en la esquina inferior izquierda de la matriz, y comparamos ese valor con  nuestra k:

- Si valor = k, terminamos porque hemos encontrado k.
- Si valor < k, nos desplazamos una posición a la derecha.
- Si valor > k, nos desplazamos una posición hacia arriba.
Así hasta encontrar nuestra k.

De esta forma se reduce el número de comparaciones ya que se eliminan una fila o columna después de un movimiento.

El mejor caso sería que el valor estuviese en la primera posición desde donde comenzamos a recorrer, con 1 comparación.
El peor caso sería que el valor estuviese en la esquina contraria de la posición de la que empezamos, con 9 comparaciones.

### 2Think²:

- Si buscamos el valor 21, seria el peor caso, ya que serian 9 comparaciones porque está en la esquina contraria a donde empezamos.
19 → 24 → 18 → 22 → 15 → 20 → 30 → 25 → 21

- Si buscamos el valor 16, se harian 9 comparaciones hasta darnos cuenta que ese valor no existe en nuestra matriz.
19 → 13 → 18 → 12 → 15 → 20→ 17 → 14 → 21

- No creo que exista ningún caso en el que arrancar del centro sea mejor, ya que al arrancar desde las esquinas con las normas comentadas antes, recorres mucho más rápido la matriz.

### 2Think³:

```
public static int[] buscarMatriz(int[][] matriz, int k) {
    int filas = matriz.length;
    int columnas = matriz[0].length;

    int i = filas - 1;
    int j = 0;

    while (i >= 0 && j < columnas) {
        int valor = matriz[i][j];

        if (valor == k) {
            return new int[]{i, j};
        } else if (valor < k) {
            j++;
        } else {
            i--;
        }
    }

    return null;
}