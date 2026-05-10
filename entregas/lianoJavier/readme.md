# Atrapar al ratón

He bautizado a mi método como Atrapar al ratón.

## ¿Cómo funciona?

Para definir como funciona primero hay que entender el problema y extraer las ventajas que tenemos.

### ¿El problema?

El problema nos expone una matriz de N*N numeros que aumentan de izquierda a derecha y de arriba a abajo.

```
 2   5   9  14  21
 4   7  11  17  25
 8  12  15  20  30
13  18  22  27  35
19  24  28  33  40
```

### ¿De qué nos podemos beneficiar?

El ejercicio nos da una clara hoja de ruta. Si aumenta cuando vamos a la derecha y disminuye cuando vamos a la izquierda (arriba y abajo lo mismo) entonces nos aprovechamos de ello para atrapar el dato.

## ¿Un ejemplo práctico?

La idea es simple. Por ejemplo vamos a buscar el 19:

Empezamos en el centro siempre (posicion: floor(N/2)*floor(N/2)):

```
 2   5   9  14  21
 4   7  11  17  25
 8  12 (15) 20  30
13  18  22  27  35
19  24  28  33  40
```

15 es menor a 19. Por lo que:

Todo lo que este a la izquierda y arriba, y por consiguiente todos los menores a esos numeros son también descartados de ser 19.

```
 *2*   *5*   *9*  14  21
 *4*   *7*  *11*  17  25
 *8*  *12* (15) 20  30
13  18  22  27  35
19  24  28  33  40
```

Y como 15 tampoco es, pues directamente lo tachamos.

```
 *2*   *5*   *9*  14  21
 *4*   *7*  *11*  17  25
 *8*  *12* (*15*) 20  30
13  18  22  27  35
19  24  28  33  40
```

Entonces lo que hacemos es movernos en diagonal secundaria uno hacia adelante.

```
 *2*   *5*   *9*  14  21
 *4*   *7*  *11*  17  25
 *8*  *12*  *15*  20  30
13  18  22 (27) 35
19  24  28  33  40
```

Como 27 es mayor a 19 todo lo mayor a 27 se tacha y el 27 también.

```
 *2*   *5*   *9*  14  21
 *4*   *7*  *11*  17  25
 *8*  *12*  *15*  20  30
13  18  22 (*27*) *35*
19  24  28  *33*  *40*
```

Como es menor nos intentamos mover para atras en la diagonal secundaria. Como no nos podemos mover la siguiente opción es arriba del 27.

```
 *2*   *5*   *9*  14  21
 *4*   *7*  *11*  17  25
 *8*  *12*  *15* (20) 30
13  18  22  *27*  *35*
19  24  28  *33*  *40*
```

20 es mayor que 19, así que tachamos todo lo que esté a la derecha y abajo.

```
 *2*   *5*   *9*  14  21
 *4*   *7*  *11* (17) 25
 *8*  *12*  *15*  *20*  *30*
13  18  22  *27*  *35*
19  24  28  *33*  *40*
```

Y así hasta encontrar el número.

```
 *2*   *5*   *9* (14) 21
 *4*   *7*  *11*  *17*  *25*
 *8*  *12*  *15*  *20*  *30*
13  18  22  *27*  *35*
19  24  28  *33*  *40*
```

```
 *2*   *5*   *9*  *14*  *21*
 *4*   *7*  *11*  *17*  *25*
 *8*  *12*  *15*  *20*  *30*
13  18  22  *27*  *35*
19  24  28  *33*  *40*
```

Cuando llegemos a este caso entonces buscamos por backtracking el último movimiento posible.

```
 *2*   *5*   *9*  *14*  *21*
 *4*   *7*  *11*  *17*  *25*
 *8*  *12*  *15*  *20*  *30*
13  18 (22) *27*  *35*
19  24  28  *33*  *40*
```

Y volvemos

```
 *2*   *5*   *9*  *14*  *21*
 *4*   *7*  *11*  *17*  *25*
 *8*  *12*  *15*  *20*  *30*
13 (18) *22*  *27*  *35*
19  24  *28*  *33*  *40*
```

```
 *2*   *5*   *9*  *14*  *21*
 *4*   *7*  *11*  *17*  *25*
 *8*  *12*  *15*  *20*  *30*
*13*  *18*  *22*  *27*  *35*
19 (24) *28*  *33*  *40*
```

