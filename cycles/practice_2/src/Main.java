public class Main {
    public static void main(String[] args) {
        // Пример цикла
        while (true) {
            System.out.print("Enter something (skip to skip, exit to exit): ");
            String input = System.console().readLine();

            // Если пользователь ввёл skip - с помощью continue переходим на следующую итерацию цикла
            if (input.equals("skip")) {
                continue;
            }

            // Если пользователь ввёл exit - с помощью break выходим из цикла
            if (input.equals("exit")) {
                break;
            }

            System.out.println(input);
        }
    }
}
