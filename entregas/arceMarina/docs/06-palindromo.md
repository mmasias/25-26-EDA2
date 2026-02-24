# 6. Validar si una palabra es un palíndromo

Verifica si una palabra se lee igual de izquierda a derecha que de derecha a izquierda.

## Análisis recursivo

| Caso | palabra | f(palabra) |
|------|---------|------------|
| CB | longitud ≤ 1 | Verdadero |
| ... | ... | ... |
| medio | "ana" | Verdadero |
| n | "radar" | Verdadero |

**Relación:**  
$f(n) = (primero == ultimo) \text{ AND } f(subcadenaCentral)$

## Pseudocódigo

```text
FUNCION esPalindromo(palabra)
    SI longitud(palabra) <= 1 ENTONCES
        Devolver Verdadero
    FIN SI

    SI primerCaracter(palabra) = ultimoCaracter(palabra) ENTONCES
    Devolver esPalindromo(subcadenaCentral(palabra))
    SINO
        Devolver Falso
    FIN SI
FIN FUNCION