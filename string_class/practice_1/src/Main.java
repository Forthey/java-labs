import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str = "forthey Nikita Drekalov";

        // Проверка строк на равенство
        if (str.equals("forthey Nikita Drekalov")) {
            System.out.println("Strings are equal");
        }

        // split разбивает строку на несколько строк по указанному разделителю
        String[] words = str.split(" ");
        System.out.println(Arrays.toString(words));             // ["forthey", "Nikita", "Drekalov"]

        // toLowerCase преобразует все буквы в строчные
        System.out.println(str.toLowerCase());                      // "forthey nikita drekalov"

        // toUpperCase преобразует все буквы в заглавные
        System.out.println(str.toUpperCase());                      // "FORTHEY NIKITA DREKALOV"

        // concat добавляет к текущей строке в конец строку, переданную как параметр
        System.out.println(str.concat(" 5030102/20202"));       // "forthey Nikita Drekalov 5030102/20202"

        // trim удаляет все начальные и конечные пробелы из строки
        System.out.println(("   data ").trim());                    // "data"

        // indexOf находит индекс первого вхождения подстроки str в строку. Возвращает -1, если подстрока не найдена.
        System.out.println(str.indexOf("Nikita"));                  // 8
        System.out.println(str.indexOf("Hello"));                   // -1

        // replace заменяет все вхождения символа на новый символ в строке
        System.out.println(str.replace("a", "!")); // "forthey Nikit! Drek!lov"

        // substring извлекает подстроку из строки, начиная с первого индекса (параметра) и заканчивая вторым, не включая его
        System.out.println(str.substring(1, 5));                     // "orth"

        // charAt возвращает символ на указанном индексе
        System.out.println(str.charAt(10));                          // 'k'
    }
}