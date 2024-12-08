package huffman;

import huffman.utility.BinaryStringReader;
import huffman.utility.CharCodeWithMeta;

import java.util.HashMap;

public class HuffmanStringDecoder {
    private BinaryStringReader reader;
    private HashMap<CharCodeWithMeta, Character> codeToChar;
    private StringBuilder decoded;

    private void decodeCodes() {
        byte codesNumber = (byte) reader.next((byte) 8);

        for (byte i = 0; i <= codesNumber; i++) {
            char ch = (char) reader.next((byte) 8);
            byte codeLength = (byte) reader.next((byte) 6);
            long code = reader.next(codeLength);

            codeToChar.put(new CharCodeWithMeta(code, codeLength), ch);
        }
    }

    private void decodeStr() {
        long code = 0;
        byte codeLength = 0;

        while (!reader.reachedEnd()) {
            if (code >= Long.MAX_VALUE / 2)
                throw new RuntimeException("ERROR! File is not valid");
            code = (code << 1) + (reader.nextBit() ? 1 : 0);
            codeLength++;

            var charCodeWithMeta = new CharCodeWithMeta(code, codeLength);
            if (codeToChar.containsKey(charCodeWithMeta)) {
                decoded.append(codeToChar.get(charCodeWithMeta));
                code = 0;
                codeLength = 0;
            }
        }

        if (code != 0)
            throw new RuntimeException("ERROR! File is not valid");
    }

    public HuffmanStringDecoder(final String data) {
        reader = new BinaryStringReader(data);
        codeToChar = new HashMap<>();
        decoded = new StringBuilder();

        decodeCodes();
        decodeStr();
    }

    public String getDecoded() {
        return decoded.toString();
    }
}
