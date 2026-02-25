# En una lista, sumar elementos en posiciones pares.

## Análisis recursivo

| Tipo | Entrada (lista, posicion) | Salida |
|------|---------------------------|--------|
| CB | [], 0 | 0 |
| CR n-1 | [5, 3, 2], 0 | 7 |
| CR n | [5, 3, 2, 1], 0 | 7 |

**Observación en aspa:**
- Si estoy en posición par (0, 2, 4...), sumo el elemento
- Salto al siguiente elemento recursivamente

**Relación recursiva:**
```
si posicion es par: lista[0] + sumarPares(lista[2:], 0)
sino: sumarPares(lista[1:], posicion + 1)
```

## Pseudocódigo

```
funcion sumarPosicionesPares(lista, posicion)
    si lista == [] entonces
        devolver 0
    sino
        si posicion % 2 == 0 entonces
            devolver lista[0] + sumarPosicionesPares(lista[1:], posicion + 1)
        sino
            devolver sumarPosicionesPares(lista[1:], posicion + 1)
        fin si
    fin si
fin funcion

// Llamada inicial: sumarPosicionesPares(lista, 0)
```

**Alternativa simplificada (sin índice):**

```
funcion sumarPosicionesPares(lista)
    si lista == [] entonces
        devolver 0
    sino si longitud(lista) == 1 entonces
        devolver lista[0]
    sino
        devolver lista[0] + sumarPosicionesPares(lista[2:])
    fin si
fin funcion
```
