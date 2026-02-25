
---

## contar_cifras.md

```markdown
# contarCifrasNumero

Ver cuántas cifras tiene un número entero positivo.

## Análisis recursivo

<div align=center>

| Tipo    | n    | f(n) |
|---------|-----:|-----:|
| CB      | 9    | 1    |
| ...     | ...  | ...  |
| CR n-1  | 972  | 3    |
| CR n    | 9721 | 4    |

9721 tiene 4 cifras  
972 tiene 3 cifras  

4 = 1 + 3  
→ **f(n) = 1 + f(n-1)**  
(donde *n-1* es el número sin su última cifra)

</div>

## Pseudocódigo

```text
FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        Resultado = 1
    SINO
        Resultado = 1 + contarCifras(n / 10)
    FIN SI

    Devolver Resultado

FIN FUNCIÓN