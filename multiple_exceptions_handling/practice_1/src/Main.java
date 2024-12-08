import java.util.ArrayList;

// Случай, когда исключения, которые обрабатываются, образуют иерархию Ex1 <|-- Ex2 <|-- Ex3
class Ex1 extends Exception {
    public Ex1(String message) {
        super(message);
    }
}

class Ex2 extends Ex1 {
    public Ex2(String message) {
        super(message);
    }
}

class Ex3 extends Ex2 {
    public Ex3(String message) {
        super(message);
    }
}

class TestClass {
    public void throwEx1() throws Ex1 {
        throw new Ex1("hello from ex1");
    }

    public void throwEx2() throws Ex2 {
        throw new Ex2("hello from ex2");
    }

    public void throwEx3() throws Ex3 {
        throw new Ex3("hello from ex3");
    }
}

public class Main {
    public static void main(String[] args) {
        // Случай, когда несколько исключений обрабатываются абсолютно идентичным образом
        try {
            int a = 1 / 0;         // Деление на ноль

            int[] arr = {1, 2, 3};
            int b = arr[3];           // Выход за пределы массива
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // Случай, когда исключения, которые обрабатываются, образуют иерархию Ex1 <|-- Ex2 <|-- Ex3
        var testClass = new TestClass();

        try {
            testClass.throwEx1();
            testClass.throwEx2();
            testClass.throwEx3();
        } catch (Ex3 e) {
            System.out.println(e.getMessage());
        } catch (Ex2 e) {
            System.out.println(e.getMessage());
        } catch (Ex1 e) {
            System.out.println(e.getMessage());
        }
    }
}
