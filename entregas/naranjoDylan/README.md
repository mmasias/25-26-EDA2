# Búsqueda en Matriz Ordenada — Entrega EDA2

**Autor**: Dylan Naranjo Sánchez  
**Fecha**: Mayo 2026  
**Asignatura**: Estructura de Datos y Algoritmos II

## Objetivo
Implementar un algoritmo que determine si un valor `k` existe en una matriz bidimensional ordenada (filas crecientes izquierda→derecha, columnas crecientes arriba→abajo), minimizando comparaciones.

## Propuesta teórica (resumen)
- **Estrategia**: Búsqueda tipo "escalera" (*Saddleback Search*) desde la esquina superior derecha.
- **Complejidad**: O(m+n) tiempo, O(1) espacio.
- **Óptimo**: Sí, cota inferior probada para este modelo de comparaciones.

