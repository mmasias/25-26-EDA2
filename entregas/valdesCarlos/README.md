# Explicación planteamiento ejercicio recursvidad
## Carlos Valdes, Marcos González ([marcosgonzalezhidalgo](https://github.com/marcosgonzalezhidalgo)), Diego Alonso ([diego-alonsodiaz](https://github.com/diego-alonsodiaz)), Sergio Puente ([sergioopuente](https://github.com/sergioopuente))

## Topología sendMoreMoney

**Caso base:**
``` java
if (indice == LETRAS.length) {
            return esSumaCorrecta(asignacion);
        }
```
[Link al codigo](https://github.com/carlosvaldesbarquin/25-26-EDA2/blob/dfb81c5e1c7cc56424bc0d9be788be05222d772b/entregas/valdesCarlos/src/sendMoreMoney.java#L24-L26)
<div align=center>

| | n (Letra actual) | Ficha asignada | Estado de la Pizarra | f(n) |
| :---: | :---: | :---: | :--- | :---: |
| **CB** | Fin | - | `[9, 5, 6, 7, 1, 0, 8, 2]` | `esSumaCorrecta()` |
| **...**| ... | ... | ... | ... |
| **n+7**| Y | `2` | `[9, 5, 6, 7, 1, 0, 8, 2]` | `true` |
| **n+6**| R | `8` | `[9, 5, 6, 7, 1, 0, 8, -]` | `f(Y)` |
| **n+5**| O | `0` | `[9, 5, 6, 7, 1, 0, -, -]` | `f(R)` |
| **n+4**| M | `1` | `[9, 5, 6, 7, 1, -, -, -]` | `f(O)` |
| **n+3**| D | `7` | `[9, 5, 6, 7, -, -, -, -]` | `f(M)` |
| **n+2**| N | `6` | `[9, 5, 6, -, -, -, -, -]` | `f(D)` |
| **n+1**| E | `5` | `[9, 5, -, -, -, -, -, -]` | `f(N)` |
| **n** | S | `9` | `[9, -, -, -, -, -, -, -]` | `f(E)` |

<br>


 **CB 1** *(Evaluación)*  `8`  `esSumaCorrecta(asignacion)` 

 **CB 2** *(Fallo)*  `< 8`  `false` *(Si bucle agota opciones válidas)* 

 **CR** *(Exploración)*  `< 8`  `f(n+1)` *(Si existe algún dígito válido)* 

<div>


<div align=left>

**Caso recursivo:**

``` java
if (buscarSolucion(indice + 1, asignacion, usados)) {
    return true; 
}
```
[Link al codigo](https://github.com/carlosvaldesbarquin/25-26-EDA2/blob/dfb81c5e1c7cc56424bc0d9be788be05222d772b/entregas/valdesCarlos/src/sendMoreMoney.java#L43-L45)
