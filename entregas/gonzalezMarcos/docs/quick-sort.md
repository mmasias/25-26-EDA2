# Quick Sort — Análisis y traza

[← Volver al README](../README.md) | [Código fuente](../src/QuickSortTraza.java)

## ¿Qué hace este algoritmo?

Quick Sort elige un elemento del array llamado pivote y reorganiza el resto: los menores o iguales van a la izquierda y los mayores a la derecha. Después, aplica el mismo proceso recursivamente a cada mitad. Es como separar una baraja en dos montones ("menores" y "mayores" que un valor) y repetir hasta que todo quede ordenado.

## Métodos del algoritmo

### `ordenar(array, izquierda, derecha)`

```java
public static void ordenar(int[] array, int izquierda, int derecha) {
    if (izquierda >= derecha) {
        return;
    }
    int indicePivote = particionar(array, izquierda, derecha);
    ordenar(array, izquierda, indicePivote - 1);
    ordenar(array, indicePivote + 1, derecha);
}
```

- **`if (izquierda >= derecha)`**: caso base. Si el segmento tiene 0 o 1 elementos, ya está ordenado.
- **`particionar(...)`**: reorganiza el segmento para que el pivote quede en su posición definitiva. Devuelve el índice donde quedó.
- **`ordenar(array, izquierda, indicePivote - 1)`**: ordena recursivamente todo lo que quedó a la izquierda del pivote.
- **`ordenar(array, indicePivote + 1, derecha)`**: ordena recursivamente todo lo que quedó a la derecha del pivote.

### `particionar(array, izquierda, derecha)`

```java
private static int particionar(int[] array, int izquierda, int derecha) {
    int pivote = array[derecha];
    int i = izquierda - 1;
    for (int j = izquierda; j < derecha; j++) {
        if (array[j] <= pivote) {
            i++;
            int temporal = array[i];
            array[i] = array[j];
            array[j] = temporal;
        }
    }
    int temporal = array[i + 1];
    array[i + 1] = array[derecha];
    array[derecha] = temporal;
    return i + 1;
}
```

- **`int pivote = array[derecha]`**: se elige el último elemento como pivote.
- **`int i = izquierda - 1`**: `i` marca el límite de la zona de "menores o iguales". Empieza antes del segmento.
- **`for (int j = ...)`**: recorre todos los elementos del segmento (excepto el pivote).
  - Si `array[j] <= pivote`: el elemento pertenece a la zona izquierda, así que incrementamos `i` y lo intercambiamos a esa zona.
  - Si `array[j] > pivote`: el elemento se queda donde está (zona derecha).
- Al final del `for`, intercambiamos el pivote con `array[i + 1]` para colocarlo en su posición definitiva entre las dos zonas.
- **`return i + 1`**: devuelve el índice final del pivote.

---

## Traza — `{5, 2, 8, 1, 9, 3}`

```
Estado inicial (Quick Sort): [5, 2, 8, 1, 9, 3]
Llamada recursiva: ordenar(izq=0, der=5)
[Partición] Segmento [0 a 5]. Pivote elegido: 3 (en índice 5)
  Comparando array[0] (5) <= pivote (3) -> FALSE (se queda en la zona de mayores)
  Comparando array[1] (2) <= pivote (3) -> TRUE
    Intercambio: valores 5 y 2 en índices 0 y 1 -> [2, 5, 8, 1, 9, 3]
  Comparando array[2] (8) <= pivote (3) -> FALSE (se queda en la zona de mayores)
  Comparando array[3] (1) <= pivote (3) -> TRUE
    Intercambio: valores 5 y 1 en índices 1 y 3 -> [2, 1, 8, 5, 9, 3]
  Comparando array[4] (9) <= pivote (3) -> FALSE (se queda en la zona de mayores)
  [Fin Partición] Intercambio final del pivote 3 a su índice final 2 -> [2, 1, 3, 5, 9, 8]
Partición completada. Elemento pivote colocado en índice definitivo: 2
    Llamada recursiva: ordenar(izq=0, der=1)
    [Partición] Segmento [0 a 1]. Pivote elegido: 1 (en índice 1)
      Comparando array[0] (2) <= pivote (1) -> FALSE (se queda en la zona de mayores)
      [Fin Partición] Intercambio final del pivote 1 a su índice final 0 -> [1, 2, 3, 5, 9, 8]
    Partición completada. Elemento pivote colocado en índice definitivo: 0
        Llamada recursiva: ordenar(izq=0, der=-1)
        -> CASO BASE ALCANZADO: izq (0) >= der (-1). No requiere ordenación.
        Llamada recursiva: ordenar(izq=1, der=1)
        -> CASO BASE ALCANZADO: izq (1) >= der (1). No requiere ordenación.
    Llamada recursiva: ordenar(izq=3, der=5)
    [Partición] Segmento [3 a 5]. Pivote elegido: 8 (en índice 5)
      Comparando array[3] (5) <= pivote (8) -> TRUE
        Sin intercambio visible (i == j, ambos son 3).
      Comparando array[4] (9) <= pivote (8) -> FALSE (se queda en la zona de mayores)
      [Fin Partición] Intercambio final del pivote 8 a su índice final 4 -> [1, 2, 3, 5, 8, 9]
    Partición completada. Elemento pivote colocado en índice definitivo: 4
        Llamada recursiva: ordenar(izq=3, der=3)
        -> CASO BASE ALCANZADO: izq (3) >= der (3). No requiere ordenación.
        Llamada recursiva: ordenar(izq=5, der=5)
        -> CASO BASE ALCANZADO: izq (5) >= der (5). No requiere ordenación.
Estado final (Quick Sort): [1, 2, 3, 5, 8, 9]
```

---

## Observaciones

1. El pivote se elige como el último elemento del segmento.
2. Cuando `i == j`, el elemento ya está en la zona correcta y no hace falta intercambiar.
3. El caso base se alcanza cuando `izquierda >= derecha` (segmento de 0 o 1 elementos).
4. Los casos base con `der=-1` aparecen cuando el pivote queda en la primera posición del segmento, dejando un subarray izquierdo vacío.
