package huffman;

import huffman.utility.BinaryString;
import huffman.utility.CharCodeWithMeta;

import java.util.HashMap;

public class HuffmanStringEncoder {
    private final BinaryString encoder;
    private final HashMap<Byte, CharCodeWithMeta> charToCode;
    private final byte[] data;

    private void encodeCodes() {
        encoder.placeByte((byte) (charToCode.size() - 1));
        for (Byte ch : charToCode.keySet()) {
            encoder.placeByte(ch);
            encoder.placeByteCode(new CharCodeWithMeta(charToCode.get(ch).length, (byte) 6));
            encoder.placeByteCode(charToCode.get(ch));
        }
    }

    private void encodeStr() {
        for (byte ch : data) {
            encoder.placeByteCode(charToCode.get(ch));
        }
        encoder.setEnd();
    }

    public HuffmanStringEncoder(final HashMap<Byte, CharCodeWithMeta> charToCode, final byte[] data) {
        encoder = new BinaryString();
        this.charToCode = charToCode;
        this.data = data;

        encodeCodes();
        encodeStr();
    }

    public Byte[] getEncoded() {
        return encoder.getBytes();
    }
}
