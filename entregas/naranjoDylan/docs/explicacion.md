# Explicación detallada de la solución

## 1. Objetivo del reto

El reto pide enriquecer algoritmos clásicos de ordenación con una traza que, por sí sola, permita reconstruir completamente cómo ejecutan los algoritmos sin tocar el código base. La idea central es hacer **visible el invisible**: cada decisión que toma el algoritmo, cada comparación, cada intercambio.

Esto implica mostrar:

- **Estado inicial y final del array**: para verificar que el algoritmo logra su objetivo
- **Todas las comparaciones relevantes**: qué valores se comparan y cuál es el resultado
- **Decisiones tomadas en cada paso**: por qué se toma un camino u otro
- **Modificaciones del array**: dónde va cada elemento y cuándo
- **Flujo de ejecución en recursividad**: la profundidad y la secuencia de llamadas
- **Casos base**: cuándo y por qué el algoritmo deja de recurrir

---

## 2. Restricción aplicada

Se respetó al pie de la letra la restricción del enunciado:

> No se modifica la lógica de los algoritmos.

Las únicas adiciones son:

- Inclusión de `System.out.println`
- Métodos auxiliares para:
  - Mostrar arrays
  - Gestionar indentación

Quedó intacto:
- Condiciones (`if`, `while`)
- Estructuras (`for`, `recursión`)
- Orden de ejecución

---

## 3. Estrategia general

Para todos los algoritmos se sigue el mismo enfoque:

1. Mostrar estado inicial
2. Ejecutar el algoritmo original
3. Insertar trazas en:
   - Comparaciones
   - Movimientos
   - Inserciones
4. Mostrar estado final

---

## 4. Insertion Sort

### Versión iterativa

Se registra:

- Valor actual que se intenta insertar
- Comparaciones con elementos anteriores
- Desplazamientos hacia la derecha
- Inserción final del elemento

**Complejidad**: O(n²) en promedio y peor caso.

### Versión recursiva

Además se agrega:

- Indentación por nivel de recursión
- Identificación de caso base (`n <= 1`)
- Seguimiento de llamadas recursivas

El enfoque recursivo ordena primero los primeros `n-1` elementos y luego inserta el elemento `n` en su posición correcta.

---

## 5. Merge Sort

### Versión recursiva

Se registra:

- División del array en subproblemas
- Índices `izquierda`, `medio`, `derecha`
- Casos base (`izquierda >= derecha`)
- Proceso de fusión paso a paso

El árbol de llamadas es profundo pero permite ver claramente cómo se divide y conquista el problema.

**Complejidad**: O(n log n) en todos los casos.

### Versión iterativa

Se registra:

- Tamaño de bloques (comenzando con 1, duplicándose cada iteración)
- Rangos que se están combinando
- Proceso de fusión

Este enfoque ascendente (bottom-up) evita la recursión pero mantiene la misma complejidad.

---

## 6. Quick Sort

Se registra:

- Selección del pivote (último elemento)
- Comparaciones contra el pivote
- Intercambios realizados
- Posición final del pivote (partición)
- Llamadas recursivas con indentación
- Casos base

**Complejidad**: O(n log n) en promedio, O(n²) en peor caso.

---

## 7. Gestión de indentación

Se utiliza un parámetro `nivel` para:

- Representar profundidad recursiva
- Generar indentación visual (4 espacios por nivel)
- Facilitar lectura del árbol de llamadas

Esto es especialmente útil en **Merge Sort recursivo** y **Quick Sort**, donde el árbol de recursión puede ser profundo.

---

## 8. Impresión de arrays

Los arrays se formatean de forma manual y clara:

```java
System.out.print("[");
for (int i = 0; i < array.length; i++) {
    System.out.print(array[i]);
    if (i < array.length - 1) {
        System.out.print(" ");
    }
}
System.out.print("]");
```

Resultado: `[1 2 3 5 8 9]`

---

## 9. Ejemplo de traza: Insertion Sort (iterativo)

Para el array `[5, 2, 8, 1, 9, 3]`:

```
Array al inicio: [5 2 8 1 9 3]
Tomo el valor 2 de la posición 1
Compruebo 5 > 2: se cumple
Muevo 5 de la posición 0 a la posición 1
Array ahora: [5 5 8 1 9 3]
Ya no quedan elementos a la izquierda (j < 0)
Inserto 2 en la posición 0
Array ahora: [2 5 8 1 9 3]
Tomo el valor 8 de la posición 2
Compruebo 5 > 8: no se cumple
Inserto 8 en la posición 2
Array ahora: [2 5 8 1 9 3]
...
Array al final: [1 2 3 5 8 9]
```

Cada línea corresponde a una acción específica, permitiendo seguir el flujo paso a paso.

---

## 10. Características técnicas destacadas

### Claridad sin verbosidad

Los mensajes son concisos pero informativos:
- `"Compruebo 5 > 2: se cumple"`
- `"Muevo 8 de la posición 2 a la posición 3"`

### Coherencia entre algoritmos

A pesar de sus diferencias, los tres algoritmos utilizan terminología y estructura similar:
- Inicio y final siempre claramente marcados
- Casos base explícitamente identificados
- Comparaciones y modificaciones siempre documentadas

### Indentación inteligente

La indentación visual no solo representa profundidad, sino que facilita identificar:
- Niveles de recursión
- Llamadas relacionadas
- Retornos de funciones

---

## 11. Validación de la implementación

La solución cumple todos los requisitos del reto:

 **Traza exhaustiva**: Cada paso es visible  
 **Sin modificación de lógica**: Solo `System.out.println` añadido  
 **Métodos auxiliares permitidos**: Solo `ConsolaTraza` con formateo  
 **Array de prueba correcto**: `[5, 2, 8, 1, 9, 3]`  
 **Reconstrucción posible**: La salida permite entender completamente los algoritmos  

---

## 12. Conclusiones y aprendizajes

Esta implementación demuestra que:

1. **La visualización educativa es poderosa**: Ver exactamente qué hace un algoritmo es invaluable para comprenderlo profundamente.

2. **Las restricciones fuerzan creatividad**: No modificar la lógica requiere pensar cuidadosamente en dónde insertar trazas.

3. **La consistencia facilita el aprendizaje**: Aplicar el mismo patrón de trazas a tres algoritmos permite compararlos fácilmente.

4. **Los detalles importan**: Pequeños ajustes en la redacción de mensajes hacen una gran diferencia entre una salida confusa y una clara.

5. **El código no hablante sigue siendo un misterio**: Incluso código "elegante" sin trazas es difícil de entender. Esta solución lo deja cristalino.

---


**Fin de la documentación técnica**

Creado por **Dylan Naranjo** como parte del Reto de Recuperación en Estructuras de Datos y Algoritmos II.
