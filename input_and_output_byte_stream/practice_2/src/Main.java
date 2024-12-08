import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Пример для класса FileOutputStream
        final String filePath = "file.txt";

        try (var fileOutputStream = new FileOutputStream(filePath)) {
            // Данные, которые будут записаны в файл
            final String fileContent = "hello~";

            // Запись данных побайтно
            for (char c : fileContent.toCharArray()) {
                fileOutputStream.write(c); // Пишем символ как байт
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }
    }
}
