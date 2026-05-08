# Desarrollo de la Propuesta

Propongo un algoritmo basado en revisar el **rango que alcanza cada fila considerando k**.

Luego utilizar búsqueda binaria dentro de las filas donde el rango pueda incluir `k`, descartando aquellas filas donde el valor no coincide en el rango.

## Análisis de Casos Mejores vs Peores

- Descartar la fila tiene complejidad **O(1)**
- El algoritmo revisa `N` filas una por una (**O(N)**), donde el peor de los casos ocurre cuando deben recorrerse todas las filas (o concretamente cuando `k` cabe en todos los rangos de todas las filas).
- Si `k` pasa el filtro de rango, la complejidad de la búsqueda binaria será de **O(log M)**.

El peor caso será cuando el `k` que buscamos, no esté en la matriz pero encaje en todos los rangos de fila.

Cada `N` filas hará la comprobación O(1) y ejecutará la búsqueda binaria, entonces la fórmula será...

```java
N filas * (1 comprobación + log M búsquedas)
```

Por lo que finalmente:

- **Peor Caso**: Complejidad de **O(N log M)**

- **Mejor Caso**: Complejidad de **O(1)** (la única comprobación si el número a buscar coincide exactamente con el primer elemento de la primera fila, resolviéndose en tiempo constante.)


## Comparativa 

Para visualizar la eficiencia de la propuesta, debemos observar su comportamiento frente a un enfoque de Fuerza Bruta a medida que el volumen de datos crece. 

Aunque en esta matriz el beneficio es poco perceptible, siendo rebasado por otras [aproximaciones](/entregas/alvaradoCarlos/docs/aproximacionesAdicionales.md), el ahorro se ve en estructuras mayores como:

**Escenario: Matriz de 1,000 x 1,000 (1 millón de elementos)**

|  Algoritmo   |   Modelo de Crecimiento   | Peor Caso|
|-----|-------|-----|
| Fuerza Bruta    |  **O(N x M)**    | 1,000,000 de comprobaciones|
| Mi Propuesta    |   **O(N log M)**  | ~14,000 comprobaciones|

Mientras que la fuerza bruta requiere un millón de pasos para procesar una matriz de estas dimensiones, mi propuesta resuelve el problema en aproximadamente 14,000 operaciones. Esto representa una reducción del **98.6%** en el esfuerzo de procesamiento.