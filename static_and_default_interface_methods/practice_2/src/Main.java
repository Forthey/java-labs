interface SomeInterface {
    // Неабстрактный метод (метод по умолчанию)
    default void defaultMethod() {
        System.out.println("Default method in the interface");
    }
}

interface SomeAnotherInterface {
    default void defaultMethod() {
        System.out.println("Default method in the another interface");
    }
}

class SomeImplement implements SomeInterface, SomeAnotherInterface {
    // Исправление конфликта - переопределение метода
    @Override
    public void defaultMethod() {
        // Можно выбрать реализацию из одного из интерфейсов
        SomeInterface.super.defaultMethod();
        // SomeAnotherInterface.super.defaultMethod();

        // Или реализовать собственную логику
        System.out.println("Custom default method implementation");
    }
}

public class Main {
    public static void main(String[] args) {
        var someImplement = new SomeImplement();
        someImplement.defaultMethod();
    }
}