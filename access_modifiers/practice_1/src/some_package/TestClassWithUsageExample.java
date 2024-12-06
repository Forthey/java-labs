package some_package;

public class TestClassWithUsageExample {
    public void testModifiers() {
        var testClass = new TestClassWithModifiers();

        // Доступны публичные (public) поля и методы класса
        testClass.printHello();

        // Доступны защищенные (protected) поля и методы класса, а также поля с модификатором доступа по умолчанию
        testClass.protectedPrintHello();
        testClass.defaultPrintHello();

        // Недоступны приватные (private) поля и методы класса
        // testClass.privatePrintHello(); -- Ошибка!
    }
}
