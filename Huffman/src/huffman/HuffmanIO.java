package huffman;

import huffman.utility.CharCodeWithMeta;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
            System.out.printf("%c (%d) \t%s\n", (char) ch.byteValue(), ch, prettyCode(codes.get(ch)));
        }
    }

    public static void writeToFile(final String filename, final byte[] data) {
        try (var fileOutputStream = new FileOutputStream(filename)) {
            fileOutputStream.write(data);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("Error during file writing: " + e.getMessage());
        }
    }

    public static byte[] readFromFile(final String filename) {
        try {
            return Files.readAllBytes(Path.of(filename));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return null;
    }

    private static String prettySize(long size) {
        long loweredSize;
        byte level = 0;
        while ((loweredSize = size / 1024) > 100) {
            size = loweredSize;
            level++;
        }

        String postFix = "?";
        switch (level) {
            case 0 -> postFix = "B";
            case 1 -> postFix = "KB";
            case 2 -> postFix = "MB";
            case 3 -> postFix = "GB";
        }

        return String.format("%d%s", size, postFix);
    }

    public static void printStats(long sizeBefore, long sizeAfter) {
        double compressionRatio = 1.0 - (double) sizeAfter / sizeBefore;
        System.out.printf("size: %s -> %s (%d%%)\n", prettySize(sizeBefore), prettySize(sizeAfter), (int) (compressionRatio * 100));
    }
}
