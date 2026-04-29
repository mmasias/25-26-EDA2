# Insertion Sort — Análisis y traza

[← Volver al README](../README.md) | [Código fuente](../src/InsertionSortTraza.java)

## ¿Qué hace este algoritmo?

Insertion Sort funciona como cuando ordenas cartas en la mano: coges una carta nueva y la colocas en su sitio correcto entre las que ya tienes ordenadas.

El array se divide mentalmente en dos partes:
- **Parte izquierda**: ya está ordenada (al principio solo tiene el primer elemento).
- **Parte derecha**: elementos pendientes de insertar.

En cada paso, se toma el primer elemento de la parte derecha y se inserta en la posición correcta de la parte izquierda, desplazando los elementos mayores una posición a la derecha.

## Versión Iterativa

### Código original

```java
public static void ordenar(int[] array) {
    for (int i = 1; i < array.length; i++) {
        int actual = array[i];
        int j = i - 1;
        while (j >= 0 && array[j] > actual) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = actual;
    }
}
```

### Explicación del código

- **`for (int i = 1; ...)`**: recorre el array desde la posición 1. La posición 0 ya se considera "ordenada" (un solo elemento siempre está ordenado).
- **`int actual = array[i]`**: guarda el elemento que vamos a insertar en la parte ordenada.
- **`int j = i - 1`**: `j` apunta al último elemento de la parte ya ordenada.
- **`while (j >= 0 && array[j] > actual)`**: recorre la parte ordenada hacia atrás. Mientras encontremos elementos mayores que `actual`, los desplazamos una posición a la derecha para hacer hueco.
- **`array[j + 1] = array[j]`**: desplaza el elemento una posición a la derecha.
- **`array[j + 1] = actual`**: cuando el `while` termina (encontramos un elemento menor o llegamos al inicio), insertamos `actual` en el hueco.

### Traza — `{5, 2, 8, 1, 9, 3}`

```
Estado inicial (Iterativo): [5, 2, 8, 1, 9, 3]

Iteración i=1. Evaluando insertar elemento: 2
  Comparación: array[0] (5) > actual (2) -> TRUE
  Desplazamiento: movido 5 a la posición 1 -> [5, 5, 8, 1, 9, 3]
  Inserción: colocado 2 en la posición 0 -> [2, 5, 8, 1, 9, 3]

Iteración i=2. Evaluando insertar elemento: 8
  Comparación: array[1] (5) > actual (8) -> FALSE (o inicio alcanzado)
  Inserción: colocado 8 en la posición 2 -> [2, 5, 8, 1, 9, 3]

Iteración i=3. Evaluando insertar elemento: 1
  Comparación: array[2] (8) > actual (1) -> TRUE
  Desplazamiento: movido 8 a la posición 3 -> [2, 5, 8, 8, 9, 3]
  Comparación: array[1] (5) > actual (1) -> TRUE
  Desplazamiento: movido 5 a la posición 2 -> [2, 5, 5, 8, 9, 3]
  Comparación: array[0] (2) > actual (1) -> TRUE
  Desplazamiento: movido 2 a la posición 1 -> [2, 2, 5, 8, 9, 3]
  Inserción: colocado 1 en la posición 0 -> [1, 2, 5, 8, 9, 3]

Iteración i=4. Evaluando insertar elemento: 9
  Comparación: array[3] (8) > actual (9) -> FALSE (o inicio alcanzado)
  Inserción: colocado 9 en la posición 4 -> [1, 2, 5, 8, 9, 3]

Iteración i=5. Evaluando insertar elemento: 3
  Comparación: array[4] (9) > actual (3) -> TRUE
  Desplazamiento: movido 9 a la posición 5 -> [1, 2, 5, 8, 9, 9]
  Comparación: array[3] (8) > actual (3) -> TRUE
  Desplazamiento: movido 8 a la posición 4 -> [1, 2, 5, 8, 8, 9]
  Comparación: array[2] (5) > actual (3) -> TRUE
  Desplazamiento: movido 5 a la posición 3 -> [1, 2, 5, 5, 8, 9]
  Comparación: array[1] (2) > actual (3) -> FALSE (o inicio alcanzado)
  Inserción: colocado 3 en la posición 2 -> [1, 2, 3, 5, 8, 9]

Estado final (Iterativo): [1, 2, 3, 5, 8, 9]
```

---

## Versión Recursiva

### Código original

```java
public static void ordenar(int[] array, int n) {
    if (n <= 1) {
        return;
    }
    ordenar(array, n - 1);
    int ultimo = array[n - 1];
    int j = n - 2;
    while (j >= 0 && array[j] > ultimo) {
        array[j + 1] = array[j];
        j--;
    }
    array[j + 1] = ultimo;
}
```

