# Eliminar letra de una cadena

Dada una cadena de texto y una letra específica, devolver una nueva cadena donde se hayan eliminado todas las apariciones de dicha letra.

## Análisis recursivo

*(Asumiendo que queremos eliminar la letra 'a')*

<div align=center>

| Tipo    | cadena      | f(cadena) |
|---------|-------------|-----------|
| CB      | ""          | ""        |
| ...     | ...         | ...       |
| CR n-1  | "nana"      | "nn"      |
| CR n    | "banana"    | "bnn"     |

Al quitar las 'a' de "nana" queda "nn"  
Al quitar las 'a' de "banana" queda "bnn"  

"bnn" = "b" + "nn" (porque 'b' no es igual a 'a', así que la conservamos y la sumamos al resultado del resto)  
→ **f(cadena) = primera letra + f(resto de la cadena)** *(