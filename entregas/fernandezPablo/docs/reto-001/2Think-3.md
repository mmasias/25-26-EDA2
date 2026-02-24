## 3. Elevar n al cuadrado

Calcula el cuadrado de `n` de forma recursiva sumando el n-ésimo número impar al cuadrado anterior.

<details>
<summary>Ver análisis recursivo</summary>

| | n | f(n) |
| :--- | :--- | :--- |
| **CB** | 0 | 0 |
| ... | | |
| **CR n-1**| 2 | 4 = 1 + 3 |
| **CR n** | 3 | 9 = 4 + 5 |

`9 = f(n-1) + 5 o lo que es igual calcularCuadrado(n - 1) + (2 * n - 1)`

</details>

### 🔗 Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION calcularCuadrado(n)
    SI n == 0 ENTONCES
        Devolver 0
    FIN SI
    
    Devolver calcularCuadrado(n - 1) + (2 * n - 1)
FIN FUNCION