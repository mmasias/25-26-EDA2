# Resolución de Acertijos Criptoaritméticos

Este proyecto resuelve acertijos matemáticos donde las letras representan dígitos únicos. La solución se basa en una exploración sistemática de todas las combinaciones posibles hasta encontrar la igualdad numérica.

---

## Estructura de la Solución

El código aborda el problema en tres etapas conceptuales:

---

## 1. Preparación y Extracción

Antes de calcular, el programa necesita conocer el "alfabeto" del acertijo.

- **Identificación:**  
  El método `preparar()` recorre los sumandos y el resultado para filtrar las letras únicas.

- **Mapeo:**  
  Se crean estructuras para asociar cada letra encontrada con un valor numérico y un registro de qué números (0-9) ya están ocupados.

---

## 2. Exploración Mediante Backtracking

La resolución se realiza mediante el método `resolver(int posicion)`, que funciona como un proceso de decisión recursivo.

### 🔹 Caso Base

Es el punto de parada de la recursión.

El caso base ocurre cuando la `posicion` es igual a la cantidad de letras detectadas (`letras.length`). Esto significa que ya se ha asignado un número a cada letra y es momento de verificar si la suma es correcta.

```java
if (posicion == letras.length) {
    return esValido();
}