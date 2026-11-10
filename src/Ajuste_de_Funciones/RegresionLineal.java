package Ajuste_de_Funciones;

public class RegresionLineal {

    // Calcula la recta de mínimos cuadrados (Y = beta0 + beta1*X) y el coeficiente de correlación.
    // Retorna un arreglo con: {beta0, beta1, pearsonR, r2}
    public static double[] calcularMinimosCuadrados(double[] x, double [] y) {

        // Validación: ambos arreglos deben tener el mismo tamaño y no estar vacíos
        if (x.length != y.length || x.length == 0 ){
            System.out.println("Error: los arreglos deben tener el mismo tamaño y no estar vacios.");
            return new double[]{0.0, 0.0, 0.0, 0.0};
        }

        int n = x.length;// número de datos

        // Variables para las sumatorias necesarias
        double sumX = 0, sumY = 0, sumX2 = 0, sumY2 = 0, sumXY = 0;

        // Recorre los datos acumulando las sumatorias: ΣX, ΣY, ΣX², ΣY², ΣXY
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumX2 += x[i] * x[i];
            sumY2 += y[i] * y[i];
            sumXY += x[i] * y[i];
        }

        // Pendiente de la recta: beta1 = (nΣXY - ΣXΣY) / (nΣX² - (ΣX)²)
        double beta1 = (n * sumXY - sumX * sumY) / (n * sumX2 - (sumX * sumX));

        // Ordenada al origen: beta0 = (ΣY - beta1·ΣX) / n
        double beta0 = (sumY - beta1 * sumX) / n;

        // Coeficiente de correlación de Pearson (r), indica la fuerza de la relación lineal (-1 a 1)
        double pearsonR = (n * sumXY - sumX * sumY) / Math.sqrt((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY));

        // Coeficiente de determinación (r²), porcentaje de la variación de Y explicada por el modelo
        double r2 = pearsonR * pearsonR;

        // Impresión de resultados en consola
        System.out.println("---- RESULTADOS MINIMOS CUADRADOS Y CORRELACION ----");
        System.out.printf("Sumatorias: n=%d, X=%.1f, Y=%.1f, X2=%.1f, Y2=%.1f, XY=%.1f%n",
                n, sumX, sumY, sumX2, sumY2, sumXY);
        System.out.printf("Pendiente (beta1): %.4f%n", beta1);
        System.out.printf("Ordenada al origen (beta0): %.4f%n", beta0);
        System.out.printf("Modelo obtenido: Y = %.4f + %.4fX%n", beta0, beta1);
        System.out.printf("Coeficiente de Pearson (r): %.4f%n", pearsonR);
        System.out.printf("Coeficiente de Determinacion (r2): %.4f%n", r2);

        // Devuelve los resultados: índice 0 = beta0, 1 = beta1, 2 = r, 3 = r²
        return new double[]{beta0, beta1, pearsonR, r2};

    }

    // Predice el valor de Y para un valor dado de X usando el modelo: Y = beta0 + beta1*X
    public static double predecir(double beta0, double beta1, double xValor){
        return beta0 + beta1 * xValor;
    }
}
