# Traza de Algoritmo

## Trazas sobre diversos elementos

**Cantidad de Comprobaciones:**

- **Mejor Caso**: 1-7 comprobaciones
- **Caso Promedio**: 10 - 20 comprobaciones
- **Peor Caso**: 30 - 40 comprobaciones (Máximo)

<details>

<summary><b>Ver Traza sobre el elemento "22"</b></summary>

```java
 -> 2   5   9  14  21
    4   7  11  17  25
    8  12  15  20  30
   13  18  22  27  35
   19  24  28  33  40
```

- Fila 1: Rango [2, 21].

    - 22 < 2? No (1 comp).

    - 22 > 21? SÍ (1 comp).

- Acción: Descarta la fila. 

- **Acumulado: 2**

```java
-> 4   7  11  17  25
   8  12  15  20  30
  13  18  22  27  35
  19  24  28  33  40
```

- Fila 2: Rango [4, 25].

    - 22 < 4? No (1 comp).

    - 22 > 25? No (1 comp).

- Acción: Entra en Binaria.

    - la mitad es 11. 
    
    ```java 
    11 17 25
    ```
    - ¿22 == 11? No (1 comp). ¿22 > 11? Sí (1 comp).

    - la mitad es 17. 
    
    ```java 
    17 25
    ```
    - ¿22 == 17? No (1 comp). ¿22 > 17? Sí (1 comp).

    - la mitad es 25. 
    
    ```java 
    25
    ```
    
    ¿22 == 25? No (1 comp). ¿22 > 25? No (1 comp).

- **Acumulado: 10.**

```java
-> 8  12  15  20  30
   13  18  22  27  35
   19  24  28  33  40
```

- Fila 3: Rango [8, 30].

    - 22 < 8? No (1 comp).

    - 22 > 30? No (1 comp).

- Acción: Entra en Binaria.

    - La mitad es 15.
    
    ```java
    15  20  30
    ```
    - ¿22 == 15? No (1 comp). ¿22 > 15? Sí (1 comp).

    - La mitad es 20

    ```java
    20  30
    ```
    - ¿22 == 20? No (1 comp). ¿22 > 20? Sí (1 comp).
    - La mitad es 30.
    ```java 
    30
    ```
    - ¿22 == 30? No (1 comp). ¿22 > 30? No (1 comp).

- **Acumulado: 18.**

---

```java
 -> 13  18  22  27  35
    19  24  28  33  40
```

- Fila 4: Rango [13, 35].

    - 22 < 13? No (1 comp).

    - 22 > 35? No (1 comp).

- Acción: Entra en Binaria.

    - La mitad es 22

    ```java
    22  27  35
    ```
    - ¿22 == 22? **SÍ (1 comp).**

- **Resultado: ¡ENCONTRADO!**
- **Acumulado Final: 19 comparaciones.**

</details>

<details>
<summary><b>Ver Traza sobre el Peor Caso (elemento "19")</b></summary>

```java
 -> 2   5   9  14  21
    4   7  11  17  25
    8  12  15  20  30
   13  18  22  27  35
   19  24  28  33  40
```

- **Fila 1: Rango [2, 21].**

    - 19 < 2? No (1 comp).

    - 19 > 21? No (1 comp).

- Acción: Entra en Binaria.

    - Mitad es 9. 

    ```java
    9  14  21
    ```
    
    - ¿19 == 9? No (1 comp). ¿19 > 9? Sí (1 comp).

    - Mitad es 14. 

    ```java
    14  21
    ```

    - ¿19 == 14? No (1 comp). ¿19 > 14? Sí (1 comp).

    - Mitad es 21. 
    
    ```java
    21
    ```
    
    - ¿19 == 21? No (1 comp). ¿19 > 21? No (1 comp).

- **Acumulado: 8**

```java
-> 4   7  11  17  25
   8  12  15  20  30
  13  18  22  27  35
  19  24  28  33  40
```

- **Fila 2: Rango [4, 25].**

    - 19 < 4? No (1 comp).

    - 19 > 25? No (1 comp).

- Acción: Entra en Binaria.

    - Mitad es 11.

    ```java
    11  17  25
    ```
    
    - ¿19 == 9? No (1 comp). ¿19 > 9? Sí (1 comp).

    - Mitad es 17. 

    ```java
    17  25
    ```

    - ¿19 == 17? No (1 comp). ¿19 > 17? Sí (1 comp).

    - Mitad es 25. 
    
    ```java
    25
    ```
    
    - ¿19 == 25? No (1 comp). ¿19 > 25? No (1 comp).

- **Acumulado: 16**

```java
-> 8  12  15  20  30
   13  18  22  27  35
   19  24  28  33  40
```

- **Fila 3: Rango [8, 30].**

    - 19 < 8? No (1 comp).

    - 19 > 30? No (1 comp).

- Acción: Entra en Binaria.

    - Mitad es 15.

    ```java
    8  12  15  20  30
    ```
    
    - ¿19 == 15? No (1 comp). ¿19 > 15? Sí (1 comp).

    - Mitad es 20. 

    ```java
    15  20  30
    ```

    - ¿19 == 20? No (1 comp). ¿19 > 20? No (1 comp).

    - Mitad es 12. 
    
    ```java
    8  12  15 
    ```
    
    - ¿19 == 12? No (1 comp). ¿19 > 12? Sí (1 comp).

