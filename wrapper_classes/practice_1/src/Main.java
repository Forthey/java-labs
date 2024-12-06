public class Main {
    public static void main(String[] args) {
        // Декодирование числа в десятичной системе счисления
        Integer decimal = Integer.decode("123");
        System.out.println("Parsed number: " + decimal);

        // Декодирование числа в шестнадцатеричной системе счисления
        Integer hex = Integer.decode("0x1A");
        System.out.println("Parsed hex number: " + hex);

        // Аналогично можно декодировать в Long
        Long decimalLong = Long.decode("123");
        System.out.println("Parsed number: " + decimalLong);

        // Если в строке не число - выбрасывается ошибка NumberFormatException
        try {
            Integer invalidNumber = Integer.decode("hii");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

    }
}
