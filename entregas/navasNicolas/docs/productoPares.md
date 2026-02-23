# Producto de pares hasta n

Calcular el producto de todos los números pares desde 2 hasta n. Por definición, el producto de pares hasta 0 es 1.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|1
CB|1|1
...
...
...
CR n-1|4|8 = 2x4
CR n|6|48 = 2x4x6


48 = 6 x f(n-1) *o lo que es igual* **n * productoPares(n-2)** *(cuando n es par)*

</div>

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION productoPares(n)

    SI n es menor o igual a 0 ENTONCES
        Devolver 1
    FIN SI

    SI n es impar ENTONCES
        Devolver productoPares(n - 1)
    FIN SI

    Devolver n * productoPares(n - 2)

FIN FUNCIÓN
```

</details> 
<details> <summary>Ver código Java</summary>

```
public class ProductoPares {

    public static int calcularProductoPares(int n) {
        if (n <= 0) {
            return 1;
        }
        if (n % 2 != 0) {
            return calcularProductoPares(n - 1);
        }
        return n * calcularProductoPares(n - 2);
    }

    public static void main(String[] args) {
        int numero = 6;
        System.out.println("El producto de pares hasta " + numero + " es: " + calcularProductoPares(numero));
    }
}
```