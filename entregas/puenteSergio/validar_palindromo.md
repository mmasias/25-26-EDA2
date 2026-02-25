# Validar palíndromo
Comprobar si una palabra se lee igual de izquierda a derecha que de derecha a izquierda.
## Análisis recursivo
(Ejemplo con la palabra "radar")
<div align=center>
| Tipo    |  cadena | f(cadena) |
|---------|--------:|----------:|
| CB      |     "d" | Verdadero |
| ...     |     ... |       ... |
| CR n-1  |   "ada" | Verdadero |
| CR n    | "radar" | Verdadero |
Verdadero = ('r' == 'r') Y Verdadero → (primera == ultima) Y f(medio)
</div>
## Pseudocódigo
```text
FUNCION esPalindromo(cadena)

    SI longitud(cadena) <= 1 ENTONCES

        Devolver Verdadero

    SINO

        primera = primera letra de cadena
        ultima = ultima letra de cadena
        medio = cadena sin primera ni ultima letra

        SI primera == ultima ENTONCES

            Devolver esPalindromo(medio)

        SINO

            Devolver Falso

        FIN SI

    FIN SI

FIN FUNCIÓN
```