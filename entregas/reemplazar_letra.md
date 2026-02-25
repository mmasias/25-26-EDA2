# Reemplazar letra en una cadena

Dada una cadena de texto, buscar una letra específica y sustituirla por otra en todas sus apariciones.

## Análisis recursivo

*(Asumiendo que queremos reemplazar la letra 'a' por la letra 'o')*

<div align=center>

| Tipo    | cadena  | f(cadena) |
|---------|---------|-----------|
| CB      | ""      | ""        |
| ...     | ...     | ...       |
| CR n-1  | "ata"   | "oto"     |
| CR n    | "pata"  | "poto"    |

Al reemplazar las 'a' por 'o' en "ata" queda "oto"  
Al reemplazar las 'a' por 'o' en "pata" queda "poto"  

"poto" = "p" + "oto" (porque 'p' no es igual a 'a', la conservamos)  
"oto" = "o" + "to" (porque la primera era 'a', ponemos una 'o' y sumamos el resto)  

→ **f(cadena) = nueva letra + f(resto de la cadena)** *(si la primera letra es igual a la vieja)* → **f(cadena) = primera letra + f(resto de la cadena)** *(si la primera letra es distinta a la vieja)* </div>

## Pseudocódigo

```text
FUNCION reemplazarLetra(cadena, letraVieja, letraNueva)

    SI longitud(cadena) == 0 ENTONCES
        Resultado = ""
    SINO
        PrimeraLetra = cadena[0]
        RestoCadena = subcadena(cadena, 1, longitud(cadena)-1)
        
        SI PrimeraLetra == letraVieja ENTONCES
            // Ponemos la nueva letra y procesamos el resto
            Resultado = letraNueva CONCAT reemplazarLetra(RestoCadena, letraVieja, letraNueva)
        SINO
            // Conservamos la letra original y procesamos el resto
            Resultado = PrimeraLetra CONCAT reemplazarLetra(RestoCadena, letraVieja, letraNueva)
        FIN SI
    FIN SI

    Devolver Resultado

FIN FUNCIÓN