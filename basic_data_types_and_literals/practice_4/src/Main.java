public class Main {
    public static void main(String[] args) {
        var test = new TestClass();
        int number = 1;
        float floatNumber = 1.0f;
        boolean bool = false;
        char ch = 'a';

        String b = "Begin";
        b = b + " " + number + " " + floatNumber + " " + bool + " " + ch + " " + test;
        System.out.println(b);
    }
}
