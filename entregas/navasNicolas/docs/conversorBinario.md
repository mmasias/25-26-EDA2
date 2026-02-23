# Conversor a binario

Convierte un número entero positivo de base 10 a su representación binaria (cadena). 

<details>
<summary>Ver análisis recursivo corregido</summary>

<div align=center>

| Caso | n | f(n) |
| :--- | :--- | :--- |
| **Base (CB)** | 0 | "0" |
|  | 1 | "1" |
|  | 2 | "10" |
|  | ... | ... |
|  | ... | ... |
|  | ... | ... |
|  | 9 | "1001" |
| **Recursivo (CR)** | 10 | "1010" (f(1)+f(n-1)) |


</div>

</details>

## Pseudocódigo
<details>
<summary>ver pseudocódigo</summary>

```text
FUNCION convertirABinario(n)
    // Caso especial para el cero puro
    SI n == 0 ENTONCES
        DEVOLVER "0"
    FIN SI
    
    // Caso base para detener la recursión
    SI n == 1 ENTONCES
        DEVOLVER "1"
    FIN SI

    // Llamada recursiva: dividimos el problema a la mitad
    // y pegamos el resto (0 o 1) al final de la cadena
    DEVOLVER convertirABinario(n DIV 2) + convertirATexto(n MOD 2)
FIN FUNCIÓN
'''
</details>