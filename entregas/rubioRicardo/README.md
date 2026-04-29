# Reto: Traza Estricta de Algoritmos de Ordenación

Este proyecto implementa tres algoritmos clásicos de ordenación (Insertion Sort, Merge Sort y Quick Sort) con un requisito técnico muy específico: **generar una traza detallada por consola sin alterar la estructura de control de flujo original de los algoritmos**.

## El Desafío

Al solo poder usar metodos auxiliares y que muchas veces lo mas dificil de registrar de los algoritmos es cuando no hacen nada con este codigo se busca mostrar todas las trazas incluyendo cuando se decide no hacer nada por ejemplo, cuando un número ya está en la posición correcta frente a un pivote y se ignora. Esto lo podemos ver al inicio del quick sort  
**Pivote seleccionado: array[5] = 3
    [Comparación] array[0]=5 <= pivote=3 -> false.**


Como se ha visto en clase es mas facil entender o visualizar los niveles viendo la consolo con prints planos por eso uso identacion por niveles usando la variable de estado nivelRecursion en algoritmos recursivos como Merge Sort y Quick Sort.  
 Por Ejemplo:
```text
Estado inicial (Recursivo): [5, 2, 8, 1, 9, 3]
Llamada: ordenar(array, n=6)
    Llamada: ordenar(array, n=5)
        Llamada: ordenar(array, n=4)
            Llamada: ordenar(array, n=3)
                Llamada: ordenar(array, n=2)
                    Llamada: ordenar(array, n=1)
                      [Caso Base Alcanzado] n <= 1.
                -> Evaluando insertar elemento: 2
                  [Comparación/Bucle] j=0 >= 0 y array[0] (5) > ultimo (2) -> VERDADERO. Desplazando.
                    Array resultante: [5, 5, 8, 1, 9, 3]
                  [Fin de Bucle] Condición incumplida. Terminando desplazamientos.
                  [Inserción] Colocando 2 en el índice 0. Array actual: [2, 5, 8, 1, 9, 3]
