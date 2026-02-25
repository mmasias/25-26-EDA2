## eliminarCaracter

Eliminar todas las apariciones de un carácter específico (R) en una cadena de forma recursiva.

---

<details>
<summary>Ver análisis recursivo</summary>

<div align="center">

| n     | Palabra | C (Cabeza) | f(n-1) (Resto) | f(n) |
|-------|----------|------------|----------------|------|
| CB    | ""       | —          | —              | ""   |
| n-1   | "a"      | 'a'        | ""             | "" (si R = 'a') |
| n     | "ba"     | 'b'        | f("a")         | "b"  |
| n+1   | "aba"    | 'a'        | f("ba")        | "b"  |

**Tu razonamiento:**

- **R** = Carácter a remover  
- **C** = Carácter actual (Cabeza)  


Si (C = R) -> f(n-1)\
Si (C != R) -> C + f(n-1)

</div>

</details>

---

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```plaintext
FUNCION eliminarCaracter(cadena, R)

    SI cadena es vacía ENTONCES
        DEVOLVER ""
    FIN SI

    C ← primer carácter de cadena
    resto ← cadena sin el primer carácter

    SI C == R ENTONCES
        DEVOLVER eliminarCaracter(resto, R)
    SI NO
        DEVOLVER C + eliminarCaracter(resto, R)
    FIN SI

FIN FUNCION
```

</details>

## Implementación

<details> <summary>Ver código Java</summary>
public class EliminarCaracter {

    public static String f(String cadena, char r) {
        if (cadena.isEmpty()) {
            return "";
        }

        char c = cadena.charAt(0);
        String resto = cadena.substring(1);

        if (c == r) {
            return f(resto, r);
        } else {
            return c + f(resto, r);
        }
    }

    public static void main(String[] args) {
        String palabra = "banana";
        char remover = 'a';
        System.out.println("Resultado: " + f(palabra, remover));
    }
}
</details>
