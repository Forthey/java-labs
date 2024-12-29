package huffman;

import huffman.utility.BinaryString;
import huffman.utility.CharCodeWithMeta;

import java.util.HashMap;

/**
 * Responsible for encoding a byte array into a Huffman-encoded format.
 * This class encodes both the Huffman codes and the actual data using those codes.
 */
public class HuffmanStringEncoder {
    private final BinaryString encoder;
    private final HashMap<Byte, CharCodeWithMeta> charToCode;
    private final byte[] data;

    /**
     * Constructs a HuffmanStringEncoder with the given Huffman code mapping and data to encode.
     *
     * @param charToCode A map of bytes to their corresponding Huffman codes and metadata.
     * @param data       The input data to be encoded.
     */
    public HuffmanStringEncoder(final HashMap<Byte, CharCodeWithMeta> charToCode, final byte[] data) {
        encoder = new BinaryString();
        this.charToCode = charToCode;
        this.data = data;

        encodeCodes();
        encodeStr();
    }

    /**
     * Encodes the Huffman codes into the binary output.
     * This includes the number of unique characters, their values, and their codes.
     */
    private void encodeCodes() {
        encoder.placeByte((byte) (charToCode.size() - 1));
        for (Byte ch : charToCode.keySet()) {
            encoder.placeByte(ch);
            encoder.placeByteCode(new CharCodeWithMeta(charToCode.get(ch).length, (byte) 6));
            encoder.placeByteCode(charToCode.get(ch));
        }
    }

    /**
     * Encodes the input data into the binary output using the Huffman codes.
     * This appends the encoded data to the output and marks the end of the stream.
     */
    private void encodeStr() {
        for (byte ch : data) {
            encoder.placeByteCode(charToCode.get(ch));
        }
        encoder.setEnd();
    }

    /**
     * Retrieves the final encoded byte array.
     *
     * @return The Huffman-encoded byte array.
     */
    public byte[] getEncoded() {
        return encoder.getBytes();
    }
}
