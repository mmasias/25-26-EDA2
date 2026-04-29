# Explicacion del Reto

En este documento explico como he organizado el codigo para añadir los mensajes de seguimiento a los algoritmos de ordenacion, cumpliendo con la regla de no tocar la logica principal.

## 1. El uso de la clase Soporte

He creado la clase `Soporte` para que funcione como un "ayudante" externo. La idea es que el codigo de los algoritmos se mantenga lo mas limpio posible. 

* **Control de espacios:** Esta clase gestiona la indentacion (los espacios a la izquierda). Asi, cuando una funcion se llama a si misma, los mensajes aparecen mas a la derecha, permitiendo ver visualmente los niveles de la recursion.
* **Simulacion de condiciones:** Como no puedo añadir `if` dentro de los bucles `while` originales para explicar que esta pasando, uso un metodo en esta clase que "lee" las variables y explica por pantalla si la condicion se cumple o no.

## 2. Diferencias entre versiones

### Insertion Sort
* **Iterativo:** Es el metodo clasico de ir moviendo numeros uno a uno en un bucle hasta que encuentran su sitio. Es muy facil de seguir en la consola.
* **Recursivo:** Aqui el algoritmo va "bajando" hasta el primer elemento y luego, al volver hacia arriba, empieza a insertar los numeros en su posicion correcta.

### Merge Sort
* **Recursivo:** El array se va partiendo por la mitad una y otra vez hasta que quedan piezas sueltas, y luego se fusionan en orden.
* **Iterativo:** Funciona al reves. En lugar de dividir, empieza desde abajo agrupando los numeros en parejas, luego en grupos de cuatro, y asi hasta completar el array.

### Quick Sort
* **Recursivo:** Este siempre busca un "pivote" y coloca los numeros mas pequeños a un lado y los mayores al otro. Es muy eficiente y la traza muestra perfectamente como se van creando estas particiones.

## 3. Cumplimiento de los requisitos

He configurado los mensajes para que se vea exactamente como se pide en el reto:

1. **Estado del array:** Se muestra como esta el array al principio y como queda al final de cada metodo.
2. **Comparaciones:** Cada vez que el programa pregunta "es este numero menor que el otro", sale un mensaje con el resultado.
3. **Cambios de posicion:** Si un numero se mueve de indice o se guarda en una variable temporal, queda registrado.
4. **Niveles de profundidad:** Gracias a los espacios, se nota cuando estamos "dentro" de una llamada recursiva.
5. **Casos base:** Cuando un trozo de array es tan pequeño que ya no necesita mas divisiones, el programa avisa que ha llegado al final del camino.
