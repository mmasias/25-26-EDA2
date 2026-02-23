# Cifras de un número
- **Problema:** Contar las cifras de un número
- **Caso base:** n < 10 -> Devuelve 1.
    - Si el número es menor que 10 (es decir, va del 0 al 9), sabemos directamente que tiene exactamente 1 cifra. Aquí detenemos la recursividad.
- **Caso recursivo:** - Para acercarnos al caso base, tenemos que ir "cortando" el número cifra por cifra.
    - Esto lo logramos dividiendo el número entre 10 (división entera).
    - Sumamos 1 (que representa la cifra que acabamos de "cortar") y llamamos a la recursividad con lo que queda del número.
    - **Estructura lógica:** 1 + f(n / 10)

- **Traza paso a paso asumiendo n = 456:**
    - f(456) -> Cortamos el 6: 1 + f(45)
    - f(45)  -> Cortamos el 5: 1 + f(4)
    - f(4)   -> Caso base (4 < 10), devuelve 1
    - **Resolución:**
    - Se suman los resultados hacia atrás: 1 + 1 + 1 = 3.



| | n | f(n) |
| :--- | :---: | :--- |
| CB | 4 | 1 |
| ... | | |
| CR n/10 | 45 | 2 = 1 + 1 |
| CR n | 456 | 3 = 1 + 2 |




