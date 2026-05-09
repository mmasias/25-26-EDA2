# 📘 Búsqueda en matriz ordenada

Dada la siguiente matriz, donde las filas crecen de izquierda a derecha y las columnas de arriba abajo:

```
 2   5   9  14  21
 4   7  11  17  25
 8  12  15  20  30
13  18  22  27  35
19  24  28  33  40
```

---

# 🧠 2Think

## 1. Algoritmo propuesto + traza (22)

El algoritmo que propongo consiste en comenzar desde el centro de la matriz y, a partir de ahí, comparar el valor actual con el valor objetivo **k**.

En cada paso:

- si el valor actual es igual a k, se termina la búsqueda  
- si no, se descartan zonas de la matriz utilizando una matriz auxiliar de estado  
- luego se exploran los vecinos siguiendo un orden fijo de movimientos:


La búsqueda se realiza de forma recursiva (DFS con poda).

---

### 🔎 Traza buscando 22

Inicio en el centro:

- 15 → no es 22  
- se descartan regiones irrelevantes según comparación  

Se exploran vecinos en orden:

- 27 → no  
- 11 → no  
- 17 → no  
- 20 → no  
- 18 → no  
- 22 → ✔ encontrado  

---

## 2. Complejidad del algoritmo

### ✔ Mejor caso

El mejor caso ocurre cuando el elemento buscado está en el nodo inicial (centro).

- Comparaciones: **1**

Ejemplo: buscar 15.

---

### ❌ Peor caso

El peor caso ocurre cuando el elemento:

- no existe en la matriz, o  
- está en una posición extrema que obliga a explorar gran parte del espacio

Ejemplo representativo: buscar 40.

En este caso, el algoritmo puede verse obligado a explorar casi todos los nodos alcanzables.

- Complejidad: **O(N · M)**

---

### 📌 ¿Se puede mejorar?

Sí, existe un algoritmo más eficiente aprovechando la propiedad de orden de la matriz.

En lugar de usar recursión con exploración de vecinos, se puede usar un enfoque desde una esquina (por ejemplo, esquina superior derecha):

- si el valor actual es mayor que k → se mueve a la izquierda  
- si es menor que k → se mueve hacia abajo  

Esto reduce la complejidad a:

- **O(N + M)**

---

# 🧠 2Think²

## 1. Búsqueda de 21

- inicio en 15  
- comparación y poda  
- exploración de vecinos  
- se encuentra 21 en pocos pasos  

Resultado: encontrado rápidamente debido a la cercanía al centro.

---

## 2. Búsqueda de 16

- inicio en 15  
- 15 ≠ 16  
- exploración de vecinos según orden  
- no existe 16 en la matriz  

Resultado: el algoritmo explora varias ramas antes de concluir que no existe.

---

## 3. ¿Centro vs esquina?

Sí existen casos donde empezar en el centro es mejor.

### ✔ Centro es mejor cuando:
- el valor buscado está cerca del rango medio de la matriz  
- ejemplos: 15, 17, 20, 22  

### ✔ Esquina es mejor cuando:
- el valor está en los extremos (muy pequeño o muy grande)  
- ejemplos: 2 o 40  

**Conclusión:** no existe un punto de inicio universalmente óptimo, depende del valor buscado.

---

# 🧠 2Think³

## 1. Código del algoritmo

El algoritmo se implementa mediante una búsqueda recursiva con:

- nodo actual  
- matriz de estado para poda  
- exploración de vecinos en orden fijo  
- backtracking automático  

La idea principal es:

- recorrer la matriz como un grafo implícito  
- evitando repetir estados ya descartados  
- y priorizando el orden de movimientos definido  

