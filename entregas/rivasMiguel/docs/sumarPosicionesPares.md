## sumarPosicionesPares

Sumar los elementos que se encuentran en las posiciones pares de una lista  
(considerando la primera posición como par / índice 0 según el estado inicial de `i`).

---

<details>
<summary>Ver análisis recursivo</summary>

<div align="center">

| n (Elemento) | i (Estado) | Acción                                      | f(n-1) (Resto) | f(n) (Suma)        |
|--------------|------------|---------------------------------------------|----------------|--------------------|
| CB           | —          | —                                           | —              | 0                  |
| 10           | falso      | Sumar (i → verdadero)                      | f(n-1) + 10    | 10 + f(n-1)        |
| 20           | verdadero  | Saltar (i → falso)                         | f(n-1)         | f(n-1)             |
| 30           | falso      | Sumar (i → verdadero)                      | f(n-1) + 30    | 30 + f(n-1)        |

- **n** = Elemento actual (Cabeza).  
- **i** = Interruptor de posición (flag booleano).  
- **f(n-1)** = Suma del resto de la lista.  

Si (i = falso) -> (i = verdadero) & f(n-1) + n

Si (i = verdadero) -> (i = falso) & f(n-1)

</div>

</details>

---

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```plaintext
FUNCION sumarPares(lista, i)

    SI longitud(lista) == 0 ENTONCES
        DEVOLVER 0
    FIN SI

    n ← primer elemento de lista
    resto ← lista sin el primer elemento

    SI i == falso ENTONCES
        DEVOLVER n + sumarPares(resto, verdadero)
    SI NO
        DEVOLVER sumarPares(resto, falso)
    FIN SI

FIN FUNCION
 ```

</details>

## Implementación

<details> <summary>Ver código Java</summary>
import java.util.Arrays;
import java.util.List;

public class SumaPosicionesPares {

    public static int f(List<Integer> lista, boolean i) {
        if (lista.isEmpty()) {
            return 0;
        }

        int n = lista.get(0);
        List<Integer> resto = lista.subList(1, lista.size());

        if (!i) {
            return n + f(resto, true);
        } else {
            return f(resto, false);
        }
    }

    public static void main(String[] args) {
        List<Integer> datos = Arrays.asList(10, 20, 30, 40, 50);

        System.out.println("Suma de posiciones pares: " + f(datos, false));
    }
}
</details>
