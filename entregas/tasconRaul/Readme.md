# Algoritmos de Ordenación

## 1. QuickSort (Ordenación Rápida)

**Estrategia:** Divide usando un pivote.

**Funcionamiento:**
1. Selecciona un elemento como **pivote** (último elemento)
2. Particiona: reordena el array para que los menores queden a la izquierda y los mayores a la derecha
3. Coloca el pivote en su posición definitiva
4. **Recursión:** aplica lo mismo a la sublista izquierda y derecha

**Complejidad:**
- Promedio: O(n log n)
- Peor caso: O(n²) (cuando el pivote es siempre el máximo/mínimo)

---

## 2. InsertionSort (Ordenación por Inserción)

**Estrategia:** Construye el array ordenado elemento por elemento.

**Funcionamiento:**
1. Recorre el array desde el segundo elemento
2. Para cada elemento, lo compara con los anteriores (ya ordenados)
3. Desplaza los mayores a la derecha
4. Inserta el elemento en su posición correcta

**Complejidad:**
- Promedio: O(n²)
- Mejor caso: O(n) (array ya ordenado)

**Ideal para:** Arrays casi ordenados o pequeños.

---

## 3. MergeSort (Ordenación por Fusión)

**Estrategia:** Divide y vencerás con fusión.

**Funcionamiento:**
1. **Divide** el array en mitades hasta llegar a sub-arrays de 1 elemento
2. **Conquista** (caso base): sub-arrays de 1 elemento ya están ordenados
3. **Fusiona** dos sub-arrays ordenados en uno solo, comparando elementos

**Complejidad:**
- Siempre: O(n log n)
- Requiere espacio extra O(n)

**Estable:** mantiene el orden de elementos iguales.

---

## Resumen Comparativo

| Algoritmo | Mejor | Promedio | Peor | Memoria | Estable |
|-----------|-------|----------|------|---------|---------|
| QuickSort | n log n | n log n | n² | O(log n) | No |
| InsertionSort | n | n² | n² | O(1) | Sí |
| MergeSort | n log n | n log n | n log n | O(n) | Sí |