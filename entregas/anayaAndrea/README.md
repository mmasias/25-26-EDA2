# Entrega: Reto de Recuperación - Trazas de Ordenación

**Alumna:** Andrea Anaya

Esta carpeta contiene la implementación y documentación para el "Reto de recuperación", cuyo objetivo principal es instrumentar los algoritmos clásicos de ordenación (Insertion Sort, Merge Sort y Quick Sort) mediante instrucciones de traza exhaustivas. Estas trazas permiten reconstruir el árbol de llamadas, las comparaciones decisivas y las transformaciones de estado por las que atraviesa cada algoritmo sobre el arreglo base.

## 📁 Navegabilidad del Proyecto

| Artefacto | Descripción | Enlace / Ubicación |
|---|---|---|
| **Código Fuente** | Implementación en Java de los algoritmos instrumentados (Iterativo y Recursivo). | [Carpeta src/](src/) |
| **Documentación** | Explicación detallada de los requisitos del reto, cómo operan las trazas, y cómo ejecutar las pruebas. | [Explicacion_Reto.md](docs/Explicacion_Reto.md) |
| **Modelos UML** | Diagrama de clases y relaciones de los tres algoritmos utilizados (PlantUML). | [Algoritmos_Ordenacion.puml](modelosUML/Algoritmos_Ordenacion.puml) |
| **Imágenes** | Arte conceptual y recursos gráficos complementarios generados para el reto. | [ordenacion_conceptual.png](images/ordenacion_conceptual.png) |

## 🚀 Resumen Rápido

- Los algoritmos no modifican la lógica original provista, únicamente se introdujeron llamadas a `System.out.println()` para las trazas.
- La profundidad de la recursión se visualiza mediante sangría (indentación).
- Se identifica explícitamente cuándo se alcanza un `[CASO BASE]`.
- Array de prueba estándar utilizado: `{5, 2, 8, 1, 9, 3}`.

*Consulte la [Documentación Adicional](docs/Explicacion_Reto.md) para más detalles.*

