## validarPalindromo

Determinar si una palabra o frase se lee igual de izquierda a derecha que de derecha a izquierda.

---

<details>
<summary>Ver análisis recursivo</summary>

<div align="center">

| n     | Palabra      | Cabeza | Cola | f(n-1) (Interior) | Resultado |
|-------|--------------|--------|------|-------------------|-----------|
| CB    | "a" o ""     | —      | —    | —                 | Verdadero |
| n-1   | "aba"        | 'a'    | 'a'  | f("b")            | Verdadero |
| n     | "radar"      | 'r'    | 'r'  | f("ada")          | Verdadero |
| n+1   | "java"       | 'j'    | 'a'  | —                 | Falso     |

**Tu razonamiento:**

- **Cabeza** = Primer carácter de la cadena.  
- **Cola** = Último carácter de la cadena.  
- **f(n-1)** = El resto de la palabra tras quitar cabeza y cola.  

Si (Cabeza = Cola) -> f(n-1)\
Si (Cabeza != Cola) -> falso

</div>

</details>

---

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```plaintext
FUNCION esPalindromo(cadena)

    SI longitud(cadena) <= 1 ENTONCES
        DEVOLVER verdadero
    FIN SI

    Cabeza ← primer carácter de cadena
    Cola ← último carácter de cadena
    Interior ← cadena sin el primer ni el último carácter

    SI Cabeza == Cola ENTONCES
        DEVOLVER esPalindromo(Interior)
    SI NO
        DEVOLVER falso
    FIN SI

FIN FUNCION
 ```

</details>

## Implementación

<details> <summary>Ver código Java</summary>
public class PalindromoRecursivo {

    public static boolean f(String cadena) {
        if (cadena.length() <= 1) {
            return true;
        }

        char cabeza = cadena.charAt(0);
        char cola = cadena.charAt(cadena.length() - 1);

        if (cabeza == cola) {
            String interior = cadena.substring(1, cadena.length() - 1);
            return f(interior);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String palabra = "reconocer";
        System.out.println("¿Es '" + palabra + "' un palíndromo?: " + f(palabra));
    }
}
</details>
