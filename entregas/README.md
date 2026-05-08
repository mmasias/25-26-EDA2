# Resolución del Reto: Búsqueda en Matriz Ordenada

Este documento contiene la resolución detallada del desafío de algoritmos propuesto, basándose en la estrategia de búsqueda en matrices con filas y columnas ordenadas.

## 2Think

### 1. Propuesta de Algoritmo

**Descripción:**
Se inicia la búsqueda en el elemento de la esquina superior derecha (fila 0, última columna).

- Si el elemento actual es el buscado (**k**), se termina.
- Si el elemento actual es **mayor que k**, se descarta la columna actual y se mueve a la **izquierda** (ya que todos los elementos debajo en esa columna serán aún mayores).
- Si el elemento actual es **menor que k**, se descarta la fila actual y se mueve hacia **abajo** (ya que todos los elementos a la izquierda en esa fila serán aún menores).

**Traza buscando el valor 22:**

1.  Posición (0,4), Valor: **21**. ¿21 == 22? No. ¿21 < 22? Sí. -> **Bajar**
2.  Posición (1,4), Valor: **25**. ¿25 == 22? No. ¿25 > 22? Sí. -> **Izquierda**
3.  Posición (1,3), Valor: **17**. ¿17 == 22? No. ¿17 < 22? Sí. -> **Bajar**
4.  Posición (2,3), Valor: **20**. ¿20 == 22? No. ¿20 < 22? Sí. -> **Bajar**
5.  Posición (3,3), Valor: **27**. ¿27 == 22? No. ¿27 > 22? Sí. -> **Izquierda**
6.  Posición (3,2), Valor: **22**. ¿22 == 22? Sí. -> **¡Encontrado!**

### 2. Análisis de Comparaciones

- **Mejor caso:** **1 comparación**. Ocurre cuando el elemento buscado está en el punto de partida (esquina superior derecha, el 21).
- **Peor caso:** **N + M - 1 comparaciones** (donde N es el número de filas y M el de columnas). Para esta matriz de 5x5, el peor caso son 9 comparaciones.
- **Identificación del peor caso:** El valor **19** (esquina inferior izquierda) o un valor que no exista pero obligue a recorrer el camino hasta esa esquina.
- **Traza del peor caso (buscando 19):**
  21 (izq) -> 14 (izq) -> 9 (izq) -> 5 (izq) -> 2 (abajo) -> 4 (abajo) -> 8 (abajo) -> 13 (abajo) -> 19 (Encontrado).

### 3. ¿Existe un algoritmo con menos comparaciones?

Para el caso general de una matriz donde las filas y columnas están ordenadas de forma independiente, este algoritmo es óptimo en términos de complejidad temporal lineal $\mathcal{O}(N + M)$. No existe un algoritmo que reduzca significativamente las comparaciones en el peor caso sin añadir restricciones adicionales a la estructura de la matriz.

---

## 2Think²

### 1. Búsqueda de 21

- Empezamos en la esquina superior derecha: **21**.
- 21 == 21. **Encontrado en 1 paso.**

### 2. Búsqueda de 16

- 21 (> 16) -> Izquierda
- 14 (< 16) -> Abajo
- 17 (> 16) -> Izquierda
- 11 (< 16) -> Abajo
- 15 (< 16) -> Abajo
- 22 (> 16) -> Izquierda
- 18 (> 16) -> Izquierda
- 13 (< 16) -> Abajo
- 19 (> 16) -> Izquierda
- **Salida de límites.** Resultado: **No existe.**

### 3. ¿Es mejor arrancar del centro?

**Sí, existen casos concretos.** Por ejemplo, si buscamos el valor **15**, que está en el centro de la matriz:

- **Desde la esquina:** Requiere 5 comparaciones (21 -> 14 -> 17 -> 11 -> 15).
- **Desde el centro:** Requiere 1 sola comparación.
  Sin embargo, arrancar desde la esquina garantiza una reducción constante del espacio de búsqueda (elimina una fila o columna por paso), mientras que arrancar del centro requiere una lógica de "Divide y Vencerás" más compleja para ser eficiente en todos los casos.

---

## 2Think³

### 1. Codificación en Java

- [Archivo algoritmo BusquedaMatriz.java](./caicedoEsteban/src/BusquedaMatriz.java)
