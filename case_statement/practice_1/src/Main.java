public class Main {
    public static void main(String[] args) {
        // Переменная целочисленного типа
        int intNumber = 1;
        switch (intNumber) {
            case 1:
                System.out.println("1");
                break;
            default:
                System.out.println("default");
                break;
        }

        short shortNumber = 2;
        switch (shortNumber) {
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("default");
                break;
        }

        // String
        String stringValue = "abc";
        switch (stringValue) {
            case "abc":
                System.out.println("abc");
                break;
            default:
                System.out.println("default");
        }

        // Enum
        enum SampleEnum {
            FIRST_VALUE, SECOND_VALUE
        }
        SampleEnum enumValue = SampleEnum.FIRST_VALUE;
        switch (enumValue) {
            case FIRST_VALUE:
                System.out.println("first value");
                break;
            case SECOND_VALUE:
                System.out.println("second value");
                break;
        }

        // Класс-оболочка целочисленного типа
        Integer integerWrapper = 1;
        switch (integerWrapper) {
            case 1:
                System.out.println("1");
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
