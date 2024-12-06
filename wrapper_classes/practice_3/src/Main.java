public class Main {
    public static void main(String[] args) {
        Boolean bool = null;            // Объявлен объект с null
        boolean primitiveBool = bool;   // Попытка автораспаковки вызывает NullPointerException
    }
}
