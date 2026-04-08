# Reto 002
Realizado por: Andrea Anaya: [@andreaanaya](https://github.com/andreaanaya), Sara Moreno: [@Sara-Moreno-Andrade](https://github.com/Sara-Moreno-Andrade), Beatriz Orozco: [@beatriizorozco](https://github.com/beatriizorozco) y Carla San Juan: [@carlamadero](https://github.com/carlamadero).

El problema consiste en resolver algunas operaciones como:

# ODD + ODD = EVEN

Este programa asigna números a cada letra usando recursividad para resolver el criptaritmo ODD + ODD = EVEN.

Primero se guardan todas las letras en un array. Luego se usa una función recursiva que va asignando números poco a poco. Cuando ya están todas asignadas, se comprueba si la suma es correcta.

El programa va probando números para cada letra, bajando de F(n) a F(n-1) hasta llegar al caso base. Si encuentra una combinación válida la muestra, si no sigue probando.

```
    O D D
+   O D D
------------
  E V E N 
```


## Pasos

1. Se empieza llamando a la función con el número total de letras.
2. En cada llamada se elige una letra y se le asigna un número que no esté usado.
3. Se vuelve a llamar a la función con una letra menos.
4. Cuando ya no quedan letras, se comprueba la suma.
5. Si no funciona, se vuelve atrás y se prueba otro número.

## Inicio

Se empieza por la primera letra del array, en este caso la O.  
Después se sigue con las siguientes en orden: D, E, V, N.

## Caso base (CB)

     if (letrasRestantes == 0)

Todas las letras tienen número.
- Se forman los números ODD, ODD y EVEN.
- Se comprueba si la suma es correcta.
- Si lo es, se imprime el resultado.

## Caso recursivo (CR)

     resolverRecursivo(letrasRestantes - 1);

Función se vuelve a llamar a sí misma pero con una letra menos por asignar.

## Multiplicación

     int ODD = 100*O + 10*D + D;

Esto es porque cada letra representa una posición en el número:
- O está en las centenas
- D en las decenas y unidades
- E, V, N se multiplican según su posición en EVEN: decenas de mil, unidades de mil, centenas, decenas, unidades

Por eso se multiplica por 100, 10 o 1, para formar el número correctamente.

## Optimización

Se empieza por las letras más importantes O y E, porque no pueden ser 0 y determinan el valor del resultado.  

Al recorrer los dígitos de 9 a 0, se exploran primero combinaciones con valores altos, que son más probables en este problema.

Si se quisiera otra estrategia, se podría cambiar:
- Poner O y E al final del array
- Y recorrer de 0 a 9

Así estas letras recibirían valores altos al final del proceso, lo que también puede hacer que el algoritmo converja antes.