```
 *2*   *5*   *9*  *14*  *21*
 *4*   *7*  *11*  *17*  *25*
 *8*  *12*  *15*  *20*  *30*
*13*  *18*  *22*  *27*  *35*
(19)*24*  *28*  *33*  *40*
```

Y encontramos el 19! Si no hay más movimientos posibles entonces el número no esta en la matriz.

## ¿Cuál es el algoritmo?

```java
boolean buscarNumero(Nodo nodoActual, int numeroABuscar) {
  if (nodoActual.valor == numeroABuscar) {
    return true;
  }

  if (nodoActual.valor < numeroABuscar) {
    nodoActual.noPosibleMenor();

    if (nodoActual.inferior.derecha.sePuedeIr()) {
      // explorar en segunda diagonal hacia abajo
      if (buscarNumero(nodoActual.inferior.derecha, numeroABuscar)) {
        return true;
      }
    } else if (nodoActual.derecha.sePuedeIr()) {
      // explorar hacia la derecha
      if (buscarNumero(nodoActual.derecha, numeroABuscar)) {
        return true;
      }
    } else if (nodoActual.inferior.sePuedeIr()) {
      // explorar hacia la abajo
      if (buscarNumero(nodoActual.inferior, numeroABuscar)) {
        return true;
      }
    }
  } else if (nodoActual.valor > numeroABuscar) {
    nodoActual.noPosibleMayor();

    if (nodoActual.superior.izquierda.sePuedeIr()) {
      // explorar en segunda diagonal hacia arriba
      if (buscarNumero(nodoActual.superior.izquierda, numeroABuscar)) {
        return true;
      }
    } else if (nodoActual.izquierda.sePuedeIr()) {
      // explorar hacia la izquierda
      if (buscarNumero(nodoActual.izquierda, numeroABuscar)) {
        return true;
      }
    } else if (nodoActual.superior.sePuedeIr()) {
      // explorar hacia arriba
      if (buscarNumero(nodoActual.superior, numeroABuscar)) {
        return true;
      }
    }
  }

  return false;

}
```

Para el codigo completo se puede ver en este [link](./src)

## Respuestas al ejercicio.

### Trazado para 22.


Visitando valor 15 (Buscando: 22)
```
  2    5    9   14   21
  4    7   11   17   25
  8   12  (15)  20   30
 13   18   22   27   35
 19   24   28   33   40
```

Menor que objetivo. Descartando cuadrante superior-izquierdo.
  Visitando valor 27 (Buscando: 22)
```
    *2*    *5*    *9*   14   21
    *4*    *7*   *11*   17   25
    *8*   *12*   *15*   20   30
   13   18   22  (27)  35
   19   24   28   33   40
```

  Mayor que objetivo. Descartando cuadrante inferior-derecho.
    Visitando valor 22 (Buscando: 22)
```
      *2*    *5*    9*   14   21
      *4*    *7*   11*   17   25
      *8*   *12*   15*   20   30
     13   18  (22)  *27*   *35*
     19   24   28   *33*   *40*
```

    Exito: Objetivo encontrado.
Comparaciones totales realizadas: 5

## Trazado para 21.

Visitando valor 15 (Buscando: 21)
  2    5    9   14   21
  4    7   11   17   25
  8   12  (15)  20   30
 13   18   22   27   35
 19   24   28   33   40

