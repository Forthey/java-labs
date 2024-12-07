import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Классы StringBuffer и StringBuilder обладают схожим функционалом, но StringBuffer потокобезопасен, а StringBuilder — нет
        // Поэтому далее из-за схожести работы будут примеры только для StringBuilder

        // Пример с использованием StringBuilder
        StringBuilder stringBuilder = new StringBuilder("Forthey");

        // append() добавляет строку в конец текущей строки
        stringBuilder.append(" Drekalov");
        System.out.println(stringBuilder);              // Forthey Drekalov

        // insert() вставляет строку в указанную позицию
        stringBuilder.insert(7, " Nikita");
        System.out.println(stringBuilder);              // Forthey Nikita Drekalov

        // delete() удаляет подстроку из строки
        stringBuilder.delete(8, 15);
        System.out.println(stringBuilder);              // Forthey Drekalov

        // replace() заменяет подстроку в указанном диапазоне
        stringBuilder.replace(8, 16, "Nikita");
        System.out.println(stringBuilder);              // Forthey Nikita

        // reverse() разворачивает строку
        stringBuilder.reverse();
        System.out.println(stringBuilder);              // atikiN yehtroF
        stringBuilder.reverse();

        // length() возвращает длину строки
        System.out.println(stringBuilder.length());     // 14

        // capacity() возвращает текущую ёмкость буфера
        System.out.println(stringBuilder.capacity());   // 23

        // setLength() изменяет длину строки
        stringBuilder.setLength(7);
        System.out.println(stringBuilder);              // Forthey

        // charAt() возвращает символ по указанному индексу
        System.out.println(stringBuilder.charAt(3));    // t

        // substring() извлекает подстроку
        System.out.println(stringBuilder.substring(0, 6)); // Forthe
    }
}