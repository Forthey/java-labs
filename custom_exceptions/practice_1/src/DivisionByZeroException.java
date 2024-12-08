public class DivisionByZeroException extends Exception {
    // 4 конструктора

    // Конструктор без параметров
    public DivisionByZeroException() {
        super("Division by zero");
    }

    // Конструктор с параметром String (сообщение)
    public DivisionByZeroException(String message) {
        super(message);
    }

    // Конструктор с параметрами String и Throwable (сообщение и причина)
    public DivisionByZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    // Конструктор с параметром Throwable (только причина)
    public DivisionByZeroException(Throwable cause) {
        super(cause);
    }
}