Menor que objetivo. Descartando cuadrante superior-izquierdo.
  Visitando valor 27 (Buscando: 21)
    2    5    9   14   21
    4    7   11   17   25
    8   12   15   20   30
   13   18   22  (27)  35
   19   24   28   33   40

  Mayor que objetivo. Descartando cuadrante inferior-derecho.
    Visitando valor 22 (Buscando: 21)
      2    5    9   14   21
      4    7   11   17   25
      8   12   15   20   30
     13   18  (22)  27   35
     19   24   28   33   40

    Mayor que objetivo. Descartando cuadrante inferior-derecho.
      Visitando valor 18 (Buscando: 21)
        2    5    9   14   21
        4    7   11   17   25
        8   12   15   20   30
       13  (18)  22   27   35
       19   24   28   33   40

      Menor que objetivo. Descartando cuadrante superior-izquierdo.
        Visitando valor 24 (Buscando: 21)
          2    5    9   14   21
          4    7   11   17   25
          8   12   15   20   30
         13   18   22   27   35
         19  (24)  28   33   40

        Mayor que objetivo. Descartando cuadrante inferior-derecho.
          Visitando valor 19 (Buscando: 21)
            2    5    9   14   21
            4    7   11   17   25
            8   12   15   20   30
           13   18   22   27   35
          (19)  24   28   33   40

          Menor que objetivo. Descartando cuadrante superior-izquierdo.
          Retrocediendo (Backtracking)...
        Retrocediendo (Backtracking)...
      Retrocediendo (Backtracking)...
    Retrocediendo (Backtracking)...
    Visitando valor 20 (Buscando: 21)
      2    5    9   14   21
      4    7   11   17   25
      8   12   15  (20)  30
     13   18   22   27   35
     19   24   28   33   40

    Menor que objetivo. Descartando cuadrante superior-izquierdo.
      Visitando valor 30 (Buscando: 21)
        2    5    9   14   21
        4    7   11   17   25
        8   12   15   20  (30)
       13   18   22   27   35
       19   24   28   33   40

      Mayor que objetivo. Descartando cuadrante inferior-derecho.
        Visitando valor 25 (Buscando: 21)
          2    5    9   14   21
          4    7   11   17  (25)
          8   12   15   20   30
         13   18   22   27   35
         19   24   28   33   40

        Mayor que objetivo. Descartando cuadrante inferior-derecho.
          Visitando valor 21 (Buscando: 21)
            2    5    9   14  (21)
            4    7   11   17   25
            8   12   15   20   30
           13   18   22   27   35
           19   24   28   33   40

          Exito: Objetivo encontrado.
Comparaciones totales realizadas: 19
--------------------------------------------------

Encontrada: true

## Trazado para 16.

Visitando valor 15 (Buscando: 16)
  2    5    9   14   21
  4    7   11   17   25
  8   12  (15)  20   30
 13   18   22   27   35
 19   24   28   33   40

Menor que objetivo. Descartando cuadrante superior-izquierdo.
  Visitando valor 27 (Buscando: 16)
    2    5    9   14   21
    4    7   11   17   25
    8   12   15   20   30
   13   18   22  (27)  35
   19   24   28   33   40

  Mayor que objetivo. Descartando cuadrante inferior-derecho.
    Visitando valor 22 (Buscando: 16)
      2    5    9   14   21
      4    7   11   17   25
      8   12   15   20   30
     13   18  (22)  27   35
     19   24   28   33   40

    Mayor que objetivo. Descartando cuadrante inferior-derecho.
      Visitando valor 18 (Buscando: 16)
        2    5    9   14   21
        4    7   11   17   25
        8   12   15   20   30
       13  (18)  22   27   35
       19   24   28   33   40

      Mayor que objetivo. Descartando cuadrante inferior-derecho.
        Visitando valor 13 (Buscando: 16)
          2    5    9   14   21
          4    7   11   17   25
          8   12   15   20   30
        (13)  18   22   27   35
         19   24   28   33   40

        Menor que objetivo. Descartando cuadrante superior-izquierdo.
          Visitando valor 19 (Buscando: 16)
            2    5    9   14   21
            4    7   11   17   25
            8   12   15   20   30
           13   18   22   27   35
          (19)  24   28   33   40

          Mayor que objetivo. Descartando cuadrante inferior-derecho.
          Retrocediendo (Backtracking)...
        Retrocediendo (Backtracking)...
      Retrocediendo (Backtracking)...
    Retrocediendo (Backtracking)...
    Visitando valor 20 (Buscando: 16)
      2    5    9   14   21
      4    7   11   17   25
      8   12   15  (20)  30
     13   18   22   27   35
     19   24   28   33   40

    Mayor que objetivo. Descartando cuadrante inferior-derecho.
      Visitando valor 17 (Buscando: 16)
        2    5    9   14   21
        4    7   11  (17)  25
        8   12   15   20   30
       13   18   22   27   35
       19   24   28   33   40

      Mayor que objetivo. Descartando cuadrante inferior-derecho.
        Visitando valor 14 (Buscando: 16)
          2    5    9  (14)  21
          4    7   11   17   25
          8   12   15   20   30
         13   18   22   27   35
         19   24   28   33   40

        Menor que objetivo. Descartando cuadrante superior-izquierdo.
          Visitando valor 21 (Buscando: 16)
            2    5    9   14  (21)
            4    7   11   17   25
            8   12   15   20   30
           13   18   22   27   35
           19   24   28   33   40

          Mayor que objetivo. Descartando cuadrante inferior-derecho.
          Retrocediendo (Backtracking)...
        Retrocediendo (Backtracking)...
      Retrocediendo (Backtracking)...
    Retrocediendo (Backtracking)...
  Retrocediendo (Backtracking)...
