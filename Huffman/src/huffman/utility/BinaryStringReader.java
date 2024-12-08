package huffman.utility;

public class BinaryStringReader {
    private final byte bitsInChar;
    private final String binaryString;
    int stringIter;
    byte charIter;

    public BinaryStringReader(final String binaryString) throws IllegalArgumentException {
        this(binaryString, (byte) 8);
    }

    public BinaryStringReader(final String binaryString, byte bitsInChar) throws IllegalArgumentException {
        if (binaryString.length() < 2)
            throw new IllegalArgumentException("Invalid binary string length: too short - " + binaryString.length());
        this.binaryString = binaryString;
        this.bitsInChar = bitsInChar;
        this.charIter = 0;
        this.stringIter = 0;
    }

    public long next(byte numberOfBits) {
        long result = 0;
        for (byte i = 0; i < numberOfBits; ++i)
            result = (result << 1) + (nextBit() ? 1 : 0);
        return result;
    }

    public boolean nextBit() throws RuntimeException {
        if (reachedEnd())
            throw new RuntimeException("ERROR! Unexpected EOF");

        if (charIter == bitsInChar) {
            charIter = 0;
            stringIter++;
        }
        boolean result = ((binaryString.charAt(stringIter) >> (bitsInChar - 1 - charIter)) & 1) == 1;
        charIter++;

        return result;
    }

    public boolean reachedEnd() {
        return stringIter == binaryString.length() - 2 && charIter >= binaryString.charAt(binaryString.length() - 1);
    }
}
