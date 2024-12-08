# Байтовые и символьные потоки ввода/вывода

## Практика #4

Зачем нужен интерфейс `AutoCloseable`? Приведите пример.

## Ответ

Интерфейс `AutoCloseable` в Java нужен для того, чтобы объекты, использующие ограниченные ресурсы (например, файлы или соединения с базой данных), можно было корректно закрывать после использования. Этот интерфейс позволяет использовать такие объекты в конструкции `try-with-resources`, которая автоматически вызывает метод `close()` для освобождения ресурсов, даже если в блоке try возникло исключение.

Пример:
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final String filePath = "file.txt";

        // Используем try-with-resources
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            // После блока try автоматически вызовется reader.close()
        } catch (IOException e) {
            // При возникшем исключении также автоматически вызовется reader.close() 
            System.out.println("Error during file read: " + e.getMessage());
        }
    }
}
```