Retrocediendo (Backtracking)...
Busqueda finalizada sin exito.
Comparaciones totales realizadas: 20
--------------------------------------------------

Encontrada: false

## ¿En el peor de los casos hay alguna manera mejor de hacerlo?

En principio, hacerlo de forma escalonada desde la esquina superior derecha hasta la esquina inferior izquierda es mejor que el sistema que usamos en el peor de los casos. Pero si buscamos un numero en una posicion aleatoria, de media, este sistema es mejor para matrices más pequeñas porque hace menos comparaciones.

## ¿Cuántas comparaciones hace su algoritmo en el mejor caso? ¿Y en el peor caso?

### Mejor caso: O(1)

Es cuando buscamos en (N/2, N/2) en el caso de esta matriz, en el 15.

### Pero caso: O(N^2)

Es cuando buscamos el valor de arriba a la derecha, en este caso 21

Visitando valor 15 (Buscando: 21)
  2    5    9   14   21
  4    7   11   17   25
  8   12  (15)  20   30
 13   18   22   27   35
 19   24   28   33   40

Menor que objetivo. Descartando cuadrante superior-izquierdo.
  Visitando valor 27 (Buscando: 21)
    2    5    9   14   21
    4    7   11   17   25
    8   12   15   20   30
   13   18   22  (27)  35
   19   24   28   33   40

  Mayor que objetivo. Descartando cuadrante inferior-derecho.
    Visitando valor 22 (Buscando: 21)
      2    5    9   14   21
      4    7   11   17   25
      8   12   15   20   30
     13   18  (22)  27   35
     19   24   28   33   40

    Mayor que objetivo. Descartando cuadrante inferior-derecho.
      Visitando valor 18 (Buscando: 21)
        2    5    9   14   21
        4    7   11   17   25
        8   12   15   20   30
       13  (18)  22   27   35
       19   24   28   33   40

      Menor que objetivo. Descartando cuadrante superior-izquierdo.
        Visitando valor 24 (Buscando: 21)
          2    5    9   14   21
          4    7   11   17   25
          8   12   15   20   30
         13   18   22   27   35
         19  (24)  28   33   40

        Mayor que objetivo. Descartando cuadrante inferior-derecho.
          Visitando valor 19 (Buscando: 21)
            2    5    9   14   21
            4    7   11   17   25
            8   12   15   20   30
           13   18   22   27   35
          (19)  24   28   33   40

          Menor que objetivo. Descartando cuadrante superior-izquierdo.
          Retrocediendo (Backtracking)...
        Retrocediendo (Backtracking)...
      Retrocediendo (Backtracking)...
    Retrocediendo (Backtracking)...
    Visitando valor 20 (Buscando: 21)
      2    5    9   14   21
      4    7   11   17   25
      8   12   15  (20)  30
     13   18   22   27   35
     19   24   28   33   40

    Menor que objetivo. Descartando cuadrante superior-izquierdo.
      Visitando valor 30 (Buscando: 21)
        2    5    9   14   21
        4    7   11   17   25
        8   12   15   20  (30)
       13   18   22   27   35
       19   24   28   33   40

      Mayor que objetivo. Descartando cuadrante inferior-derecho.
        Visitando valor 25 (Buscando: 21)
          2    5    9   14   21
          4    7   11   17  (25)
          8   12   15   20   30
         13   18   22   27   35
         19   24   28   33   40

        Mayor que objetivo. Descartando cuadrante inferior-derecho.
          Visitando valor 21 (Buscando: 21)
            2    5    9   14  (21)
            4    7   11   17   25
            8   12   15   20   30
           13   18   22   27   35
           19   24   28   33   40

          Exito: Objetivo encontrado.
Comparaciones totales realizadas: 19
--------------------------------------------------

true