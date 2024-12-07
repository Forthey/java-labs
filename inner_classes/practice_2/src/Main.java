class A {
    // Аналогичное поведение у методов
    public int publicVar = 1;
    protected int protectedVar = 2;
    private int privateVar = 3;
    int defaultVar = 4;

    class B {
        public void testAccess() {
            // Есть доступ ко всем полям (и методам)
            System.out.println(publicVar);
            System.out.println(protectedVar);
            System.out.println(privateVar);
            System.out.println(defaultVar);
        }
    }

    public B b = new B();
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.b.testAccess();
    }
}
