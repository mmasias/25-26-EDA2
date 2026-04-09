# Reto 002 — Criptaritmética con Recursión

## El problema

Un puzzle criptaritmético asigna una letra diferente a cada dígito del 0–9 de modo
que la operación aritmética escrita con esas letras sea correcta. Por ejemplo:

```
   S E N D
 + M O R E
 ---------
 M O N E Y
```

El reto pide resolver este y otros dos puzzles mediante recursión.

---

## Planteamiento

El algoritmo sigue el patrón backtracking **hacer → explorar → deshacer** del temario,
análogo a `NReinas`: la función `resolver(nivel)` asigna un dígito a la letra `nivel`
igual que `unaSolucion(tablero, columna)` coloca la reina de la columna `columna`.

```text
resolver(nivel):
    si nivel == número de letras  →  comprobar si la suma es correcta (caso base)
    para cada dígito en 0..9:
        si puedeAsignar(nivel, dígito):
            asignacion[nivel] = dígito    // HACER
            digitoUsado[dígito] = true
            si resolver(nivel + 1):
                return true               // propagar éxito
            asignacion[nivel] = -1        // DESHACER
            digitoUsado[dígito] = false
    return false
```

### Poda

La función `puedeAsignar` aplica dos descartes antes de explorar la rama:

| Condición | Descarte |
|-----------|----------|
| `digitoUsado[dígito]` | el dígito ya está asignado a otra letra |
| `esInicial[nivel] && dígito == 0` | ninguna palabra puede empezar por 0 |

---

## Código fuente

- [`src/criptaritmetica.java`](src/criptaritmetica.java) — clase genérica (acepta
  cualquier puzzle como arrays de strings).

---

## Resultados

```
==================================================
Puzzle: SEND + MORE = MONEY
==================================================
D=7  E=5  M=1  N=6  O=0  R=8  S=9  Y=2
  SEND(9567) + MORE(1085) = MONEY(10652)

==================================================
Puzzle: FORTY + TEN + TEN = SIXTY
==================================================
E=5  F=2  I=1  N=0  O=9  R=7  S=3  T=8  X=4  Y=6
  FORTY(29786) + TEN(850) + TEN(850) = SIXTY(31486)

==================================================
Puzzle: ODD + ODD = EVEN
==================================================
D=5  E=1  N=0  O=6  V=3
  ODD(655) + ODD(655) = EVEN(1310)
```

---

## Diseño

La clase `Criptaritmetica` encapsula el estado del puzzle (letras, asignación, dígitos
usados, iniciales) y expone una sola llamada pública `unaSolucion()`. La genericidad
permite resolver cualquier puzzle de suma sin cambiar el algoritmo.

El único `if` de poda (`puedeAsignar`) está separado de la exploración, siguiendo el
mismo criterio de legibilidad que `puedeColocar` en `NReinas`.
