package Ajuste_de_Funciones;

public class Main {

        public static void main(String[] args) {
            // Datos de ejemplo: x = variable independiente, y = variable dependiente
            double[] x = {1, 2, 3, 4, 5};
            double[] y = {2.1, 3.9, 6.2, 7.8, 10.1};

            // Calcula la regresión lineal (también imprime los resultados en consola)
            double[] res = RegresionLineal.calcularMinimosCuadrados(x, y);

            // Extrae los resultados del arreglo devuelto
            double beta0 = res[0];   // ordenada al origen
            double beta1 = res[1];   // pendiente
            double r     = res[2];   // coeficiente de Pearson
            double r2    = res[3];   // coeficiente de determinación

            // Valor de X para el cual se quiere predecir Y
            double xNuevo = 6.0;

            // Usa el modelo Y = beta0 + beta1*X para estimar Y
            double yPredicho = RegresionLineal.predecir(beta0, beta1, xNuevo);

            // Muestra la predicción en consola
            System.out.printf("Predicción para X=%.1f: Y = %.4f%n", xNuevo, yPredicho);
        }
}
