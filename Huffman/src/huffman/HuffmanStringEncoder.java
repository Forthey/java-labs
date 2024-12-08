package huffman;

import huffman.utility.BinaryString;
import huffman.utility.CharCodeWithMeta;

import java.util.HashMap;

public class HuffmanStringEncoder {
    private BinaryString encoder;
    private final HashMap<Character, CharCodeWithMeta> charToCode;
    private final String text;

    private void encodeCodes() {
        encoder.placeChar((char) (charToCode.size() - 1));
        for (Character ch : charToCode.keySet()) {
            encoder.placeChar(ch);
            encoder.placeCharCode(new CharCodeWithMeta(charToCode.get(ch).length, (byte) 6));
            encoder.placeCharCode(charToCode.get(ch));
        }
    }

    private void encodeStr() {
        for (char ch : text.toCharArray()) {
            encoder.placeCharCode(charToCode.get(ch));
        }
        encoder.setEnd();
    }

    public HuffmanStringEncoder(final HashMap<Character, CharCodeWithMeta> charToCode, final String data) {
        encoder = new BinaryString();
        this.charToCode = charToCode;
        this.text = data;

        encodeCodes();
        encodeStr();
    }

    public String getEncoded() {
        return encoder.getString();
    }
}
