public class MaxValue {
    // Функция max - возвращает максимальное из двух чисел
    public static int max(int a, int b) {
        return a >= b ? a : b;
    }

    // Функции max перегружена количеством аргументов
    public static int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    // Функции max перегружена типом аргументов
    public static double max(double a, double b) {
        return a >= b ? a : b;
    }
}
