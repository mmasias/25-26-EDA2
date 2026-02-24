# duplicarElementos

Dada una lista, crear una nueva donde cada elemento aparezca dos veces seguidas.

## Análisis recursivo

<div align=center>

| Tipo    | lista   | f(n)          |
|---------|---------|---------------|
| CB      | []      | []            |
|..       | ...     | ...           |
| CR n-1  | [2, 3]  | [2, 2, 3, 3]  |
| CR n    | [1, 2, 3]| [1, 1, 2, 2, 3, 3] |


Patrón de recursividad:

- Si la lista está vacía → **f(n) = []**
- Para cualquier otro caso → **f(n) = [Cabeza, Cabeza] + f(n-1)**

</div>

## Pseudocódigo

```text
FUNCION duplicarElementos(lista)

    SI lista es vacía ENTONCES
        Resultado = []
    SINO
        cabeza = lista[0]
        resto  = lista[1...longitud(lista)-1]
        
        // El símbolo '+' aquí significa concatenar listas
        Resultado = [cabeza, cabeza] + duplicarElementos(resto)
    FIN SI

    Devolver Resultado

FIN FUNCIÓN