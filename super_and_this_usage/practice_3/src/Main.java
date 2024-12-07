class A {
    int a;
    int b;
    int c;
    int z;

    public A() {
        z = 1;
    }

    public A(int a) {
        this();
        this.a = a;
    }

    public A(int a, int b) {
        this(a);
        this.b = b;
    }

    public A(int a, int b, int c) {
        this(a, b);
        this.c = c;
    }
}