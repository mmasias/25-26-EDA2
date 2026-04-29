# Memoria - Trazas de algoritmos

Al empezar el ejercicio, lo primero que hice fue leer bien el enunciado para entender qué se pedía exactamente. Vi que los algoritmos ya estaban dados y que lo importante era añadir trazas que permitieran seguir paso a paso su ejecución sin modificar su lógica.

Empecé implementando los algoritmos tal y como venían en el enunciado:

- Insertion Sort (iterativo y recursivo)
- Merge Sort (recursivo e iterativo)
- Quick Sort

Me aseguré en todo momento de no cambiar ninguna condición ni estructura, ya que esto invalidaría la entrega.

Después fui añadiendo las trazas poco a poco. Primero trabajé con Insertion Sort iterativo, mostrando qué elemento se toma, las comparaciones y los cambios en el array.

En la versión recursiva añadí sangría para representar la profundidad de las llamadas y que se pudiera ver claramente el flujo de ejecución. También incluí los casos base explicando por qué se alcanzan.

Con Merge Sort me centré en mostrar cómo se divide el problema y cómo se fusionan las partes. Añadí trazas tanto en la recursión como en el proceso de fusión.

En la versión iterativa de Merge Sort mostré la evolución del tamaño de los bloques que se van combinando.

Por último, en Quick Sort destaqué la elección del pivote, las comparaciones y los intercambios, manteniendo también la sangría en las llamadas recursivas.