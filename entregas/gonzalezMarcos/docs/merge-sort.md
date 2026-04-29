# Merge Sort — Análisis y traza

[← Volver al README](../README.md) | [Código fuente](../src/MergeSortTraza.java)

## ¿Qué hace este algoritmo?

Merge Sort usa la estrategia de divide y vencerás: divide el array por la mitad una y otra vez hasta tener trozos de un solo elemento, y luego los va juntando (fusionando) en orden. Es como partir un mazo de cartas en montones pequeños y luego ir mezclándolos de forma ordenada.

## Métodos del algoritmo

### `ordenar(array, izquierda, derecha)` — Versión recursiva

```java
public static void ordenar(int[] array, int izquierda, int derecha) {
    if (izquierda >= derecha) {
        return;
    }
    int medio = izquierda + (derecha - izquierda) / 2;
    ordenar(array, izquierda, medio);
    ordenar(array, medio + 1, derecha);
    fusionar(array, izquierda, medio, derecha);
}
```

- **`if (izquierda >= derecha)`**: caso base. Si el subarray tiene 0 o 1 elementos, ya está ordenado.
- **`int medio = ...`**: calcula el punto medio para dividir el array en dos mitades.
- **`ordenar(array, izquierda, medio)`**: ordena recursivamente la mitad izquierda.
- **`ordenar(array, medio + 1, derecha)`**: ordena recursivamente la mitad derecha.
- **`fusionar(...)`**: una vez las dos mitades están ordenadas, las fusiona en una sola secuencia ordenada.

### `ordenarIterativo(array)` — Versión iterativa

```java
public static void ordenarIterativo(int[] array) {
    int n = array.length;
    for (int tamano = 1; tamano < n; tamano *= 2) {
        for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
            int medio = izquierda + tamano - 1;
            int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);
            fusionar(array, izquierda, medio, derecha);
        }
    }
}
```

- **`for (tamano = 1; ...)`**: el bucle externo va duplicando el tamaño de los bloques a fusionar (1, 2, 4...).
- **`for (izquierda = 0; ...)`**: el bucle interno recorre el array fusionando pares de bloques del tamaño actual.
- En vez de dividir desde arriba (recursión), esta versión trabaja desde abajo: empieza fusionando pares de 1 elemento, luego pares de 2, luego de 4, etc.

### `fusionar(array, izquierda, medio, derecha)` — Método compartido

```java
private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
    
}
```

- Crea dos arrays temporales con las dos mitades.
- Usa un `while` que compara el elemento actual de cada mitad y coloca el menor en el array original.
- Cuando una mitad se agota, vuelca los elementos restantes de la otra.

---

## Traza recursiva — `{5, 2, 8, 1, 9, 3}`

