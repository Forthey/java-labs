class ClassWithFinal {
    // Метод объявлен со спецификатором final
    public final void methodWithFinal() {
        System.out.println("Final");
    }
}

class Inherited extends ClassWithFinal {
    // Код не скомпилируется - попытка переопределить финальный метод
    @Override
    public void methodWithFinal() {
        System.out.println("This won't work");
    }
}

public class Main {
    public static void main(String[] args) {
    }
}