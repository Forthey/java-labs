import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // Простой способ :)
        String name = "Никита";
        System.out.println(name);

        // Явный способ
        name = "\u041D\u0438\u043a\u0438\u0442\u0430";
        System.out.println(name);
    }
}
