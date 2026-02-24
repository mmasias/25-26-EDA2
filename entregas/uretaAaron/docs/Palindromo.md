# Comprobar si una palabra es palíndromo

Verificar si una palabra se lee igual de izquierda a derecha que de derecha a izquierda utilizando recursividad.

---

## Análisis recursivo

Ejemplo: `"reconocer"`

| Caso | cadena        | f(cadena) |
|------|--------------|-----------|
| CB   | "" o 1 letra | VERDADERO |
| ...  | ...          | ...       |
| CR   | "econoce"    | VERDADERO |
| CR   | "reconocer"  | VERDADERO |

Regla recursiva:

- Si la longitud de la cadena es menor o igual a 1 → devolver `VERDADERO`
- Si la primera y la última letra son diferentes → devolver `FALSO`
- Si la primera y la última letra son iguales →  
  resultado = `esPalindromo(subcadena sin primera y última)`

---

## Pseudocódigo

```text
FUNCION esPalindromo(cadena)

    SI longitud(cadena) <= 1 ENTONCES
        retornar VERDADERO
    SINO
        primera = cadena[0]
        ultima = cadena[longitud(cadena) - 1]
        sub = subcadena desde 1 hasta longitud - 2

        SI primera != ultima ENTONCES
            retornar FALSO
        SINO
            retornar esPalindromo(sub)
        FIN SI
    FIN SI

FIN FUNCION