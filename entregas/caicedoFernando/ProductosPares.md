# Productos Pares
- **Problema:** Producto de pares hasta n

| | n | f(n) |
| :--- | :---: | :--- |
| CB | 0 | 1 |
| ... | | |
| ... | | |
| ... | | | 
| CR n-2 | 4 | 8 = 4x2 |
| CR n | 6 | 48 = 6x4x2 |

---
- Código:

``` java
if(numero <= 0){
    return 1;
}


if(numero % 2 != 0){
    return productoPares(numero - 1);
} else{
    return numero * productoPares(n-2);
}

```