```
Estado inicial (Merge Recursivo): [5, 2, 8, 1, 9, 3]
Llamada recursiva: ordenar(izq=0, der=5)
División calculada: medio=2
    Llamada recursiva: ordenar(izq=0, der=2)
    División calculada: medio=1
        Llamada recursiva: ordenar(izq=0, der=1)
        División calculada: medio=0
            Llamada recursiva: ordenar(izq=0, der=0)
            -> CASO BASE ALCANZADO: izq (0) >= der (0). Subarray no divisible.
            Llamada recursiva: ordenar(izq=1, der=1)
            -> CASO BASE ALCANZADO: izq (1) >= der (1). Subarray no divisible.
        [Fusión] Uniendo mitades: [0 a 0] y [1 a 1]
          Mitad Izq extraída: [5]
          Mitad Der extraída: [2]
          Comparando: MitadIzq[0]=5 <= MitadDer[0]=2 -> FALSE. Tomamos de MitadDer (2)
          Volcando resto MitadIzq: 5 en pos 1
          Resultado tras fusión: [2, 5, 8, 1, 9, 3]
        Llamada recursiva: ordenar(izq=2, der=2)
        -> CASO BASE ALCANZADO: izq (2) >= der (2). Subarray no divisible.
    [Fusión] Uniendo mitades: [0 a 1] y [2 a 2]
      Mitad Izq extraída: [2, 5]
      Mitad Der extraída: [8]
      Comparando: MitadIzq[0]=2 <= MitadDer[0]=8 -> TRUE. Tomamos de MitadIzq (2)
      Comparando: MitadIzq[1]=5 <= MitadDer[0]=8 -> TRUE. Tomamos de MitadIzq (5)
      Volcando resto MitadDer: 8 en pos 2
      Resultado tras fusión: [2, 5, 8, 1, 9, 3]
    Llamada recursiva: ordenar(izq=3, der=5)
    División calculada: medio=4
        Llamada recursiva: ordenar(izq=3, der=4)
        División calculada: medio=3
            Llamada recursiva: ordenar(izq=3, der=3)
            -> CASO BASE ALCANZADO: izq (3) >= der (3). Subarray no divisible.
            Llamada recursiva: ordenar(izq=4, der=4)
            -> CASO BASE ALCANZADO: izq (4) >= der (4). Subarray no divisible.
        [Fusión] Uniendo mitades: [3 a 3] y [4 a 4]
          Mitad Izq extraída: [1]
          Mitad Der extraída: [9]
          Comparando: MitadIzq[0]=1 <= MitadDer[0]=9 -> TRUE. Tomamos de MitadIzq (1)
          Volcando resto MitadDer: 9 en pos 4
          Resultado tras fusión: [2, 5, 8, 1, 9, 3]
        Llamada recursiva: ordenar(izq=5, der=5)
        -> CASO BASE ALCANZADO: izq (5) >= der (5). Subarray no divisible.
    [Fusión] Uniendo mitades: [3 a 4] y [5 a 5]
      Mitad Izq extraída: [1, 9]
      Mitad Der extraída: [3]
      Comparando: MitadIzq[0]=1 <= MitadDer[0]=3 -> TRUE. Tomamos de MitadIzq (1)
      Comparando: MitadIzq[1]=9 <= MitadDer[0]=3 -> FALSE. Tomamos de MitadDer (3)
      Volcando resto MitadIzq: 9 en pos 5
      Resultado tras fusión: [2, 5, 8, 1, 3, 9]
[Fusión] Uniendo mitades: [0 a 2] y [3 a 5]
  Mitad Izq extraída: [2, 5, 8]
  Mitad Der extraída: [1, 3, 9]
  Comparando: MitadIzq[0]=2 <= MitadDer[0]=1 -> FALSE. Tomamos de MitadDer (1)
  Comparando: MitadIzq[0]=2 <= MitadDer[1]=3 -> TRUE. Tomamos de MitadIzq (2)
  Comparando: MitadIzq[1]=5 <= MitadDer[1]=3 -> FALSE. Tomamos de MitadDer (3)
  Comparando: MitadIzq[1]=5 <= MitadDer[2]=9 -> TRUE. Tomamos de MitadIzq (5)
  Comparando: MitadIzq[2]=8 <= MitadDer[2]=9 -> TRUE. Tomamos de MitadIzq (8)
  Volcando resto MitadDer: 9 en pos 5
  Resultado tras fusión: [1, 2, 3, 5, 8, 9]
Estado final (Merge Recursivo): [1, 2, 3, 5, 8, 9]
```

---

## Traza iterativa — `{5, 2, 8, 1, 9, 3}`

```
Estado inicial (Merge Iterativo): [5, 2, 8, 1, 9, 3]

--- Pasada con tamaño de sub-arrays: 1 ---
Fusionando bloque iterativo: izq=0, medio=0, der=1
[Fusión] Uniendo mitades: [0 a 0] y [1 a 1]
  Resultado tras fusión: [2, 5, 8, 1, 9, 3]
Fusionando bloque iterativo: izq=2, medio=2, der=3
  Resultado tras fusión: [2, 5, 1, 8, 9, 3]
Fusionando bloque iterativo: izq=4, medio=4, der=5
  Resultado tras fusión: [2, 5, 1, 8, 3, 9]
Array tras pasada (tamaño 1): [2, 5, 1, 8, 3, 9]

--- Pasada con tamaño de sub-arrays: 2 ---
Fusionando bloque iterativo: izq=0, medio=1, der=3
  Resultado tras fusión: [1, 2, 5, 8, 3, 9]
Array tras pasada (tamaño 2): [1, 2, 5, 8, 3, 9]

--- Pasada con tamaño de sub-arrays: 4 ---
Fusionando bloque iterativo: izq=0, medio=3, der=5
  Resultado tras fusión: [1, 2, 3, 5, 8, 9]
Array tras pasada (tamaño 4): [1, 2, 3, 5, 8, 9]
Estado final (Merge Iterativo): [1, 2, 3, 5, 8, 9]
```

---

## Observaciones

1. Ambas versiones producen `[1, 2, 3, 5, 8, 9]`.
2. La recursiva divide desde arriba (top-down) y la iterativa construye desde abajo (bottom-up).
3. El método `fusionar()` es compartido: ambas versiones usan la misma lógica de mezcla.
