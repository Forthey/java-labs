public class Main {
    public static void main(String[] args) {
        // Примеры использования перегруженных функций из FindMinMax

        // max
        System.out.println(FindMinMax.max(0, 1));           // 1
        System.out.println(FindMinMax.max(0, 1, 2, 3));   // 3

        // min
        System.out.println(FindMinMax.min(0, 1));           // 0
        System.out.println(FindMinMax.min(0, 1, 2, 3));   // 0
    }
}
