# reemplazarLetra
Reemplazar todas las apariciones de una letra específica por otra nueva dentro de una palabra o frase usando recursividad.

## Análisis recursivo
<div align=center>

| Tipo       | cadena | f(cadena) |
|------------|-------:|----------:|
| CB         | ""     | ""        |
| ...        | ...    | ...       |
| CR resto   | "a"    | "o"       |
| CR resto   | "ta"   | "to"      |
| CR resto   | "ata"  | "oto"     |
| CR cadena  | "lata" | "loto"    |

"lata" reemplazando 'a' por 'o' es "l" + "oto"
"ata" reemplazando 'a' por 'o' es "o" + "to"
"ta" reemplazando 'a' por 'o' es "t" + "o"
→ **f(cadena) = letraNueva + f(resto)** (si primeraLetra coincide con letraVieja)
→ **f(cadena) = primeraLetra + f(resto)** (si NO coincide)
(donde *resto* es la cadena original sin su primer carácter)

</div>

## Pseudocódigo
```text
FUNCION reemplazarLetra(cadena, letraVieja, letraNueva)
    SI longitud(cadena) == 0 ENTONCES
        Resultado = ""
    SINO
        primeraLetra = obtenerPrimerCaracter(cadena)
        resto = obtenerResto(cadena)
        
        SI primeraLetra == letraVieja ENTONCES
            Resultado = letraNueva + reemplazarLetra(resto, letraVieja, letraNueva)
        SINO
            Resultado = primeraLetra + reemplazarLetra(resto, letraVieja, letraNueva)
        FIN SI
    FIN SI
    Devolver Resultado
FIN FUNCIÓN