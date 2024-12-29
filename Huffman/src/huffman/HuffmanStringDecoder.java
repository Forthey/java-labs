package huffman;

import huffman.utility.BinaryStringReader;
import huffman.utility.CharCodeWithMeta;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Responsible for decoding a Huffman-encoded byte array into the original data.
 * This class first decodes the Huffman codes and then decodes the data using those codes.
 */
public class HuffmanStringDecoder {
    private BinaryStringReader reader;
    private HashMap<CharCodeWithMeta, Byte> codeToChar;
    private ArrayList<Byte> decoded;

    /**
     * Constructs a HuffmanStringDecoder with the given Huffman-encoded byte data.
     *
     * @param data The Huffman-encoded data to decode.
     */
    public HuffmanStringDecoder(final byte[] data) {
        reader = new BinaryStringReader(data);
        codeToChar = new HashMap<>();
        decoded = new ArrayList<>();

        decodeCodes();
        decodeStr();
    }

    /**
     * Decodes the Huffman codes from the input binary data.
     * This includes the number of unique codes, their values, and their corresponding codes.
     */
    private void decodeCodes() {
        char codesNumber = (char) reader.next((byte) 8);

        for (char i = 0; i <= codesNumber; i++) {
            byte ch = (byte) reader.next((byte) 8);
            byte codeLength = (byte) reader.next((byte) 6);
            long code = reader.next(codeLength);

            var charCodeWithMeta = new CharCodeWithMeta(code, codeLength);
            codeToChar.put(charCodeWithMeta, ch);
        }
    }

    /**
     * Decodes the data stream using the previously decoded Huffman codes.
     * The method traverses the encoded data bit by bit and looks for matching Huffman codes.
     */
    private void decodeStr() throws RuntimeException {
        long code = 0;
        byte codeLength = 0;

        decoded.ensureCapacity(reader.length());

        while (!reader.reachedEnd()) {
            if (code >= Long.MAX_VALUE / 2)
                throw new RuntimeException("ERROR! File is not valid");
            code = (code << 1) + (reader.nextBit() ? 1 : 0);
            codeLength++;

            var charCodeWithMeta = new CharCodeWithMeta(code, codeLength);
            if (codeToChar.containsKey(charCodeWithMeta)) {
                decoded.add(codeToChar.get(charCodeWithMeta));
                code = 0;
                codeLength = 0;
            }
        }

        if (code != 0)
            throw new RuntimeException("ERROR! File is not valid");
    }

    /**
     * Retrieves the final decoded byte array.
     *
     * @return The decoded byte array.
     */
    public byte[] getDecoded() {
        byte[] bytes = new byte[decoded.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) decoded.get(i);
        }
        return bytes;
    }
}
