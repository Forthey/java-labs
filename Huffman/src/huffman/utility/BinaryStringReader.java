package huffman.utility;

/**
 * A utility class for reading bits and bytes from a binary string.
 * Supports reading individual bits or groups of bits and detecting the end of the binary string.
 */
public class BinaryStringReader {
    private final byte bitsInByte;
    private final byte[] binaryString;
    int stringIter;
    byte charIter;

    /**
     * Constructs a {@code BinaryStringReader} with a default of 8 bits per byte.
     *
     * @param binaryString The binary string (byte array) to read from.
     * @throws IllegalArgumentException if the binary string is too short to be valid.
     */
    public BinaryStringReader(final byte[] binaryString) throws IllegalArgumentException {
        this(binaryString, (byte) 8);
    }


    /**
     * Constructs a {@code BinaryStringReader} with the specified number of bits per byte.
     *
     * @param binaryString The binary string (byte array) to read from.
     * @param bitsInChar   The number of bits in a byte for this binary string.
     * @throws IllegalArgumentException if the binary string is too short to be valid.
     */
    public BinaryStringReader(final byte[] binaryString, byte bitsInChar) throws IllegalArgumentException {
        if (binaryString.length < 2)
            throw new IllegalArgumentException("Invalid binary string length: too short - " + binaryString.length);
        this.binaryString = binaryString;
        this.bitsInByte = bitsInChar;
        this.charIter = 0;
        this.stringIter = 0;
    }

    /**
     * Reads the specified number of bits from the binary string and returns them as a long.
     *
     * @param numberOfBits The number of bits to read.
     * @return A {@code long} representing the value of the read bits.
     */
    public long next(byte numberOfBits) {
        long result = 0;
        for (byte i = 0; i < numberOfBits; ++i)
            result = (result << 1) + (nextBit() ? 1 : 0);
        return result;
    }

    /**
     * Reads the next bit from the binary string.
     *
     * @return {@code true} if the bit is 1, {@code false} if it is 0.
     * @throws RuntimeException if the end of the binary string is reached unexpectedly.
     */
    public boolean nextBit() throws RuntimeException {
        if (reachedEnd())
            throw new RuntimeException("ERROR! Unexpected EOF");

        if (charIter == bitsInByte) {
            charIter = 0;
            stringIter++;
        }
        boolean result = ((binaryString[stringIter] >>> (bitsInByte - 1 - charIter)) & 1) == 1;
        charIter++;

        return result;
    }

    /**
     * Checks if the end of the binary string has been reached.
     *
     * @return {@code true} if the end of the binary string is reached; {@code false} otherwise.
     */
    public boolean reachedEnd() {
        return stringIter == binaryString.length - 2 && charIter >= binaryString[binaryString.length - 1];
    }

    /**
     * Returns the length of the binary string in bytes.
     *
     * @return The length of the binary string.
     */
    public int length() {
        return binaryString.length;
    }
}
