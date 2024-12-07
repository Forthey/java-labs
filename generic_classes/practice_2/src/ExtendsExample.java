import java.util.List;

public class ExtendsExample {
    // Функция выводит числа, находящихся в ArrayList
    public static void printNumbers(List<? extends Number> numbers) {
        for (Number n : numbers) {
            System.out.println("Number: " + n.toString()); // Доступны методы Number
        }
    }
}
