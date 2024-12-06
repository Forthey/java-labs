import some_package.TestClassWithModifiers;

public class Main {
    public static void main(String[] args) {
        var testClass = new TestClassWithModifiers();

        // Доступны публичные (public) поля и методы класса
        testClass.printHello();

        // Недоступны защищенные (protected) поля и методы класса, а также поля с модификатором доступа по умолчанию
        // testClass.protectedPrintHello(); -- Ошибка!
        // testClass.defaultPrintHello(); -- Ошибка!

        // Недоступны приватные (private) поля и методы класса
        // testClass.privatePrintHello(); -- Ошибка!
    }
}
