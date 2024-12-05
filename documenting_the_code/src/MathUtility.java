/**
 * Класс, содержащий в себе полезные математические операции
 */
public class MathUtility {
    private MathUtility() {}

    /**
     * Функция считает модуль числа
     * @param value число
     * @return модуль числа value
     */
    public static double abs(double value) {
        return value > 0.0 ? value : -value;
    }

    /**
     * Функция возводит число в целую неотрицательную степень
     * @param x число
     * @param n степень
     * @return x ^ n
     * @throws IllegalArgumentException если n меньше 0
     */
    public static double pow(double x, int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        double result = 1.0;

        for (int i = 0; i < n; i++) {
            result *= x;
        }

        return result;
    }

    /**
     * Функция считает корень
     * @param x число под корнем
     * @param n степень корня
     * @param epsilon нужная точность
     * @throws IllegalArgumentException если x отрицательные, степень корня меньше 1 или заданная точность меньше 0
     * @return корень из x n-й степени с точностью epsilon
     */
    public static double sqrt(double x, int n, double epsilon) throws IllegalArgumentException {
        if (x < 0.0 || n < 1 || epsilon < 0) {
            throw new IllegalArgumentException();
        }

        double x0 = x, x1 = 0;

        while (MathUtility.abs(x1 - x0) > epsilon) {
            x0 = x1;
            x1 = (n * x1 + x / MathUtility.pow(x1, n)) / (n + 1);
        }

        return x1;
    }
}