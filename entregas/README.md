# Documento de Diseño - Reto 002

## 1. Contexto y Estrategia
El objetivo es resolver acertijos de criptoaritmética mediante un algoritmo recursivo de **Backtracking**. 
Para evitar programar una solución que solo resuelva un solo acertijo, el algoritmo tratará el problema abstrayendo las palabras. Lo que haré sera ir asignando valores a las letras de forma secuencial y evaluando la suma matemáticamente solo en el Caso Base.

## 2. Análisis (Casos de Prueba)

### Caso A: `FORTY + TEN + TEN = SIXTY`
* **Letras únicas (El Estado):** `[F, O, R, T, Y, E, N, S, I, X]` (Total: 10 letras). 
* **Letras prohibidas para el 0 (La Poda):** `F`, `T`, `S` (Letras iniciales de cada palabra).

### Caso B: `ODD + ODD = EVEN`
* **Letras únicas (El Estado):** `[O, D, E, V, N]` (Total: 5 letras).
* **Letras prohibidas para el 0 (La Poda):** `O`, `E`.

## 3. Arquitectura del Algoritmo

### 3.1. Preparacion
Para que el algoritmo sea universal, **no escribiré en el código las variables estáticas**. El (`main`) recibirá las palabras involucradas y automatizará el "tablero":
1. Leerá todas las palabras y extraerá un array estricto de **letras únicas**.
2. Leerá el índice `0` de cada palabra y guardará estas letras en un registro de **iniciales prohibidas**.

### 3.2. La Poda (`puedeColocar`)
Antes de registrar un dígito ("Hacer"), se aplican dos reglas de cortocircuito lógico:
* **Exclusividad:** ¿El dígito candidato ya está en el array de `usados`? -> `return false`.
* **Ceros a la izquierda:** ¿El dígito es `0` y la letra actual está en el registro de *iniciales prohibidas*? -> `return false`.

### 3.3. Caso Base y Conversión Matemática
La recursividad se detiene cuando el índice actual es igual a la longitud del array de letras únicas (profundidad máxima alcanzada).
En este punto, se transforman las palabras en números enteros leyendo de izquierda a derecha mediante la técnica de desplazamiento en Base 10:

```text
Algoritmo de conversión:
acumulador = 0
Para cada letra en la palabra:
    acumulador = (acumulador * 10) + mapaDeAsignaciones[letra]
Retornar acumulador
```

## 4. Código fuente

* [`src/SolucionadorCriptoUniversal.java`](./src/SolucionadorCriptoUniversal.java) 