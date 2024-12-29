package huffman;

import huffman.utility.CharCodeWithMeta;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * Utility class for performing input and output operations in the Huffman compression algorithm.
 * Includes methods for reading and writing files, printing Huffman codes, and displaying compression statistics.
 */
public class HuffmanIO {

    /**
     * Converts a {@link CharCodeWithMeta} object to a human-readable binary representation.
     *
     * @param code The Huffman code to convert.
     * @return A string representation of the binary code.
     */
    private static String prettyCode(final CharCodeWithMeta code) {
        var result = new StringBuilder();

        for (byte i = code.length; i > 0; i--) {
            long offset = ((code.code >> (i - 1)) & 1);
            result.append((char) (offset + '0'));
        }

        return result.toString();
    }

    /**
     * Prints the Huffman codes and their corresponding characters to the console.
     *
     * @param codes A map of characters to their {@link CharCodeWithMeta} objects.
     */
    public static void printCodes(final HashMap<Byte, CharCodeWithMeta> codes) {
        System.out.printf("\nCodes (total %d): \n", codes.size());
        for (Byte ch : codes.keySet()) {
            System.out.printf("\t%c (%d) \t%s\n", (char) ch.byteValue(), ch, prettyCode(codes.get(ch)));
        }
    }

    /**
     * Writes binary data to a file.
     *
     * @param filename The path to the file where data should be written.
     * @param data     The binary data to write.
     */
    public static void writeToFile(final String filename, final byte[] data) {
        try (var fileOutputStream = new FileOutputStream(filename)) {
            fileOutputStream.write(data);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("Error during file writing: " + e.getMessage());
        }
    }

    /**
     * Reads binary data from a file.
     *
     * @param filename The path to the file to read.
     * @return A byte array containing the file's contents, or {@code null} if an error occurs.
     */
    public static byte[] readFromFile(final String filename) {
        try {
            return Files.readAllBytes(Path.of(filename));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return null;
    }

    /**
     * Converts a file size in bytes to a human-readable format (e.g., KB, MB, GB).
     *
     * @param size The size in bytes.
     * @return A formatted string representing the size.
     */
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

    /**
     * Prints compression or decompression statistics to the console, including original and resulting sizes.
     *
     * @param sizeBefore The size of the data before compression or decompression.
     * @param sizeAfter  The size of the data after compression or decompression.
     */
    public static void printStats(long sizeBefore, long sizeAfter) {
        double compressionRatio = 1.0 - (double) sizeAfter / sizeBefore;
        System.out.printf("\nSize: %s -> %s (%d%%)\n", prettySize(sizeBefore), prettySize(sizeAfter), (int) (compressionRatio * 100));
    }
}
