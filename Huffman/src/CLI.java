import huffman.Huffman;
import huffman.utility.TimeWatcher;

import java.util.HashSet;
import java.util.List;

/**
 * Command Line Interface (CLI) for Huffman compression and decompression operations.
 * Provides options to compress, decompress, log time, display compression codes, and show statistics.
 */
public class CLI {
    /**
     * Prints the usage instructions for the application.
     */
    private static void printUsage() {
        System.out.println("\nUsage: Main [options] <inputfile> <outputfile>");
    }

    /**
     * Prints the available options and their descriptions.
     */
    private static void printOptions() {
        printUsage();
        System.out.println("\nOptions:");
        System.out.println("\t-h, --help        - Display this help message");
        System.out.println("\t--log-time        - Log time of compress operations");
        System.out.println("\t--codes           - Print generated codes");
        System.out.println("\t--stats           - Show compress stats");
        System.out.println("\t-d, --decompress  - Switch to decompressing");
    }

    /**
     * Parses command-line arguments, validates inputs, and performs the requested operation (compression or decompression).
     *
     * @param args A list of command-line arguments.
     *             <ul>
     *                 <li><code>--log-time</code>: Enable time logging for compression operations.</li>
     *                 <li><code>--codes</code>: Display the Huffman codes used during compression.</li>
     *                 <li><code>--stats</code>: Display compression statistics.</li>
     *                 <li><code>--decompress</code> or <code>-d</code>: Switch to decompression mode.</li>
     *                 <li><code>-h</code> or <code>--help</code>: Display usage and options help.</li>
     *                 <li>Two additional arguments for input and output file paths.</li>
     *             </ul>
     */
    public static void parseArgs(List<String> args) {
        String inputFilename = null, outputFilename = null;
        boolean printCodes = false, printStats = false, decompress = false;

        for (String arg : args) {
            switch (arg) {
                case "--log-time" -> TimeWatcher.setIsOn(true);
                case "--codes" -> printCodes = true;
                case "--stats" -> printStats = true;
                case "--decompress", "-d" -> decompress = true;
                case "-h", "--help" -> {
                    printOptions();
                    return;
                }
                default -> {
                    if (inputFilename == null) {
                        inputFilename = arg;
                    } else if (outputFilename == null) {
                        outputFilename = arg;
                    } else {
                        System.err.println("too many arguments" + arg);
                        printUsage();
                        return;
                    }
                }
            }
        }

        if (inputFilename == null) {
            System.err.println("input filename not specified");
            printUsage();
            return;
        }
        if (outputFilename == null) {
            System.err.println("output filename not specified");
            printUsage();
            return;
        }

        if (decompress) {
            Huffman.decompress(inputFilename, outputFilename, printStats);
        } else {
            Huffman.compress(inputFilename, outputFilename, printCodes, printStats);
        }

    }
}
