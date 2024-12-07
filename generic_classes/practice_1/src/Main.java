import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Проверка объекта как экземпляра обобщенного типа
        // Можно проверить, является ли объект экземпляром класса без учёта параметров
        List<String> stringList = new ArrayList<>();
        if (stringList instanceof ArrayList) {
            System.out.println("This is an ArrayList");
        }

        // Использование instanceof для параметризованных классов с кастингом
        // Прямую проверку instanceof List<String> выполнить нельзя, но можно проверить обобщенный тип, а затем безопасно привести объект к параметризованному типу:
        Object listObj = stringList;
        if (listObj instanceof List) {
            var castedToStringListObj = (List<String>) listObj;
            System.out.println("Successfully cast to List<String>");
        }

        // Можно проверить объект на принадлежность базовому классу обобщённого типа
        if (stringList instanceof List) {
            System.out.println("This is a List");
        }

        // Параметризованные типы работают только на уровне компиляции, из-за чего невозможны проверки для конкретных параметризованных типов на уровне выполнения.
        // Работает из-за того, что тип параметра совпадает с проверяемым
        if (stringList instanceof ArrayList<String>) {
            System.out.println("This is an ArrayList<String>");
        }
        // Выдаст ошибку компиляции
        // if (!(stringList instanceof ArrayList<Integer>)) {
        // System.out.println("This is not an ArrayList<Integer>");
        // }
    }
}