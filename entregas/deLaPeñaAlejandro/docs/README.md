## — `SEND + MORE = MONEY`

### Explicación como la haría un alumno

Tenemos:

```text
  S E N D
+ M O R E
---------
M O N E Y
```

Las letras distintas son:

`S, E, N, D, M, O, R, Y`

Eso significa que necesitamos asignar **8 cifras distintas**.

Además, como `SEND` y `MORE` son números de 4 cifras, sus primeras letras no pueden ser 0. Por tanto:

- `S != 0`
- `M != 0`

Si miramos la suma por columnas, de derecha a izquierda:

### Columna 1

```text
D + E = Y  (+ posible acarreo)
```

### Columna 2

```text
N + R + acarreo = E
```

### Columna 3

```text
E + O + acarreo = N
```

### Columna 4

```text
S + M + acarreo = O  (+ nuevo acarreo)
```

### Columna 5

El resultado tiene una cifra más:

```text
acarreo = M
```

Como el acarreo solo puede ser 1 en esta columna, entonces se deduce:

```text
M = 1
```

Eso ya reduce mucho el problema.

Luego, el algoritmo recursivo probaría valores para las demás letras (`S, E, N, D, O, R, Y`), evitando repetir cifras.
Cada vez que tenga suficientes letras asignadas para revisar una columna, comprueba si esa columna cumple la suma.
Si no cumple, deja de seguir por ese camino y vuelve atrás.

Ese “volver atrás” es justo lo importante de la recursividad con backtracking.

### Solución conocida

Una solución válida es:

```text
S = 9
E = 5
N = 6
D = 7
M = 1
O = 0
R = 8
Y = 2
```

Sustituyendo:

```text
  9567
+ 1085
------
 10652
```

Comprobación:

- 7 + 5 = 12, escribo 2 y llevo 1
- 6 + 8 + 1 = 15, escribo 5 y llevo 1
- 5 + 0 + 1 = 6, escribo 6
- 9 + 1 = 10, escribo 0 y llevo 1
- el acarreo final es 1

Resultado:

```text
10652
```

Así que la asignación es correcta.

---

## — Ajuste para `FORTY + TEN + TEN = SIXTY`

### Explicación como la haría un alumno

Ahora el acertijo es:

```text
  F O R T Y
      T E N
+     T E N
-----------
  S I X T Y
```

Aquí las letras distintas son:

`F, O, R, T, Y, E, N, S, I, X`

Son **10 letras distintas**, así que en este caso se usan las 10 cifras del 0 al 9.

Las letras que van al principio de un número no pueden ser 0:

- `F != 0`
- `T != 0`
- `S != 0`

La idea del algoritmo es exactamente la misma que antes. No hace falta inventar otro método. Lo único que cambia es:

1. La lista de letras.
2. La forma de construir los números.
3. La comprobación final:

```text
FORTY + TEN + TEN = SIXTY
```

Es decir:

```text
FORTY + 2 * TEN = SIXTY
```

La gracia del ejercicio es demostrar que el algoritmo recursivo se puede **reutilizar** cambiando solo el problema concreto.

### Una solución válida

Una asignación que funciona es:

```text
F = 2
O = 9
R = 7
T = 8
Y = 6
E = 5
N = 0
S = 3
I = 1
X = 4
```

Sustituyendo:

```text
  29786
    850
+   850
------
  31486
```

Comprobación:

```text
29786 + 850 + 850 = 31486
```

Sí se cumple, así que esta solución es válida.

---

## — Ajuste para `ODD + ODD = EVEN`

### Explicación como la haría un alumno

El tercer acertijo es:

```text
  O D D
+ O D D
--------
E V E N
```

Letras distintas:

`O, D, E, V, N`

Aquí hay menos letras, así que el problema es más pequeño.

Las letras iniciales no pueden ser 0:

- `O != 0`
- `E != 0`

El algoritmo vuelve a ser el mismo. Solo cambian las letras y la ecuación final:

```text
ODD + ODD = EVEN
```

O también:

```text
2 * ODD = EVEN
```

### Deducción rápida por columnas

Si hacemos la suma por columnas:

#### Unidades

```text
D + D = N  (+ posible acarreo)
```

#### Decenas

```text
D + D + acarreo = E  (+ posible acarreo)
```

#### Centenas

```text
O + O + acarreo = V  (+ posible acarreo)
```

#### Millares

```text
acarreo = E
```

Eso significa que `E` tiene que ser 1, porque el acarreo final solo puede ser 1.

### Una solución válida

Una solución correcta es:

```text
O = 6
D = 5
E = 1
V = 3
N = 0
```

Sustituyendo:

```text
  655
+ 655
-----
 1310
```

Y se cumple:

```text
655 + 655 = 1310
```

---

