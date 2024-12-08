import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String filePath = "file.txt";

        try (var scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextInt()) {
                System.out.printf("Int: %d\n", scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
