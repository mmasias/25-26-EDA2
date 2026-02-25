## contarCifras

Contar la cantidad de dígitos de un número entero de forma recursiva.

---

<details>
<summary>Ver análisis recursivo</summary>

<div align="center">

| n     | f(n-1) | Fórmula            | f(n) |
|-------|--------|--------------------|------|
| 0–9   | —      | Caso Base          | 1    |
| 12    | 1      | f(n-1) + 1         | 2    |
| 123   | 2      | f(n-1) + 1         | 3    |
| 1234  | 3      | f(n-1) + 1         | 4    |
| 12345 | 4      | f(n-1) + 1         | 5    |

f(n-1) + 1

</div>

</details>

---

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```plaintext
FUNCION contarCifras(n)

    SI n < 10 ENTONCES
        DEVOLVER 1
    FIN SI

    DEVOLVER contarCifras(n / 10) + 1

FIN FUNCION

Implementación
<details> <summary>Ver código Java</summary>
public class ContadorCifras {

    public static int f(int n) {
        if (n < 10 && n > -10) {
            return 1;
        }

        return f(n / 10) + 1;
    }

    public static void main(String[] args) {
        int numero = 12345;
        System.out.println("Cifras de " + numero + ": " + f(numero));
    }
}
</details>
