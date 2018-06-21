package br.uniriotec.pm20181.util;

public class AreaUtil {
    /**
     * Calcula a área do círculo (Pi * R^2)
     */
    public static double areaCirculo(double diametro) {
        return Math.PI * (Math.pow((diametro / 2), 2));
    }
}
