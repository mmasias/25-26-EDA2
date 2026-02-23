# Recursividad – Explicación

## Definición

La recursividad es una técnica donde un método se llama a sí mismo.

Todo algoritmo recursivo tiene:

- Caso base
- Llamada recursiva
- Reducción del problema

---

## Estrategia aplicada

Cada ejercicio sigue la forma:

f(n) =
    caso base
    combinación con f(n-1)

---

## Ejemplo

Conversión decimal a binario:

decimalABinario(n)

Caso base:
n < 2

Recursión:
decimalABinario(n/2) + n%2