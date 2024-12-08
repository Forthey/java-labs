import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Пример для класса FileInputStream
        final String filePath = "file.txt";

        try (var fileInputStream = new FileInputStream(filePath)) {
            // Создаём StringBuilder
            var stringBuilder = new StringBuilder();

            // Читаем данный из файла побайтно. Значение -1 означает, что был достигнут конец файла
            int byteData;
            while ((byteData = fileInputStream.read()) != -1) {
                // Добавляет байт в строку
                stringBuilder.append((char) byteData);
            }

            // Выводим содержимое файла
            System.out.println(stringBuilder);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }
    }
}
