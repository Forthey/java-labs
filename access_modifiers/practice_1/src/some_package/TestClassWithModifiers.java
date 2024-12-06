package some_package;

public class TestClassWithModifiers {
    // Аналогично модификаторы доступа работают с полями класса

    // Метод доступен всем через экземпляр класса
    public void printHello() {
        System.out.println("Hello");
    }

    // Метод с модификатором доступа по умолчанию доступен только внутри пакета some_package
    void defaultPrintHello() {
        System.out.println("Default Hello");
    }

    // Метод с модификатором доступа protected внутри пакета some_package и унаследованным классам в других пакетах
    protected void protectedPrintHello() {
        System.out.println("Protected Hello");
    }

    // Метод с модификатором доступа private доступен только внутри текущего класса
    private void privatePrintHello() {
        System.out.println("Private Hello");
    }

    public void printAllHellos() {
        // Доступен приватный и остальные методы
        printHello();
        defaultPrintHello();
        protectedPrintHello();
        privatePrintHello();
    }
}
