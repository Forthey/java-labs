public class RedefinedClass extends MaxValue {
    // Переопределение функции max. Точнее, одной из перегрузок этой функции
    public static int max(int a, int b) {
        System.out.println("hii~");
        return 0;
    }
}
