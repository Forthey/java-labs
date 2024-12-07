public class FindMinMax {
    // Функция, возвращающая максимум от двух элементов, которые обязательно сравнимы (реализуют Comparable)
    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    // Функция, возвращающая максимум от некоторого числа элементов, которые обязательно сравнимы (реализуют Comparable)
    public static <T extends Comparable<T>> T max(T... values) {
        if (values.length == 0) return null;

        T maxValue = values[0];
        for (T value : values) {
            maxValue = max(maxValue, value);
        }
        return maxValue;
    }

    // Функция, возвращающая минимум от двух элементов, которые обязательно сравнимы (реализуют Comparable)
    public static <T extends Comparable<T>> T min(T a, T b) {
        return a.compareTo(b) <= 0 ? a : b;
    }

    // Функция, возвращающая минимум от некоторого числа элементов, которые обязательно сравнимы (реализуют Comparable)
    public static <T extends Comparable<T>> T min(T... values) {
        T minValue = values[0];
        for (T value : values) {
            minValue = min(minValue, value);
        }
        return minValue;
    }
}
