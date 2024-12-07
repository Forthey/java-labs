interface SomeInterface {
    // Неабстрактный метод (метод по умолчанию)
    default void defaultMethod() {
        System.out.println("Default method in the interface");
    }

    // Статический метод
    static void staticMethod() {
        System.out.println("Static method in the interface");
    }

    // Абстрактный метод (обычный для интерфейсов)
    void abstractMethod();
}

class SomeImplement implements SomeInterface {
    // Реализация абстрактного метода
    @Override
    public void abstractMethod() {
        System.out.println("Implemented abstract method");
    }
}

public class Main {
    public static void main(String[] args) {
        var someImplement = new SomeImplement();

        // Вызов реализованного абстрактного метода
        someImplement.abstractMethod();

        // Вызов метода по умолчанию (defaultMethod)
        someImplement.defaultMethod();

        // Вызов статического метода интерфейса
        SomeInterface.staticMethod();

        // Прямая попытка вызова статического метода через объект или класс-реализацию приведет к ошибке компиляции
        // SomeImplement.staticMethod();    // Ошибка: static method may only be called on it's containing interface
        // someImplement.staticMethod();    // Ошибка: static method may only be called on it's containing interface
    }
}