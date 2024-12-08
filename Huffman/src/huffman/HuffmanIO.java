package huffman;

import huffman.utility.CharCodeWithMeta;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class HuffmanIO {
    private static String prettyCode(final CharCodeWithMeta code) {
        var result = new StringBuilder();

        for (byte i = code.length; i > 0; i--) {
            long offset = ((code.code >> (i - 1)) & 1);
            result.append((char) (offset + '0'));
        }

        return result.toString();
    }

    public static void printCodes(final HashMap<Byte, CharCodeWithMeta> codes) {
        for (Byte ch : codes.keySet()) {
            System.out.printf("%d: %s\n", ch, prettyCode(codes.get(ch)));
        }
    }

    public static void writeToFile(final String filename, final Byte[] data) {
        try (var fileOutputStream = new FileOutputStream(filename)) {
            for (byte b : data) {
                fileOutputStream.write(b);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        }
        catch (IOException e) {
            System.err.println("Error during file writing: " + e.getMessage());
        }
    }

    public static byte[] readFromFile(final String filename) {

        try (var inputStream = new FileInputStream(filename)) {
            var stringBuilder = new StringBuilder();

            int byteData;
            while ((byteData = inputStream.read()) != -1) {  // Чтение байтов из файла
                stringBuilder.append((char) byteData);
            }

            return stringBuilder.toString().getBytes(StandardCharsets.ISO_8859_1);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return null;
    }
}
