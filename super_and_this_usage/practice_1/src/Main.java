class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public void greet() {
        System.out.println("Hello, " + this.name + "!");
    }
}

class Forthey extends Person {
    public Forthey() {
        // 1. Обращение к конструктору суперкласса
        super("Forthey");
    }

    public String getName() {
        // 2. Доступ к методу суперкласса
        super.greet();

        // 3. Доступ к полю суперкласса
        return super.name;
    }
}

public class Main {
    public static void main(String[] args) {
        var forthey = new Forthey();
        forthey.greet();
    }
}