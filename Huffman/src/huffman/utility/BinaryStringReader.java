package huffman.utility;

public class BinaryStringReader {
    private final byte bitsInByte;
    private final byte[] binaryString;
    int stringIter;
    byte charIter;

    public BinaryStringReader(final byte[] binaryString) throws IllegalArgumentException {
        this(binaryString, (byte) 8);
    }

    public BinaryStringReader(final byte[] binaryString, byte bitsInChar) throws IllegalArgumentException {
        if (binaryString.length < 2)
            throw new IllegalArgumentException("Invalid binary string length: too short - " + binaryString.length);
        this.binaryString = binaryString;
        this.bitsInByte = bitsInChar;
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

        if (charIter == bitsInByte) {
            charIter = 0;
            stringIter++;
        }
        boolean result = ((binaryString[stringIter] >>> (bitsInByte - 1 - charIter)) & 1) == 1;
        charIter++;

        return result;
    }

    public boolean reachedEnd() {
        return stringIter == binaryString.length - 2 && charIter >= binaryString[binaryString.length - 1];
    }

    public int length() {
        return binaryString.length;
    }
}
