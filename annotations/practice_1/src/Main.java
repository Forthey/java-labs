class Person {
    public void greet() {
        System.out.println("Hello, person");
    }

    // Обозначаем, что метод deprecated - то есть нежелателен к использованию
    @Deprecated
    public void greetDeprecated() {
        System.out.printf("Hello, %s\n", "person");
    }
}

class Forthey extends Person {
    // Обозначаем, что метод greet должен переопределять родительский метод
    @Override
    public void greet() {
        System.out.println("Hello, Forthey");
    }

    // Подавляем предупреждение о вызове deprecated функции greetDeprecated
    @SuppressWarnings("deprecation")
    public void doGreet() {
        super.greetDeprecated(); // Предупреждения нет
    }
}

public class Main {
    public static void main(String[] args) {
        var forthey = new Forthey();
        forthey.greetDeprecated(); // Предупреждение о том, что метод deprecated
    }
}