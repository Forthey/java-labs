package huffman.utility;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BinaryString {
    private final byte bitsInByte;
    private final ArrayList<Byte> data;
    private byte bitsAtTheEnd;

    public BinaryString() {
        this((byte) 8);
    }

    public BinaryString(byte bitsInChar) {
        this.bitsInByte = bitsInChar;
        data = new ArrayList<>();
        bitsAtTheEnd = 0;
    }

    public void placeBit(boolean bit) {
        byte cBit = bit ? (byte) 1 : (byte) 0;

        if (bitsAtTheEnd % bitsInByte == 0) {
            data.add(cBit);
            bitsAtTheEnd = 1;
            return;
        }

        data.set(data.size() - 1, (byte) ((data.getLast() << 1) + cBit));
        bitsAtTheEnd++;
    }

    public void placeByte(byte ch) {
        for (byte i = bitsInByte; i > 0; --i) {
            boolean bit = ((ch >>> (i - 1)) & 1) == 1;
            placeBit(bit);
        }
    }

    public void placeByteCode(final CharCodeWithMeta code) {
        for (byte i = code.length; i > 0; --i) {
            boolean bit = ((code.code >> (i - 1)) & 1) == 1;
            placeBit(bit);
        }
    }

    public void setEnd() {
        byte trueBitsAtTheEnd = bitsAtTheEnd;
        while (bitsAtTheEnd != bitsInByte) {
            placeBit(false);
        }
        placeByteCode(new CharCodeWithMeta(trueBitsAtTheEnd, bitsInByte));
    }

    public Byte[] getBytes() {
        return data.toArray(new Byte[0]);
    }
};
