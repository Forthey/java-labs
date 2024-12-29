package huffman;

import huffman.utility.CharCodeWithMeta;
import huffman.utility.TimeWatcher;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Provides methods for Huffman compression and decompression operations.
 * Handles reading input files, encoding/decoding data, and writing output files.
 */
public class Huffman {

    /**
     * Compresses a file using Huffman encoding.
     *
     * @param inFilename  The path to the input file to compress.
     * @param outFilename The path to the output file to write compressed data.
     * @param printCodes  If true, prints the generated Huffman codes to the console.
     * @param printStats  If true, prints compression statistics, including input and output sizes.
     */
    public static void compress(final String inFilename, final String outFilename, boolean printCodes, boolean printStats) {
        var timeWatcher = new TimeWatcher();

        timeWatcher.start("read-file-to-encode");
        byte[] data = HuffmanIO.readFromFile(inFilename);
        timeWatcher.stop();
        if (data == null || data.length == 0)
            return;

        timeWatcher.start("build-codes");
        HashMap<Byte, CharCodeWithMeta> codes = new HuffmanTree(data).buildCodes();
        timeWatcher.stop();

        if (printCodes) {
            HuffmanIO.printCodes(codes);
        }

        timeWatcher.start("encode-str");
        byte[] encodedData = new HuffmanStringEncoder(codes, data).getEncoded();
        timeWatcher.stop();

        timeWatcher.start("write-file-encoded");
        HuffmanIO.writeToFile(outFilename, encodedData);
        timeWatcher.stop();

        if (printStats) {
            HuffmanIO.printStats(data.length, encodedData.length);
        }
    }

    /**
     * Decompresses a file that was compressed using Huffman encoding.
     *
     * @param inFilename  The path to the input file containing compressed data.
     * @param outFilename The path to the output file to write decompressed data.
     * @param printStats  If true, prints decompression statistics, including input and output sizes.
     */
    public static void decompress(final String inFilename, final String outFilename, boolean printStats) {
        var timeWatcher = new TimeWatcher();

        timeWatcher.start("read-file-to-decode");
        byte[] encodedData = HuffmanIO.readFromFile(inFilename);
        timeWatcher.stop();

        timeWatcher.start("decode-file");
        byte[] data = new HuffmanStringDecoder(encodedData).getDecoded();
        timeWatcher.stop();

        timeWatcher.start("write-file-decoded");
        HuffmanIO.writeToFile(outFilename, data);
        timeWatcher.stop();

        if (printStats) {
            HuffmanIO.printStats(encodedData.length, data.length);
        }
    }
}
