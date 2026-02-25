## elevarAlCuadrado

Calcular el cuadrado de $n$ de forma recursiva basándose en el cuadrado de $n-1$.

---

<details>
<summary>Ver análisis recursivo</summary>

<div align="center">

| n | f(n-1) | Fórmula                                                                 | f(n) |
|---|--------|-------------------------------------------------------------------------|------|
| 1 | —      | Caso Base                                                               | 1    |
| 2 | 1      | $(\sqrt{f(n-1)} + 1) \times (\sqrt{f(n-1)} + 1)$                       | 4    |
| 3 | 4      | $(\sqrt{f(n-1)} + 1) \times (\sqrt{f(n-1)} + 1)$                       | 9    |
| 4 | 9      | $(\sqrt{f(n-1)} + 1) \times (\sqrt{f(n-1)} + 1)$                       | 16   |
| 5 | 16     | $(\sqrt{f(n-1)} + 1) \times (\sqrt{f(n-1)} + 1)$                       | 25   |

(sqrt{f(n-1)} + 1) x (sqrt{f(n-1)} + 1)

</div>

</details>

---

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```plaintext
FUNCION elevarAlCuadrado(n)

    SI n == 1 ENTONCES
        DEVOLVER 1
    FIN SI

    anterior ← elevarAlCuadrado(n - 1)

    DEVOLVER (raiz(anterior) + 1) * (raiz(anterior) + 1)

FIN FUNCION
```

</details>

## Implementación

<details> <summary>Ver código Java</summary>
import java.lang.Math;

public class CuadradoRecursivo {

    public static double f(int n) {
        if (n == 1) {
            return 1;
        }

        double anterior = f(n - 1);

        return (Math.sqrt(anterior) + 1) * (Math.sqrt(anterior) + 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("El cuadrado de " + n + " es: " + (int) f(n));
    }
}
</details>
