# Búsqueda en Matriz Ordenada

## 2Think

### 1. Algoritmo propuesto

**Descripción del algoritmo:**  
Se utiliza el algoritmo de **búsqueda en escalera** (staircase search) comenzando desde la **esquina superior derecha** (posición `[0][4]`).  

- Si `matriz[fila][columna] == k` → se encontró el valor.  
- Si `matriz[fila][columna] > k` → mover a la **izquierda** (disminuye el valor).  
- Si `matriz[fila][columna] < k` → mover **abajo** (aumenta el valor).  

Este algoritmo minimiza el número de comparaciones al eliminar una fila o una columna en cada paso.

**Trazado buscando el valor 22:**  
- `(0,4) = 21` → `< 22` → abajo  
- `(1,4) = 25` → `> 22` → izquierda  
- `(1,3) = 17` → `< 22` → abajo  
- `(2,3) = 20` → `< 22` → abajo  
- `(3,3) = 27` → `> 22` → izquierda  
- `(3,2) = 22` → **Encontrado**  

**Total: 6 comparaciones**

---

### 2. Mejor y peor caso

- **Mejor caso:** **1 comparación**  
  Ocurre cuando `k = 21` (posición inicial).

- **Peor caso:** **9 comparaciones**  
  **Ejemplo:** `k = 19`  
  Ruta: 21 → 14 → 17 → 20 → 15 → 22 → 18 → 24 → **19**

---

### 3. ¿Existe un algoritmo con menos comparaciones en el peor caso?

**No.**  
Este algoritmo es óptimo. En una matriz de *m* filas y *n* columnas ordenada por filas y columnas, cualquier algoritmo basado solo en comparaciones requiere **Ω(m + n)** comparaciones en el peor caso. El algoritmo propuesto alcanza exactamente ese límite teórico.

---

## 2Think²

### 1. Prueba buscando 21

- `(0,4) = 21` → **Encontrado**  
**Comparaciones:** 1 (mejor caso)

### 2. Prueba buscando 16

- `(0,4)=21` → `>` → izq → `(0,3)=14` → `<` → abajo → `(1,3)=17` → `>` → izq → `(1,2)=11` → `<` → abajo → `(2,2)=15` → `<` → abajo → `(3,2)=22` → `>` → izq → `(3,1)=18` → `>` → izq → `(3,0)=13` → `<` → abajo → `(4,0)=19` → `>` → izq → **Fuera de límites**  
**Resultado:** No encontrado  
**Comparaciones:** 9

### 3. ¿Es mejor arrancar del centro en algún caso?

**Sí.**  
Aunque el peor caso teórico sigue siendo O(m+n), empezar desde el centro puede reducir el número de comparaciones **en promedio** y en ciertos casos concretos.

**Ejemplo:** Buscar `k = 28`  
- Desde esquina superior derecha: ≈ 7 comparaciones  
- Desde el centro `(2,2)=15`: ≈ 4 comparaciones

---

## 2Think³ - Código

```java
public class BusquedaMatriz {
    
    public static boolean buscar(int[][] matriz, int k) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return false;
        }
        
        int m = matriz.length;
        int n = matriz[0].length;
        int fila = 0;
        int columna = n - 1;
        int comparaciones = 0;
        
        while (fila < m && columna >= 0) {
            comparaciones++;
            if (matriz[fila][columna] == k) {
                System.out.println("Encontrado en [" + fila + "][" + columna + "] - " + comparaciones + " comparaciones");
                return true;
            } else if (matriz[fila][columna] > k) {
                columna--;  // izquierda
            } else {
                fila++;     // abajo
            }
        }
        
        System.out.println("No encontrado - " + comparaciones + " comparaciones");
        return false;
    }
    
    public static void main(String[] args) {
        int[][] matriz = {
            {2, 5, 9, 14, 21},
            {4, 7, 11, 17, 25},
            {8, 12, 15, 20, 30},
            {13, 18, 22, 27, 35},
            {19, 24, 28, 33, 40}
        };
        
        buscar(matriz, 22);
        buscar(matriz, 21);
        buscar(matriz, 16);
        buscar(matriz, 19);
        buscar(matriz, 40);
        buscar(matriz, 100);
    }
}