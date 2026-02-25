# Conversor a binario

Convertir un número decimal a binario.

## Analisis recursivo

<div align=center>

||n|f(n)|
|-|-|-|
CB|0|"0"|
CR|5|"101"|

</div>

Se divide entre 2 y se concatena el resto.

## Pseudocódigo

```text
FUNCION binario(n)

    SI n < 2 ENTONCES
        Devolver n
    FIN SI

    Devolver binario(n / 2) + (n % 2)

FIN FUNCIÓN