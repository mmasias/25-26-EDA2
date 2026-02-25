# eliminarLetra
Eliminar todas las apariciones de una letra dada en una palabra o frase de forma recursiva.

## Análisis recursivo
<div align=center>

| Tipo       | cadena | f(cadena) |
|------------|-------:|----------:|
| CB         | ""     | ""        |
| ...        | ...    | ...       |
| CR resto   | "a"    | ""        |
| CR resto   | "sa"   | "s"       |
| CR resto   | "asa"  | "s"       |
| CR cadena  | "casa" | "cs"      |

"casa" sin 'a' es "c" + "s"
"asa" sin 'a' es "" + "s"
"sa" sin 'a' es "s" + ""
→ **f(cadena) = f(resto)** (si primeraLetra coincide con la letra a eliminar)
→ **f(cadena) = primeraLetra + f(resto)** (si NO coincide)
(donde *resto* es la cadena original sin su primer carácter)

</div>

## Pseudocódigo
```text
FUNCION eliminarLetra(cadena, letra)
    SI longitud(cadena) == 0 ENTONCES
        Resultado = ""
    SINO
        primeraLetra = obtenerPrimerCaracter(cadena)
        resto = obtenerResto(cadena)
        
        SI primeraLetra == letra ENTONCES
            Resultado = eliminarLetra(resto, letra)
        SINO
            Resultado = primeraLetra + eliminarLetra(resto, letra)
        FIN SI
    FIN SI
    Devolver Resultado
FIN FUNCIÓN