# En una palabra/frase, reemplazar una letra por otra

Reemplazar todas las apariciones de un carácter dado por otro en una palabra o frase. La función recibe la cadena de entrada y dos caracteres: el carácter a reemplazar (old) y el carácter nuevo (new). Devuelve una nueva cadena con los reemplazos aplicados.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||entrada (s)|f(s, old, new)|
|-|-:|-|
CB|""|""   # cadena vacía → devolver cadena vacía
CB|"a" con old='a', new='o'|"o"   # reemplazo en única letra
CB|"b" con old='a', new='o'|"b"  # no hay coincidencia
...|  | 
CR primer símbolo coincide|"aX..." con old='a'|new + f("X...", old, new)  # sustituir primer carácter
CR primer símbolo no coincide|"bX..." con old='a'|"b" + f("X...", old, new)  # conservar primer carácter

</div>

</details>

## Pseudocódigo 

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION reemplazarLetra(s, old, new)

    SI s es cadena vacía ENTONCES
        Devolver ""
    FIN SI

    primer <- primer carácter de s
    resto  <- s sin el primer carácter

    SI primer == old ENTONCES
        Devolver new + reemplazarLetra(resto, old, new)
    SINO
        Devolver primer + reemplazarLetra(resto, old, new)
    FIN SI

FIN FUNCIÓN
```

</details>