# Explicación del Reto: Trazado de Algoritmos (EDA2)

Este reto organiza tres algoritmos de ordenación (Insertion, Merge y Quick Sort) cumpliendo con un sistema de traza detallado. La idea es que, solo leyendo la consola, cualquiera pueda entender qué decisión tomó el algoritmo en cada segundo.

---

## 1. Estructura por Clases (Organización)

En vez de meter todo en un solo archivo gigante, divido el código en clases.

* **`Main.java`**: Es el "jefe". Aquí se crean los arrays de prueba y se lanzan todos los algoritmos uno por uno.
* **`Soporte.java`**: Aquí guardo lo que sirve para que la consola se vea bien (espacios, títulos y el estado inicial/final).
* **Clases de Ordenación**: Cada algoritmo tiene su propia clase (`InsertionSort`, `MergeSort`, `QuickSort`). Esto me permite tener los métodos limpios y con los nombres que pidió el profe.

---

## 2. La Clase `Soporte.java`: El truco de la indentación

Para cumplir con el **Requisito 4** (ver la profundidad de la recursión), uso dos cosas clave:

1.  **`nivelRecursion`**: Es un contador que empieza en 0. Cada vez que el algoritmo se mete más profundo en la recursión, le sumo 1. Cuando sale, le restamos 1.
2.  **Método `ind()`**: Este método simplemente multiplica espacios por el nivel de recursión. Si estoy en el nivel 3, pone 6 espacios. Así, en la consola parece un "árbol" y se entiende qué llamada está dentro de cuál.

También uso el método **`ejecutarPrueba`**. Lo hice así para cumplir el **Requisito 1** (Estado inicial y final) de forma automática. Antes de correr el algoritmo, imprimo el array; corremos el código, y al terminar, lo vuelvo a imprimir.

---

## 3. ¿Cómo cumplimos la Restricción Explícita?

Se dijo desde un primer momento: **"No modifiquen la lógica original"**. Eso significaba que no puedo añadir `if` o `else` nuevos para controlar el flujo de datos.

**El truco del `printf`**:
Para mostrar si una comparación fue `true` o `false` (como pide el **Requisito 2**) sin añadir un `if` extra, meti la lógica directamente en el texto.
* Ejemplo: `System.out.printf("... %b", (a > b))`.
Aquí, el `%b` agarra el resultado de `(a > b)` y escribe `true` o `false` directamente. Así cumple el requisito de informar la decisión sin cambiar ni una sola línea de la lógica de ordenación original del reto.

---

## 4. Los Algoritmos y sus Trazas

### Insertion Sort
* **Iterativo**: Explica cada vez que se intenta "insertar" un número en la parte ya ordenada.
* **Recursivo**: Señala el **Caso Base** (cuando el tamaño es 1, ya está ordenado) y cómo se van insertando los números al volver de la recursión.

### Merge Sort
* Aquí lo importante es la "Fusión". En la traza muestra cómo el algoritmo compara los elementos de la mitad izquierda con la derecha y decide cuál es más pequeño para ponerlo primero en el array real.
* Usa mensajes de "Dividiendo" y "Fusionando" para que se vea cómo funciona el *Divide y Vencerás*.

### Quick Sort
* La clave aquí es el **Pivote**. La traza muestra qué número elegidos como pivote (siempre el último, según el código base) y cómo va moviendo los números menores a la izquierda y los mayores a la derecha.
* Al final de cada partición, muestra dónde quedó el pivote definitivamente.

---

## 5. Resumen de Requisitos logrados

1.  **Estado Inicial/Final**: Se hace en la clase `Soporte`.
2.  **Decisiones relevantes**: Se muestran todas las comparaciones (ej: `5 <= 8 -> true`).
3.  **Modificaciones**: Cada intercambio o desplazamiento se narra en la consola.
4.  **Profundidad visible**: Gracias a los espacios que genera `Soporte.ind()`.
5.  **Casos Base**: Se imprimen mensajes específicos cuando `n <= 1` o `izquierda >= derecha`, explicando que ahí se detiene la recursión.