### Explicación del Algoritmo

Para abordar este reto dijiste usar la recursividad, asi que para ver un use de esta pense en ir probando diferentes números del 0 al 9 en cada letra del acertijo. Mi idea principal fue hacer un código general que sirva para cualquier suma de palabras, en lugar de programar las matemáticas de cada acertijo por separado.

Para lograrlo, dividí el código en varios pasos:

1. **Preparación de las letras:** Lo primero que hice fue crear un método que lee las palabras y guarda en una lista todas las letras diferentes que encuentra. Además, añadí una regla para detectar cuáles son las primeras letras de cada palabra, asegurándome así de que nunca se les asigne un cero.

2. **El proceso recursivo:** Después, implementé la función recursiva. Lo que hago aquí es ir tomando cada letra de la lista y asignarle un número que no esté usado. Si al avanzar veo que esa combinación no lleva a ningún lado, la recursividad "retrocede", libera ese número y prueba con el siguiente disponible.

3. **Comprobación final:** Finalmente, cuando todas las letras ya tienen un valor asignado, transformo las palabras en números reales y compruebo si la suma cuadra. 

Si el resultado de la suma es correcto, el programa simplemente imprime en pantalla qué valor le ha tocado a cada letra y muestra la operación matemática de una forma clara y visual.