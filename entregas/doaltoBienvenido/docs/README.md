# Solución de Criptoaritmética: [SEND + MORE = MONEY](entregas\doaltoBienvenido\src\sendMoney.java)

Realizado por [Bienvenido Doalto](https://www.github.com/bienvee3), [Javier Liaño](https://www.github.com/javierlianorioz), [Alejandra Cuesta](https://www.github.com/alejandracuesta) y [Juan Carlos Quintana](https://www.github.com/juanquintanaing)

##  Descripción del Problema
La ecuación a resolver es:
```
  S E N D
+ M O R E
_________
M O N E Y
```

##  Funcionamiento del Algoritmo

El algoritmo utiliza **recursividad** para explorar todas las combinaciones posibles de dígitos, aplicando reglas de poda para ser eficiente.

### 1. Variables de Control
* **`letras`**: Arreglo que contiene las 8 letras únicas del problema.
* **`valores`**: Arreglo que almacena el dígito asignado a cada letra (posiciones correspondientes a `letras`).
* **`usado`**: Un arreglo booleano de **tamaño 10** (índices 0-9). Sirve como memoria para garantizar que ningún dígito se repita en diferentes letras.

### 2. El Caso Base
El punto donde la recursión se detiene es:
```java
if (indice == letras.length) {
    return esSumaCorrecta();
}
```
**Explicación:** Cuando el índice llega a 8, significa que ya hemos asignado un número a cada letra. En ese momento, dejamos de buscar y validamos si la suma matemática es correcta.

## Recursividad y el Backtracking

La **recursividad** es como una fila de personas donde cada una tiene la misma tarea, pero sobre un objeto diferente. En nuestro código, cada "persona" (o llamada a la función) se encarga de **una sola letra**.

### 1. El Flujo de la Recursión
Cuando ejecutamos `backtracking(0)`, el programa abre un "nivel" para la primera letra ('S'). Dentro de ese nivel, cuando llamamos a `backtracking(1)`, el programa **se pausa** y abre un nuevo nivel para la siguiente letra ('E').

* **Nivel 0:** Elige un número para **S** y espera...
* **Nivel 1:** Elige un número para **E** y espera...
* **Nivel 7:** Elige un número para **Y** y, como es la última, verifica la suma.



### 2. El Bloque de Código Clave

```java
private boolean backtracking(int indice) {
    if (indice == letras.length) {
        return esSumaCorrecta(); 
    }

    for (int d = 0; d <= 9; d++) {
        if (usado[d]) continue; 

        usado[d] = true;
        valores[indice] = d;

        if (backtracking(indice + 1)) {
            return true; 
        }

        usado[d] = false;
        valores[indice] = -1;
    }
    return false; 
}
```

##  Topología del Espacio de Búsqueda
El problema se modela como un **Árbol de Decisión Espacial**. 

* **Nodos:** Representan cada letra a la que debemos asignar un valor.
* **Profundidad:** El árbol tiene una profundidad de 8 niveles (uno por letra).
* **Anchura:** Cada nodo tiene hasta 10 ramas posibles (dígitos del 0 al 9).



