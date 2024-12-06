public class Main {
    public static void main(String[] args) {
        // Пример использования перегруженного метода
        System.out.println(MaxValue.max(1, 2));             // 2
        System.out.println(MaxValue.max(1, 2, 3));       // 3
        System.out.println(MaxValue.max(1.3, 2.5));         // 2.5

        // Пример с переопределенным методом
        System.out.println(RedefinedClass.max(1, 2));       // функция выведет hii~ и вернёт 0
        System.out.println(RedefinedClass.max(1, 2, 3)); // 3
        System.out.println(RedefinedClass.max(1.3, 2.5));   // 2.5
    }
}
