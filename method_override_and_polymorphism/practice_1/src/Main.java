import java.lang.Math;

// Класс с перегруженным методом
class Abs {
    // Метод abs
    public static int abs(int a) {
        return Math.abs(a);
    }

    // Перегрузка метода abs типом параметров
    public static double abs(double a) {
        return Math.abs(a);
    }

    // Перегрузка метода abs количеством параметров
    public static double abs(int a, int b) {
        return Math.max(Math.abs(a), Math.abs(b));
    }

}

public class Main {
    public static void main(String[] args) {
        System.out.println(Abs.abs(-2));
        System.out.println(Abs.abs(-2.0));
        System.out.println(Abs.abs(-2, 3));
    }
}