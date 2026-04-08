# Reto 002
Realizado por: Andrea Anaya: [@andreaanaya](https://github.com/andreaanaya), Sara Moreno: [@Sara-Moreno-Andrade](https://github.com/Sara-Moreno-Andrade), Beatriz Orozco: [@beatriizorozco](https://github.com/beatriizorozco) y Carla San Juan: [@carlamadero](https://github.com/carlamadero).

El problema consiste en resolver criptaritmos como:
```
   S E N D
 + M O R E
 ---------
 M O N E Y
```

```
  F O R T Y
      T E N
+     T E N
------------
  S I X T Y 
```

```
    O D D
+   O D D
------------
  E V E N 
```
 
Este programa asigna números a cada letra usando recursividad para resolver estos criptaritmos.  

Primero se guardan todas las letras en un array. Luego se usa una función recursiva que va asignando números poco a poco. Cuando ya están todas asignadas, se comprueba si la suma es correcta.  

El programa va probando números para cada letra, bajando de F(n) a F(n-1) hasta llegar al caso base. Si encuentra una combinación válida, la muestra; si no, sigue probando.


---

## Pasos

1. Se empieza llamando a la función `resolver` con el array de letras.  
2. En cada llamada se elige una letra y se le asigna un número que no esté usado.  
3. Se vuelve a llamar a la función recursiva con una letra menos por asignar.  
4. Cuando ya no quedan letras, se comprueba la suma con `ecuacionValida`.  
5. Si no funciona, se vuelve atrás y se prueba otro número.  

---

## Inicio

Se empieza por la primera letra del array y se sigue en orden. Por ejemplo:

- Para `ODD + ODD = EVEN`, el orden es: O, D, E, V, N  
- Para `SEND + MORE = MONEY`, el orden es: M, S, E, N, D, O, R, Y  

---

## [Caso base (CB)](https://github.com/Sara-Moreno-Andrade/25-26-EDA2/blob/c3db192237505b44e4c1027f824be324f9c583d1/entregas/morenoSara/src/AlgoritmoRecursivo.java#L24)

     if (indice == letras.length)

Todas las letras tienen número asignado.
- Se forman los números usando palabraANumero.
- Se comprueba si la suma es correcta con ecuacionValida.
- Si lo es, se imprime el resultado con imprimirResultado.

## [Caso recursivo (CR)](https://github.com/Sara-Moreno-Andrade/25-26-EDA2/blob/c3db192237505b44e4c1027f824be324f9c583d1/entregas/morenoSara/src/AlgoritmoRecursivo.java#L42)

     resolverRecursivo(letras, sumandos, resultado, asignacion, digitosUsados, indice + 1);

La función se vuelve a llamar a sí misma con el siguiente índice de letra.

## Explicación del código
*Antes de volver, se marca el dígito como usado:*

     (digitosUsados[digito] = true)

*Al regresar, se desmarca para probar otros dígitos:*

     (digitosUsados[digito] = false)

*Conversión de palabra a número:*

    int numero = 0;
    for (char letra : palabra.toCharArray()) {
        numero = numero * 10 + asignacion[letra];
    }
*Suma:*

Cada letra representa una posición en el número: unidades, decenas, centenas, etc.
Así se forman correctamente los números para comprobar la suma.

## Optimización
Se empieza por las letras más importantes (primeras de cada palabra) porque no pueden ser 0.
Se recorren los dígitos de 9 a 0 para explorar primero combinaciones con valores altos.
Se puede cambiar el orden de las letras y el recorrido de dígitos según estrategia:
Poner las letras importantes al final para asignarles dígitos altos al final.
Recorrer de 0 a 9 si se desea otra heurística.
