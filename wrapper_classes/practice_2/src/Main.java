public class Main {
    public static void main(String[] args) {
        // Конструктор (устаревший способ)
//        Boolean deprecatedValue = new Boolean(true);
//        Boolean deprecatedFromString = new Boolean("true");

        // Boolean.valueOf
        Boolean value = Boolean.valueOf(true);              // Создание из примитивного значения
        Boolean boolFromString = Boolean.valueOf("true");   // Создание из строки

        // Предопределённые значения
        Boolean boolTrue = Boolean.TRUE;    // Ссылается на кэшированный объект для true
        Boolean boolFalse = Boolean.FALSE;  // Ссылается на кэшированный объект для false

        // Автоупаковка
        Boolean bool = true;

    }
}
