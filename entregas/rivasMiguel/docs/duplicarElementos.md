## duplicarElementos

Duplicar cada elemento de una lista (ej. de `[1, 2, 3]` a `[1, 1, 2, 2, 3, 3]`) de forma recursiva.

---

<details>
<summary>Ver análisis recursivo</summary>

<div align="center">

| n     | Lista        | C (Cabeza) | 2C (Duplicado) | f(n-1) (Resto) | f(n)                     |
|-------|--------------|------------|----------------|----------------|--------------------------|
| CB    | []           | —          | —              | —              | []                       |
| n-1   | [3]          | 3          | [3, 3]        | f([])          | [3, 3]                   |
| n     | [2, 3]       | 2          | [2, 2]        | f([3])         | [2, 2, 3, 3]             |
| n+1   | [1, 2, 3]    | 1          | [1, 1]        | f([2, 3])      | [1, 1, 2, 2, 3, 3]       |

- **C** = Cabeza (primer elemento de la lista).  
- **2C** = La cabeza repetida dos veces.  
- **f(n-1)** = Resultado de procesar el resto de la lista (Cola).  

f(n) -> 2C + f(n-1)

</div>

</details>

---

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```plaintext
FUNCION duplicarLista(lista)

    SI longitud(lista) == 0 ENTONCES
        DEVOLVER []
    FIN SI

    C ← primer elemento de lista
    resto ← lista sin el primer elemento

    nuevaCabeza ← [C, C]
    
    DEVOLVER nuevaCabeza + duplicarLista(resto)

FIN FUNCION
 ```

</details>

## Implementación

<details> <summary>Ver código Java</summary>
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicarLista {

    public static List<Integer> f(List<Integer> lista) {
        if (lista.isEmpty()) {
            return new ArrayList<>();
        }

        int c = lista.get(0);
        List<Integer> resto = lista.subList(1, lista.size());

        List<Integer> resultado = new ArrayList<>();
        resultado.add(c);
        resultado.add(c);
        
        resultado.addAll(f(resto));

        return resultado;
    }

    public static void main(String[] args) {
        List<Integer> datos = Arrays.asList(1, 2, 3);
        System.out.println("Original: " + datos);
        System.out.println("Duplicada: " + f(datos));
    }
}
</details>
