class A {
    class B {
        // Аналогичное поведение у методов
        public int publicVar = 1;
        protected int protectedVar = 2;
        private int privateVar = 3;
        int defaultVar = 4;
    }

    public void testAccess() {
        B b = new B();

        // Есть доступ ко всем полям (и методам)
        System.out.println(b.publicVar);
        System.out.println(b.protectedVar);
        System.out.println(b.privateVar);
        System.out.println(b.defaultVar);
    }
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.testAccess();
    }
}
