import java.util.Arrays;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        // Класс StringJoiner из Java предназначен для удобного объединения строк

        // Объединение строк с разделителем
        var joiner1 = new StringJoiner(", ");

        joiner1.add("Car");
        joiner1.add("Truck");
        joiner1.add("Cat");

        System.out.println(joiner1);    // "Car, Truck, Cat"

        // Добавление префикса и суффикса
        var joiner2 = new StringJoiner(" | ", "[", "]"); // Префикс - "[", Суффикс - "]"
        joiner2.add("Car");
        joiner2.add("Truck");
        joiner2.add("Cat");

        System.out.println(joiner2);    // "[Car | Truck | Cat]"

        // Пустой StringJoiner
        var emptyJoiner = new StringJoiner(" | ", "{", "}");

        System.out.println(emptyJoiner); // "{}"

        // Объединение двух и более StringJoiner
        joiner1.merge(joiner2).merge(emptyJoiner);

        System.out.println(joiner1);     // "Car, Truck, Cat, Car | Truck | Cat"
    }
}