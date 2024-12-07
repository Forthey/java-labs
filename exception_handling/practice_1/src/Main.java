import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int a = 3, b = 0;

        try {
            int c = a / b;                      // Вызовет исключение, которое будет перехвачено
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        int c = a % b;                          // Исключение приведет к аварийной остановке программы
    }
}
