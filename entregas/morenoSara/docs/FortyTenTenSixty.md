# Reto 002
Realizado por: Andrea Anaya: [@andreaanaya](https://github.com/andreaanaya), Sara Moreno: [@Sara-Moreno-Andrade](https://github.com/Sara-Moreno-Andrade), Beatriz Orozco: [@beatriizorozco](https://github.com/beatriizorozco) y Carla San Juan: [@carlamadero](https://github.com/carlamadero).

El problema consiste en resolver algunas operaciones como:

# FORTY + TEN + TEN = SIXTY

Este programa resuelve el criptaritmo asignando un número a cada letra usando recursividad. Va probando combinaciones hasta encontrar una que cumpla la suma.

Primero se guardan todas las letras en un array. Luego se usa una función recursiva que va asignando números poco a poco. Cuando ya están todas asignadas, se comprueba si la suma es correcta.

El programa va probando números para cada letra, bajando de F(n) a F(n-1) hasta llegar al caso base. Si encuentra una combinación válida la muestra, si no sigue probando.

```
  F O R T Y
      T E N
+     T E N
------------
  S I X T Y
```

## Pasos

1. Se empieza llamando a la función con el número total de letras.
2. En cada llamada se elige una letra y se le asigna un número que no esté usado.
3. Se vuelve a llamar a la función con una letra menos.
4. Cuando ya no quedan letras, se comprueba la suma.
5. Si no funciona, se vuelve atrás y se prueba otro número.

## Inicio

Se empieza por la primera letra del array, en este caso la S.  
Después se sigue con las siguientes en orden: F, O, R, T, Y, E, N, I, X.

## Caso base (CB)

     if (letrasRestantes == 0)

Todas las letras tienen número.
- Se forman los números FORTY, TEN, TEN y SIXTY.
- Se comprueba si la suma es correcta.
- Si lo es, se imprime el resultado.

## Caso recursivo (CR)

     resolverRecursivo(letrasRestantes - 1);

Función se vuelve a llamar a sí misma pero con una letra menos por asignar.

## Multiplicación

     int FORTY = 10000*F + 1000*O + 100*R + 10*T + Y;

Esto es porque cada letra representa una posición en el número:
- F está en las decenas de mil
- O en las unidades de mil
- R en las centenas
- T en las decenas
- Y en las unidades

Por eso se multiplica por 10000, 1000, 100, 10 o 1, para formar el número correctamente.

## Optimización

Al poner primero S, F y T, se fijan antes las letras más restrictivas (las que no pueden ser 0 y afectan más al resultado).

Además, al recorrer los dígitos de 9 a 0, se exploran primero combinaciones con valores altos, que son más probables en este problema.

Si se quisiera otra estrategia, se podría cambiar:
- Poner S y F al final del array
- Y recorrer de 0 a 9

Así estas letras recibirían valores altos al final del proceso, lo que también puede hacer que el algoritmo converja antes.