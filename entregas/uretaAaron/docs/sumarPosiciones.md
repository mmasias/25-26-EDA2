# Sumar los elementos ubicados en posiciones pares

Dada una lista, obtener la suma de los valores que se encuentran en índices pares, considerando que el primer elemento está en la posición 0.

**Ejemplo:**  
[10,20,30,40,50]  
Índices pares: 0, 2, 4 → 10 + 30 + 50 = 90

---

## Análisis recursivo

Ejemplo con `[10,20,30,40,50]`

| Caso | lista              | f(lista) |
|------|-------------------|----------|
| CB   | []                | 0        |
| ...  | ...               | ...      |
| CR   | [30,40,50]        | 80       |
| CR   | [10,20,30,40,50]  | 90       |

Regla recursiva:

Resultado = `lista[0] + sumarPosicionesPares(sublista desde posicion 2)`

Casos:

- Si la lista está vacía → devolver `0`
- Si solo tiene un elemento → devolver ese elemento
- En otro caso → sumar el primer elemento y continuar desde la posición 2

---

## Pseudocódigo

```text
FUNCION sumarPosicionesPares(lista)

    SI lista ESTA VACIA ENTONCES
        retornar 0
    SINO SI longitud(lista) == 1 ENTONCES
        retornar lista[0]
    SINO
        retornar lista[0] + sumarPosicionesPares(sublista desde posicion 2)
    FIN SI

FIN FUNCION