- **Acumulado: 24**

```java
-> 13  18  22  27  35
   19  24  28  33  40
```

- **Fila 4: Rango [13, 35].**

    - 19 < 13? No (1 comp).

    - 19 > 35? No (1 comp).

- Acción: Entra en Binaria.

    - Mitad es 22.

    ```java
    13  18  22
    ```
    
    - ¿19 == 22? No (1 comp). ¿19 > 22? No (1 comp).

    - Mitad es 18. 

    ```java
    18  22
    ```

    - ¿19 == 18? No (1 comp). ¿19 > 18? Sí (1 comp).

- **Acumulado: 30**

```java
-> 19  24  28  33  40
```

- **Fila 5: Rango [19, 40].**

    - 19 < 19? No (1 comp).
    
    - 19 > 40? No (1 comp).

- Acción: Entra en Binaria.

    - Mitad es 28.

    - ¿19 == 28? No (1 comp). ¿19 > 28? No (1 comp).

    ```java
    19  24
    ```

    - Mitad es 19.

- **Resultado: ENCONTRADO en la última fila**
- **Acumulado final: 35 comparaciones**

</details>

<details>

<summary><b>Ver Traza sobre el elemento "21"</b></summary>

```java
 -> 2   5   9  14  21
    4   7  11  17  25
    8  12  15  20  30
   13  18  22  27  35
   19  24  28  33  40
```

- **Fila 1: Rango [2, 21].**

    - 21 < 2? No (1 comp).

    - 22 > 21? No (1 comp).

- Acción: Entra en binaria. 

    - Mitad es 9.

    ```java
    9  14  21
    ```

    - ¿21 == 9? No (1 comp). ¿21 > 9? Sí (1 comp).

    - Mitad es 14.

    ```java
    14  21
    ```

    - ¿21 == 14? No (1 comp). ¿21 > 14? Sí (1 comp).

    - Mitad es 21.

    ```java
    21
    ```

    - **¿21 == 21? SÍ (1 comp).**

- **Resultado: ENCONTRADO**
- **Acumulado Final: 7 comparaciones.**

</details>

<details>

<summary><b>Ver Traza sobre el elemento "16"</b></summary>

```java
 -> 2   5   9  14  21
    4   7  11  17  25
    8  12  15  20  30
   13  18  22  27  35
   19  24  28  33  40
```
- **Fila 1: Rango [2, 21].**

    - 16 < 2? No (1 comp).

    - 16 > 21? No (1 comp).

- Acción: Entra en Binaria.

    - La mitad es 9. ¿16 == 9? No (1 comp). ¿16 > 9? Sí (1 comp).

    ```java
    9  14  21
    ```

    - La mitad es 14. ¿16 == 14? No (1 comp). ¿16 > 14? Sí (1 comp).

    ```java
    14  21
    ```

    - La mitad es 21. ¿16 == 21? No (1 comp). ¿16 > 21? No (1 comp).
    
    ```java
    21
    ```

- **Acumulado: 8.**

```java
-> 4   7  11  17  25
   8  12  15  20  30
  13  18  22  27  35
  19  24  28  33  40
```

- **Fila 2: Rango [4, 25].**

    - 16 < 4? No (1 comp).

    - 16 > 25? No (1 comp).

- Acción: Entra en Binaria.

    - La mitad es 11. ¿16 == 11? No (1 comp). ¿16 > 11? Sí (1 comp).

    ```java
    11  17  25
    ```

    - La mitad es 17. ¿16 == 17? No (1 comp). ¿16 > 17? No (1 comp). (El rango se cruza, no hay más elementos).

- **Acumulado: 14.**

```java
-> 8  12  15  20  30
   13  18  22  27  35
   19  24  28  33  40
```
- **Fila 3: Rango [8, 30].**

    - 16 < 8? No (1 comp).

    - 16 > 30? No (1 comp).

- Acción: Entra en Binaria.

    - La mitad es 15. ¿16 == 15? No (1 comp). ¿16 > 15? Sí (1 comp).

    ```java
    15  20  30
    ```

    - La mitad es 20. ¿16 == 20? No (1 comp). ¿16 > 20? No (1 comp). (El rango se cruza).

- **Acumulado: 20.**

```java
-> 13  18  22  27  35
   19  24  28  33  40
```

- **Fila 4: Rango [13, 35].**

    - 16 < 13? No (1 comp).

    - 16 > 35? No (1 comp).

- Acción: Entra en Binaria.

    - La mitad es 22. ¿16 == 22? No (1 comp). ¿16 > 22? No (1 comp).

    ```java
    13  18  22
    ```

    - La mitad es 18. ¿16 == 18? No (1 comp). ¿16 > 18? No (1 comp).

    ```java
    13  18
    ```

    - La mitad es 13. ¿16 == 13? No (1 comp). ¿16 > 13? Sí (1 comp).

- **Acumulado: 28.**

```java
-> 19  24  28  33  40
```

- **Fila 5: Rango [19, 40].**

    - 16 < 19? SÍ (1 comp).

- Acción: Descarta la fila porque todos los elementos serán mayores.

- **Resultado: NO ENCONTRADO en la matriz.**

- **Acumulado Final: 29 comparaciones.**

</details>