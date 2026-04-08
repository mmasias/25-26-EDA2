# Reto 002 - Algoritmo Recursivo SEND MORE MONEY

## Propuesta Inicial por Correo

```java
public class Reto {

    static void moreMoney(int digit){
        if (digit == 1){
            return 'm';
        }

        if (digit == nextDigit){
            return;
        }

        // hacer
        
        money(digit + 1);

        // deshacer
    }

}
```

Esta fue mi propuesta inicial enviada por correo durante la clase del día lunes. Utilizando el digito para comprobar tanto casos base como PODAs adicionales y sumando 1 al digito al momento del caso recursivo, siguiendo correctamente el "formato" para un algoritmo de Backtracking.

## Justificación de Cambios Realizados

Re analizando el problema, me pude dar cuenta de que tanto la firma como los casos bases estaban correctos, pero mal orientados.

```java
moreMoney(int digit)
```

Primero, cambié la firma a `resolver(int indiceLetra)` porque me di cuenta de que es mucho más eficiente hacer que la recursión avance letra por letra mientras un ciclo interno prueba los 10 números, en vez de comparar cada dígito por cada letra, además de generalizar el nombre, para poder probar no solo el problema inicial si no el de `FORTY TEN TEN SIXTY` también.

```java
if (digit == 1){
    return 'm';
}
```

Para el caso base que definí, estaba mal definido el retorno ya que una función void no puede devolver un caracter. Pero si estaba bien pensado ya que en este caso, la m debía ser 1. Pero me percaté que claramente ninguna de las primeras letras podía ser 0, por lo que en vez de comparar el digito de cada primera letra, lo reemplacé por el string noCero; así, en lugar de precalcular matemáticamente cada problema, solo le indico al programa qué letras iniciales tienen prohibido el cero y dejo que él haga las deducciones.

```java
if (digit == nextDigit) { return; }
```

En este caso, la condición era correcta. Pero de nuevo estaba mal guiado, ya que en este caso es mas sencillo utilizar un array de "digitos usados" en el que se verifique con un ciclo, si ya fue usado, entonces que continue al siguiente digito.

```java
// hacer
        
moreMoney(digit + 1);

// deshacer
```

Finalmente, el "hacer y deshacer", lo mantuve fiel a mi diseño original; lo único que hice fue asignar el valor y bloquear el dígito en los arreglos antes de la llamada recursiva, para luego regresarlos a su estado original justo después y así poder seguir explorando nuevos caminos.