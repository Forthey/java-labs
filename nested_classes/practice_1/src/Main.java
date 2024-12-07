interface A {
    // Класс является static по умолчанию
    class NestedClass {
        public void hello() {
            System.out.println("Hello");
        }

        static public void staticHello() {
            System.out.println("Hello");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        A.NestedClass nestedClass = new A.NestedClass();

        nestedClass.hello();
        A.NestedClass.staticHello();
    }
}
