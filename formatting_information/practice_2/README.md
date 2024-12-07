# Форматирование информации

## Практика #2

Зачем нужен метод flush()?

### Ответ

Метод flush() используется для принудительного сброса данных из буферов ввода-вывода в соответствующий поток. Он является частью интерфейсов и классов, работающих с потоками в Java, таких как OutputStream, BufferedWriter, и т.д.

Пример с консолью:
```java
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        PrintWriter printWriter = new PrintWriter(System.out, true); // autoFlush = true
        printWriter.print("Forthey ");
        printWriter.flush();                                         // Немедленно выводим текст в консоль
        printWriter.print("Nikita");
        printWriter.flush();
    }
}
```