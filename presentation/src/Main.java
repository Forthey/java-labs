import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Примеры с простейшей реализацией
        int[] numbers = {1, 2, 3, 4, 5};
        var collection = new CustomCollection(numbers);

        System.out.println("Явное использование итератора");

        Iterator<Integer> iter = collection.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("Цикл foreach");

        for (int number : collection) {
            System.out.println(number);
        }

        // Примеры с собственным списком
        System.out.println("Пример со списком:");

        CustomList<Integer> listNumbers = new CustomList<>();

        listNumbers.add(3);
        listNumbers.add(2);
        listNumbers.add(1);

        for (int number : listNumbers) {
            System.out.println(number);
        }
    }
}
