# Versión Iterativa

## Descripción
Implementación del criptaritmo sin recursividad, utilizando una pila para simular el backtracking.

## Funcionamiento

El algoritmo:

1. utiliza una pila de comandos
2. simula llamadas recursivas
3. gestiona manualmente:
   - asignar
   - explorar
   - desasignar

## Idea clave

Se reemplaza la recursión por una estructura:

- `EXPLORAR`
- `ASIGNAR`
- `DESASIGNAR`

Esto permite controlar completamente el flujo del algoritmo.

## Características

- no usa recursividad
- backtracking manual
- uso de pila (Deque)
- mismo resultado que la versión recursiva

## Ventajas

- control total del flujo
- no depende del stack del sistema
- útil para entender cómo funciona la recursión internamente

## Desventajas

- código más complejo
- más difícil de implementar

## Clase principal

- `SolverCriptaritmoIterativo.java`