### Explicación del código

- **`if (n <= 1)`**: caso base. Si el subarray tiene 1 o menos elementos, ya está ordenado y no hay nada que hacer.
- **`ordenar(array, n - 1)`**: primero ordena recursivamente los `n-1` primeros elementos. Así, cuando volvemos de la recursión, la parte izquierda ya está ordenada.
- **`int ultimo = array[n - 1]`**: guarda el último elemento (el que hay que insertar en la parte ya ordenada).
- **`while (j >= 0 && array[j] > ultimo)`**: igual que en la versión iterativa, desplaza elementos mayores a la derecha para hacer hueco.
- **`array[j + 1] = ultimo`**: coloca el elemento en su posición correcta.

La diferencia con la iterativa es que en vez de usar un `for` para ir avanzando `i`, aquí la recursión se encarga: cada llamada recursiva "espera" a que se ordenen los elementos anteriores antes de insertar el suyo.

### Traza — `{5, 2, 8, 1, 9, 3}`

```
Estado inicial (Recursivo): [5, 2, 8, 1, 9, 3]
Llamada recursiva: ordenar(array, n=6)
    Llamada recursiva: ordenar(array, n=5)
        Llamada recursiva: ordenar(array, n=4)
            Llamada recursiva: ordenar(array, n=3)
                Llamada recursiva: ordenar(array, n=2)
                    Llamada recursiva: ordenar(array, n=1)
                    -> CASO BASE ALCANZADO: n <= 1. El subarray de 1 elemento ya se considera ordenado.
                Retorno de recursión (n=2). Buscando posición para: 2
                  Comparación: array[0] (5) > ultimo (2) -> TRUE
                  Desplazamiento: movido 5 a pos 1 -> [5, 5, 8, 1, 9, 3]
                  Inserción: colocado 2 en pos 0 -> [2, 5, 8, 1, 9, 3]
            Retorno de recursión (n=3). Buscando posición para: 8
              Comparación: array[1] (5) > ultimo (8) -> FALSE
              Inserción: colocado 8 en pos 2 -> [2, 5, 8, 1, 9, 3]
        Retorno de recursión (n=4). Buscando posición para: 1
          Comparación: array[2] (8) > ultimo (1) -> TRUE
          Desplazamiento: movido 8 a pos 3 -> [2, 5, 8, 8, 9, 3]
          Comparación: array[1] (5) > ultimo (1) -> TRUE
          Desplazamiento: movido 5 a pos 2 -> [2, 5, 5, 8, 9, 3]
          Comparación: array[0] (2) > ultimo (1) -> TRUE
          Desplazamiento: movido 2 a pos 1 -> [2, 2, 5, 8, 9, 3]
          Inserción: colocado 1 en pos 0 -> [1, 2, 5, 8, 9, 3]
    Retorno de recursión (n=5). Buscando posición para: 9
      Comparación: array[3] (8) > ultimo (9) -> FALSE
      Inserción: colocado 9 en pos 4 -> [1, 2, 5, 8, 9, 3]
Retorno de recursión (n=6). Buscando posición para: 3
  Comparación: array[4] (9) > ultimo (3) -> TRUE
  Desplazamiento: movido 9 a pos 5 -> [1, 2, 5, 8, 9, 9]
  Comparación: array[3] (8) > ultimo (3) -> TRUE
  Desplazamiento: movido 8 a pos 4 -> [1, 2, 5, 8, 8, 9]
  Comparación: array[2] (5) > ultimo (3) -> TRUE
  Desplazamiento: movido 5 a pos 3 -> [1, 2, 5, 5, 8, 9]
  Comparación: array[1] (2) > ultimo (3) -> FALSE
  Inserción: colocado 3 en pos 2 -> [1, 2, 3, 5, 8, 9]
Estado final (Recursivo): [1, 2, 3, 5, 8, 9]
```

---

## Observaciones

1. Ambas versiones producen el mismo resultado: `[1, 2, 3, 5, 8, 9]`.
2. La versión recursiva baja hasta el caso base (`n=1`) antes de empezar a insertar, mientras que la iterativa empieza a insertar desde el primer paso.
3. La indentación en la versión recursiva muestra el árbol de llamadas: cada nivel más profundo es una llamada pendiente de resolver.
4. En las iteraciones `i=2` (elemento 8) e `i=4` (elemento 9), el elemento ya está en su posición correcta, por lo que no hay desplazamientos.
