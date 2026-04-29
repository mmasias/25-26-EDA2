# Reto de Recuperación - Trazas de Algoritmos de Ordenación

##  Autor
Alejandra Cuesta Rodríguez

---

##  Objetivo

Implementar y trazar completamente los algoritmos:

- Insertion Sort (iterativo y recursivo)
- Merge Sort (recursivo e iterativo)
- Quick Sort

La traza permite reconstruir:
- Todas las decisiones
- Comparaciones realizadas
- Cambios en el array
- Flujo de ejecución (recursión)

---

##  Estructura del proyecto

- [`/src`](./src) → Código fuente
- [`/docs`](./docs) → Documentación adicional

---

##  Solución implementada

Se ha mantenido **intacta la lógica original de los algoritmos**, añadiendo únicamente:

- `System.out.println` para trazas
- Métodos auxiliares (`Utils`)
- Parámetro `depth` para indentación en recursión

---

##  Características de la traza

✔ Estado inicial y final  
✔ Comparaciones (true / false)  
✔ Cambios en el array  
✔ Identificación de casos base  
✔ Indentación por nivel de recursión  

---

##  Ejecución

```bash
javac src/*.java
java src.Main
```

## Array de prueba:

int[] array = {5, 2, 8, 1, 9, 3};

## Resultado esperado:

[1, 2, 3, 5, 8, 9]