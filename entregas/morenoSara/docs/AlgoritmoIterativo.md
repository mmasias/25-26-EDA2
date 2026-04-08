# Reto 002 - GRUPAL
Realizado por: Andrea Anaya: [@andreaanaya](https://github.com/andreaanaya), Sara Moreno: [@Sara-Moreno-Andrade](https://github.com/Sara-Moreno-Andrade), Beatriz Orozco: [@beatriizorozco](https://github.com/beatriizorozco) y Carla San Juan: [@carlamadero](https://github.com/carlamadero).

La idea es la misma que en la versión recursiva, pero en vez de dejar que Java gestione los niveles con la pila de llamadas, lo hacemos nosotros a mano con un bucle `while`. En cada vuelta se decide si avanzar, retroceder o comprobar la solución.

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
## De recursivo a iterativo: el cambio clave

En la versión recursiva, cada vez que llamamos a `resolverRecursivo` estamos "bajando" un nivel, y cada vez que la función retorna estamos "subiendo". Java se encarga de recordar en qué punto estábamos.

```java
resolverRecursivo(..., indice + 1);
return;
```

En la versión iterativa no hay pila de llamadas, así que hay que llevar ese control manualmente con dos cosas:

- **`nivel`** — un entero que dice en qué letra estamos, igual que el parámetro `indice` de la recursión.
- **`digitoEnNivel[]`** — un array donde cada posición guarda el próximo dígito a probar en ese nivel, igual que el valor del `for` en cada llamada recursiva.

```java
nivel++;
nivel--;
digitoEnNivel[nivel] = 9;
digitoEnNivel[nivel]--;
```

Lo que antes Java hacía solo, ahora lo escribimos nosotros.

En cada vuelta del `while` pasa exactamente una de estas tres cosas, que se corresponden con los tres caminos de la recursión:

| Situación | Recursivo | Iterativo |
|---|---|---|
| Nivel agotado | el `for` termina → `return` | `digito < 0` → `nivel--` |
| Dígito inválido | `continue` | `else if` → `digitoEnNivel[nivel]--` |
| Dígito válido | llamada recursiva | `else` → `nivel++` |

## Pasos
1. Se empieza en el nivel 0, que corresponde a la primera letra del array, en este caso la O.
2. En cada iteración se elige el dígito más alto disponible para la letra del nivel actual.
3. Si el dígito es válido, se asigna y se baja al siguiente nivel.
4. Cuando se llega al último nivel, se comprueba la suma.
5. Si el nivel se agota (dígito < 0), se deshace la asignación del nivel anterior y se sube.

## Inicio
Se empieza en el nivel 0, que corresponde a la primera letra del array, en este caso la O.  
Después se sigue con las siguientes en orden: D, E, V, N.

## [Nivel agotado (= `return` recursivo)](https://github.com/Sara-Moreno-Andrade/25-26-EDA2/blob/ed934fb9bfa370441736fd8205e44acbe93f89b6/entregas/morenoSara/src/AlgoritmoIterativo.java#L31)
```java
if (digito < 0) {
    digitoEnNivel[nivel] = 9;
    nivel--;
    if (nivel >= 0) {
        digitosUsados[asignacion[letras[nivel]]] = false;
        digitoEnNivel[nivel]--;
    }
}
```
En la recursión, cuando el `for` terminaba sin encontrar nada, la función simplemente retornaba. Aquí hay que hacerlo a mano: se resetea el nivel a 9 para futuras visitas, se sube al nivel anterior, se deshace su asignación y se decrementa su dígito para continuar.

## [Nivel hoja (= caso base)](https://github.com/Sara-Moreno-Andrade/25-26-EDA2/blob/ed934fb9bfa370441736fd8205e44acbe93f89b6/entregas/morenoSara/src/AlgoritmoIterativo.java#L44)
```java
if (nivel == n - 1) {
    if (ecuacionValida(sumandos, resultado, asignacion))
        imprimirResultado(sumandos, resultado, asignacion);
    digitosUsados[digito] = false;
    digitoEnNivel[nivel]--;
}
```
Cuando estamos en el último nivel y el dígito es válido, es el equivalente al `if (indice == letras.length)` de la recursión. Se comprueba la suma, se imprime si es correcta, y se sigue probando en el mismo nivel sin bajar.

## Multiplicación
```java
int ODD = 100*O + 10*D + D;
```
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
