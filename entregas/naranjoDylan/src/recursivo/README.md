### SEND + MORE = MONEY

**Definición de variables:**
**c:** Columna actual (0 = unidades, avanzando de derecha a izquierda).
**r:** Fila actual (índice del sumando).
**S:** Suma acumulada en la columna (incluyendo el acarreo).

---

### 1. Backtracking (SEND+MORE=MONEY)

### Asignación de Valores
| Letra | **D** | **E** | **M** | **N** | **O** | **R** | **S** | **Y** |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **Valor** | 7 | 5 | 1 | 6 | 0 | 8 | 9 | 2 |

### Casos del Algoritmo
**CB (Caso Base):** $c = c_{max}$. Fin del cálculo. Retorna True si no hay acarreo pendiente.
**CR 1 (Procesa Operandos):** $r < r_{max}$. Acumula el valor de la letra y avanza de fila.
**CR 2 (Evalua Resultado):** $r = r_{max}$. Asigna el dígito esperado al resultado y salta a la siguiente columna con el acarreo.

**Análisis recursivo**

| | (c, r, S) | f(c, r, S) |
| :--- | :---: | :---: |
| CB | (5, 0, 0) | True |
| ... | | |
| ... | | |
| CR 1 | (0, 1, 7) | f(0, 2, 12) |
| CR 2 | (0, 2, 12) | f(1, 0, 1) |

 f(1, 0, 1) = **f(c+1, 0, Acarreo)**