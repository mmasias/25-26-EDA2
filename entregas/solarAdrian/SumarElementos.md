## **Calcular la potencia cuadrada de un valor**

<details>
<summary>Desplegar comportamiento recursivo</summary>
<br>

<div align=center>

| Fase | x | Salida |
| :---: | ---: | :--- |
| **Parada** | 0 | `0` |
| ⋮ | ⋮ | ⋮ |
| **Llamada** x-1 | 4 | `16` = 9 + 8 - 1 |
| **Llamada** x | 5 | `25` = 16 + 10 - 1 |

**Fórmula de recurrencia:** F(5) = F(4) + 2×5 - 1 → potencia_dos(x - 1) + (2 × x) - 1

</div>
</details>

<details>
<summary>Desplegar algoritmo estructurado</summary>

```text
MÓDULO potencia_dos(x)
│
├─ SI x ES IGUAL A 0:
│  └─ DEVOLVER 0
│
└─ SINO:
   └─ DEVOLVER potencia_dos(x - 1) + (2 * x) - 1
```

</details>