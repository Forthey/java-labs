package huffman.utility;

import java.util.ArrayList;

/**
 * Represents a binary string that allows manipulation of bits and bytes.
 * Provides functionality for adding individual bits, bytes, and encoding data into a binary format.
 */
public class BinaryString {
    private final byte bitsInByte;
    private final ArrayList<Byte> data;
    private byte bitsAtTheEnd;

    /**
     * Creates a new {@code BinaryString} with a default of 8 bits per byte.
     */
    public BinaryString() {
        this((byte) 8);
    }

    /**
     * Creates a new {@code BinaryString} with the specified number of bits per byte.
     *
     * @param bitsInChar The number of bits in a byte for this binary string.
     */
    public BinaryString(byte bitsInChar) {
        this.bitsInByte = bitsInChar;
        data = new ArrayList<>();
        bitsAtTheEnd = 0;
    }

    /**
     * Places a single bit into the binary string.
     *
     * @param bit {@code true} to place a 1, {@code false} to place a 0.
     */
    public void placeBit(boolean bit) {
        byte cBit = bit ? (byte) 1 : (byte) 0;

        if (bitsAtTheEnd % bitsInByte == 0) {
            data.add(cBit);
            bitsAtTheEnd = 1;
            return;
        }

        data.set(data.size() - 1, (byte) ((byte) (data.getLast() << 1) + cBit));
        bitsAtTheEnd++;
    }

    /**
     * Places a full byte into the binary string.
     *
     * @param ch The byte to place.
     */
    public void placeByte(byte ch) {
        for (byte i = bitsInByte; i > 0; --i) {
            boolean bit = ((ch >>> (i - 1)) & 1) == 1;
            placeBit(bit);
        }
    }

    /**
     * Places a {@link CharCodeWithMeta} object (a Huffman code with metadata) into the binary string.
     *
     * @param code The Huffman code to place.
     */
    public void placeByteCode(final CharCodeWithMeta code) {
        for (byte i = code.length; i > 0; --i) {
            boolean bit = ((code.code >> (i - 1)) & 1) == 1;
            placeBit(bit);
        }
    }

    /**
     * Marks the end of the binary string and appends metadata about the remaining bits at the end.
     * Pads the binary string to align with the specified number of bits per byte.
     */
    public void setEnd() {
        byte trueBitsAtTheEnd = bitsAtTheEnd;
        while (bitsAtTheEnd != bitsInByte) {
            placeBit(false);
        }
        placeByteCode(new CharCodeWithMeta(trueBitsAtTheEnd, bitsInByte));
    }

    /**
     * Retrieves the binary string as a byte array.
     *
     * @return A byte array containing the binary data.
     */
    public byte[] getBytes() {
        byte[] bytes = new byte[data.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = data.get(i);
        }
        return bytes;
    }
};
