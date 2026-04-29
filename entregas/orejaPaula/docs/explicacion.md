# Explicación de la solución

## 1. Objetivo del desarrollo

El objetivo de este reto ha sido mejorar la implementación de varios algoritmos de ordenación con trazas detalladas por consola, de forma que sea posible reconstruir completamente su ejecución únicamente a partir de la salida generada.

Los algoritmos trabajados han sido:

* Insertion Sort (iterativo y recursivo)
* Merge Sort (recursivo e iterativo)
* Quick Sort

Se ha respetado en todo momento la restricción principal del enunciado: **no modificar la lógica de los algoritmos**, limitando los cambios a la inclusión de `System.out.println` y métodos auxiliares.

---

## 2. Enfoque seguido

Antes de comenzar a implementar, he definido los requisitos clave de la traza:

* Mostrar estado inicial y final
* Registrar todas las decisiones relevantes (comparaciones)
* Mostrar cada modificación del array
* Visualizar la recursividad mediante indentación
* Identificar claramente los casos base

A partir de estos requisitos, decidí:

1. **Centralizar la lógica de impresión en una clase auxiliar (`Trazas`)**
2. **Mantener cada algoritmo lo más limpio posible**
3. **Separar claramente cada ejecución para evitar interferencias entre algoritmos**

---

## 3. Estructura de la solución

La solución la he organizado en cinco clases:

```
Main.java
InsertionSort.java
MergeSort.java
QuickSort.java
Trazas.java
```

### 3.1 Main.java

Actúa como director de la ejecución.

Decisiones clave:

* Se utiliza un array base común:

  ```java
  int[] base = {5, 2, 8, 1, 9, 3};
  ```
* Para cada algoritmo se crea una copia:

  ```java
  Arrays.copyOf(base, base.length);
  ```

  Esto evita efectos secundarios entre ejecuciones.
* Se encapsula cada ejecución en métodos independientes para mejorar la legibilidad.

---

### 3.2 Trazas.java

Se crea como componente transversal para resolver:

* Formateo de salida
* Reutilización de código
* Control de indentación

Funciones principales:

* `titulo()` → separadores visuales
* `estadoInicial()` / `estadoFinal()` → requisitos del enunciado
* `array()` → impresión del estado actual
* `indentar()` → clave para la recursividad

**Decisión importante:**
La indentación se implementa manualmente mediante concatenación de espacios en función del nivel.

---

## 4. Desarrollo de los algoritmos

---

### 4.1 Insertion Sort

#### Iterativo

Se han añadido trazas en tres puntos clave:

1. **Inicio de iteración**

   ```java
   i = X, actual = Y
   ```

2. **Comparaciones**

   ```java
   Comparación: A > B -> resultado
   ```

3. **Desplazamientos e inserción**

   * Movimiento de elementos
   * Inserción final del valor

Decisión relevante:
Se distingue explícitamente el caso límite `j < 0` para cumplir el requisito de decisiones completas.

---

#### Recursivo

Se introduce una variable global:

```java
private static int nivelRecursivo
```

Uso:

* Controlar indentación
* Representar el árbol de llamadas

Elementos trazados:

* Llamadas recursivas
* Caso base (`n <= 1`)
* Proceso de inserción tras la recursión

**Idea clave:**
Primero se ordena recursivamente y luego se inserta el último elemento.

---

### 4.2 Merge Sort

#### Recursivo

Se trazan:

* Llamadas con rangos `(izquierda, derecha)`
* División mediante el punto medio
* Casos base

Ejemplo conceptual:

```
ordenar(0,5)
 ├─ ordenar(0,2)
 └─ ordenar(3,5)
```

Se usa `nivelRecursivo` para reflejar esta estructura en consola.

---

#### Iterativo

Se trabaja por bloques de tamaño creciente:

```
1 → 2 → 4 → ...
```

Se trazan:

* Tamaño del bloque
* Rangos que se fusionan

Esto permite visualizar cómo el algoritmo construye el orden de forma progresiva.

---

#### Método `fusionar`

Es el núcleo del algoritmo.

Se trazan:

1. **Subarrays generados**
2. **Comparaciones**
3. **Decisiones (qué elemento se coloca)**
4. **Copias restantes**

Decisión importante:
Mostrar explícitamente el resultado de cada comparación para cumplir el requisito del enunciado.

---

### 4.3 Quick Sort

#### Estructura general

Se trazan:

* Llamadas recursivas con rangos
* Casos base
* Posición final del pivote

---

#### Partición

Elementos clave trazados:

1. **Selección del pivote**
2. **Comparaciones**
3. **Intercambios**
4. **Colocación final del pivote**

Ejemplo:

```
Comparación: array[j] <= pivote
Resultado: verdadero/falso
```

Decisión relevante:
Se distingue claramente entre intercambio y no intercambio.

---

## 5. Gestión de la recursividad

Se ha aplicado un patrón común en todos los algoritmos recursivos:

```java
nivelRecursivo++;
llamada recursiva
nivelRecursivo--;
```

Esto permite:

* Mantener coherencia en la indentación
* Representar visualmente el árbol de ejecución

---

## 9. Conclusión

El desarrollo cumple completamente con los requisitos del enunciado:

* Permite seguir la ejecución paso a paso
* Hace visibles todas las decisiones del algoritmo
* Representa correctamente la recursividad
* Mantiene intacta la lógica original

El resultado es una herramienta didáctica que no solo ordena arrays, sino que permite entender en profundidad cómo funcionan los algoritmos de ordenación.
