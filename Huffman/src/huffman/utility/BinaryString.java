package huffman.utility;

class BinaryString {
    private final byte bitsInChar;
    private StringBuilder str;
    private byte bitsAtTheEnd;

    public BinaryString() {
        this((byte) 8);
    }

    public BinaryString(byte bitsInChar) {
        this.bitsInChar = bitsInChar;
        str = new StringBuilder();
        bitsAtTheEnd = 0;
    }

    public void placeBit(boolean bit) {
        char cBit = bit ? (char) 1 : (char) 0;

        if (bitsAtTheEnd % bitsInChar == 0) {
            str.append(cBit);
            bitsAtTheEnd = 1;
            return;
        }

        str.setCharAt(str.length() - 1, (char) ((char) (str.charAt(str.length() - 1) << 1) + cBit));
        bitsAtTheEnd++;
    }

    public void placeChar(char ch) {
        for (byte i = bitsInChar; i > 0; --i) {
            boolean bit = ((ch >> (i - 1)) & 1) == 1;
            placeBit(bit);
        }
    }

    public void placeCharCode(final CharCodeWithMeta code) {
        for (byte i = code.length; i > 0; --i) {
            boolean bit = ((code.code >> (i - 1)) & 1) == 1;
            placeBit(bit);
        }
    }

    public void setEnd() {
        byte trueBitsAtTheEnd = bitsAtTheEnd;
        while (bitsAtTheEnd != bitsInChar) {
            placeBit(false);
        }
        placeCharCode(new CharCodeWithMeta(trueBitsAtTheEnd, bitsInChar));
    }

    public String getString() {
        return str.toString();
    }
};
