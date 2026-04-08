# 🧩 Reto Criptoaritmético: SEND + MORE = MONEY

**Nicolás Navas**

---

## 📝 Propuesta Inicial

> Buenas tardes estimado profesor,
> 
> para este reto mi propuesta ve una implementación de recursividad con backtracking. Para que de esta manera el algoritmo recursivo haga sus llamadas. Dado el caso vuelva puntos de control y vaya descartando distintas soluciones que no coinciden con las cláusulas del problema. Usando PODA.
> 
> Sabemos que m vale 1 ese será nuestro caso base, ya que el valor máximo de 5 dígitos a partir de 4 dígitos es 19998.
> 
> También que 2 valores no pueden ser iguales.
> 
> La llamada recursiva debería hacer y deshacer hasta llegar a la solución de este 1 que es m
> 
> ```java
> public class Mone4Nothing {
>     public static void main(String[] args) {
>         System.out.println("SEND \n+ MORE \n------ \n  MONEY");
>         if (digit == 1){
>             return m;
>         }
>         if (digit == nextDigit){
>             return null;
>         }
> 
>         //hacer
>         
>         money(digit + 1);
> 
>         // desahacer
> 
>     }
> }
> ```

---

## 🔍 Justificación de la Solución Implementada

La solución final desarrollada es una traducción directa y funcional de la propuesta inicial, utilizando el paradigma de **búsqueda exhaustiva mediante recursividad y backtracking** (prueba y error sistemática). A continuación se detallan los pilares lógicos de la implementación:

**1. Estructuras de Control y Mapeo**
Para cumplir con la regla de que cada letra debe representar un número único, el algoritmo utiliza un registro lógico (un arreglo booleano) que monitorea qué dígitos del cero al nueve ya han sido asignados. Paralelamente, emplea una estructura de indexación basada en los caracteres para almacenar el valor numérico que se le otorga a cada letra en un momento dado.

**2. Poda y Optimización (Casos Base)**
Tal como se planteó en la propuesta, el algoritmo no empieza a buscar a ciegas. Se aplica una poda inicial crucial: se le asigna directamente el valor de uno a la letra 'M' y se marca ese dígito como no disponible para el resto. Además, se incluye una validación lógica matemática indispensable en la criptoaritmética: la letra 'S', al ser el primer dígito de la palabra superior, tiene prohibido tomar el valor de cero. Estas dos restricciones reducen drásticamente el árbol de búsqueda y mejoran el rendimiento del programa.

**3. El Mecanismo de Backtracking (Hacer y Deshacer)**
El núcleo recursivo avanza letra por letra. Para cada letra, el programa intenta asignarle el primer dígito disponible. Una vez asignado, se "sumerge" recursivamente para intentar darle valor a la siguiente letra. 
* **Hacer:** Se bloquea un número y se avanza.
* **Deshacer:** Si la asignación actual lleva a un callejón sin salida (es decir, no quedan números válidos para las letras restantes o la suma final no cuadra), el algoritmo retrocede, libera el número que había bloqueado y prueba con el siguiente dígito disponible.

**4. Verificación Matemática**
El proceso recursivo termina cuando todas las letras únicas del problema han recibido un valor. En ese instante, el algoritmo reconstruye los números completos de las tres palabras multiplicando cada dígito por su correspondiente peso posicional (unidades, decenas, centenas, etc.). Finalmente, realiza la suma aritmética tradicional; si el resultado de la primera palabra más la segunda es exactamente igual a la tercera, el algoritmo se detiene de forma exitosa y presenta la solución por pantalla.
