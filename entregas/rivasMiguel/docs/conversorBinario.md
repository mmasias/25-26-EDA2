## conversorBinario

Convertir un número decimal $n$ a binario mediante la transformación sucesiva del estado anterior $f(n-1)$.

---

<details>
<summary>Ver análisis recursivo</summary>

<div align="center">

| n | f(n-1) | Proceso         | f(n) |
|---|--------|----------------|------|
| 0 | —      | Caso Base      | ""   |
| 1 | ""     | transformar("") | "1"  |
| 2 | "1"    | transformar("1") | "10" |
| 3 | "10"   | transformar("10") | "11" |
| 4 | "11"   | transformar("11") | "100" |

f(n) -> transformar(f(n-1))

**Lógica interna de `transformar(s)`:**

- Si la cola de `s` es `"0"` → Cabeza + `"1"`  
- Si la cola de `s` es `"1"` → transformar(Cabeza) + `"0"`

</div>

</details>

---

## Pseudocódigo

<details>
<summary>Ver pseudocódigo</summary>

```plaintext
FUNCION binario(n)
    SI n == 0 ENTONCES 
        DEVOLVER ""
    FIN SI

    anterior ← binario(n - 1)
    DEVOLVER transformar(anterior)
FIN FUNCION

FUNCION transformar(cadena)
    SI cadena == "" ENTONCES 
        DEVOLVER "1"
    FIN SI

    cabeza ← cadena sin el último carácter
    cola ← último carácter de cadena

    SI cola == "0" ENTONCES
        DEVOLVER cabeza + "1"
    SI NO
        DEVOLVER transformar(cabeza) + "0"
    FIN SI
FIN FUNCION
 ```

</details>

## Implementación

<details> <summary>Ver código Java</summary>
public class ConversorBinarioIncremental {

    public static String f(int n) {
        if (n == 0) return "";
        
        return transformar(f(n - 1));
    }

    private static String transformar(String s) {
        if (s.isEmpty()) return "1";

        String cabeza = s.substring(0, s.length() - 1);
        char cola = s.charAt(s.length() - 1);

        if (cola == '0') {
            return cabeza + "1";
        } else {
            return transformar(cabeza) + "0";
        }
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println("El binario de " + n + " es: " + f(n));
    }
}
</details>
