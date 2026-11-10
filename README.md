Regresión Lineal en Java

Este proyecto agarra unos datos (X, Y), les dibuja la mejor recta posible usando mínimos cuadrados y te dice qué tan bien le quedó. Además, con esa recta puedes predecir el valor de Y para una X nueva.

¿Qué saca el programa?
beta1 (pendiente): cuánto sube Y cada vez que X sube 1.
beta0 (ordenada al origen): cuánto vale Y cuando X es 0.
r (Pearson): qué tanto se parecen tus datos a una línea. Va de -1 a 1; entre más cerca de 1 (o -1), mejor.
r² (determinación): el porcentaje de lo que pasa en Y que el modelo logra explicar.
Predicción: el Y estimado para un valor de X que tú elijas.

Con eso arma la ecuación de la recta:

Y = beta0 + beta1 * X
Fórmulas (las que usa el código)
beta1 = (n·ΣXY − ΣX·ΣY) / (n·ΣX² − (ΣX)²)

beta0 = (ΣY − beta1·ΣX) / n

r     = (n·ΣXY − ΣX·ΣY) / √[(n·ΣX² − (ΣX)²) · (n·ΣY² − (ΣY)²)]

r²    = r · r

Predicción: Y = beta0 + beta1 · X
Archivos
Ajuste_de_Funciones/
├── Main.java             -> aquí pones tus datos y lo ejecutas
└── RegresionLineal.java  -> aquí está toda la matemática
Cómo se usa
Abre Main.java.
Cambia x e y por tus datos (tienen que ser la misma cantidad):
java
double[] x = {1, 2, 3, 4, 5};
double[] y = {2.1, 3.9, 6.2, 7.8, 10.1};
Si quieres predecir, cambia el valor de xNuevo:
java
double xNuevo = 6.0;
Dale run al main y los resultados salen en la consola. Así de fácil.
Qué sale en consola

Con los datos de arriba:

---- RESULTADOS MINIMOS CUADRADOS Y CORRELACION ----
Sumatorias: n=5, X=15.0, Y=30.1, X2=55.0, Y2=220.9, XY=110.2
Pendiente (beta1): 1.9900
Ordenada al origen (beta0): 0.0500
Modelo obtenido: Y = 0.0500 + 1.9900X
Coeficiente de Pearson (r): 0.9987
Coeficiente de Determinacion (r2): 0.9973
Predicción para X=6.0: Y = 11.9900
Traducción a español normal
La recta es Y = 0.05 + 1.99X: por cada punto que sube X, Y sube casi 2.
r = 0.9987: los datos están casi perfectamente alineados.
r² = 0.9973: el modelo explica como el 99.7% de lo que pasa en Y.
Predicción: si X vale 6, el modelo estima que Y vale 11.99.
Lo que devuelve el método

calcularMinimosCuadrados(x, y) además de imprimir, te regresa un arreglo para usar los resultados después (como en el main para predecir):

Posición	Qué es
0	beta0
1	beta1
2	r
3	r²

Y predecir(beta0, beta1, xValor) te regresa el Y estimado para cualquier X.