## reemplazarCaracter

Sustituir todas las apariciones de un carácter específico ($R$) por uno nuevo ($N$) de forma recursiva.

---

<details>
<summary>Ver análisis recursivo</summary>

<div align="center">

| n     | Palabra | C (Cabeza) | f(n-1) (Resto) | f(n) (si R='a', N='x') |
|-------|----------|------------|----------------|------------------------|
| CB    | ""       | —          | —              | ""                     |
| n-1   | "a"      | 'a'        | ""             | "x"                    |
| n     | "ba"     | 'b'        | f("a")         | "bx"                   |
| n+1   | "aba"    | 'a'        | f("ba")        | "xbx"                  |

- **R** = Carácter a reemplazar  
- **C** = Carácter actual (Cabeza)  
- **N** = Carácter reemplazador  
- **f(n-1)** = Resultado de procesar el resto de la palabra (Cola)  

Si (C = R) -> N + f(n-1)\
Si (C != R) -> C + f(n-1)

</div>

</details>

---

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```plaintext
FUNCION reemplazarCaracter(cadena, R, N)

    SI cadena es vacía ENTONCES
        DEVOLVER ""
    FIN SI

    C ← primer carácter de cadena
    resto ← cadena sin el primer carácter

    SI C == R ENTONCES
        DEVOLVER N + reemplazarCaracter(resto, R, N)
    SI NO
        DEVOLVER C + reemplazarCaracter(resto, R, N)
    FIN SI

FIN FUNCION
```
</details> 

## Implementación

<details> <summary>Ver código Java</summary>
public class ReemplazarCaracter {

    public static String f(String cadena, char r, char n) {
        if (cadena.isEmpty()) {
            return "";
        }

        char c = cadena.charAt(0);
        String resto = cadena.substring(1);

        if (c == r) {
            return n + f(resto, r, n);
        } else {
            return c + f(resto, r, n);
        }
    }

    public static void main(String[] args) {
        String frase = "casa";
        char viejo = 'a';
        char nuevo = 'o';
        System.out.println("Resultado: " + f(frase, viejo, nuevo));
    }
}
</details>
