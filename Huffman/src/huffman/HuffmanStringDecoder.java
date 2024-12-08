package huffman;

import huffman.utility.BinaryStringReader;
import huffman.utility.CharCodeWithMeta;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanStringDecoder {
    private BinaryStringReader reader;
    private HashMap<CharCodeWithMeta, Character> codeToChar;
    private ArrayList<Byte> decoded;

    private void decodeCodes() {
        char codesNumber = (char) reader.next((byte) 8);

        for (char i = 0; i <= codesNumber; i++) {
            char ch = (char) reader.next((byte) 8);
            byte codeLength = (byte) reader.next((byte) 6);
            long code = reader.next(codeLength);

            var charCodeWithMeta = new CharCodeWithMeta(code, codeLength);
            codeToChar.put(charCodeWithMeta, ch);
        }
    }

    private void decodeStr() {
        long code = 0;
        byte codeLength = 0;

        decoded.ensureCapacity(reader.length());

        while (!reader.reachedEnd()) {
            if (code >= Long.MAX_VALUE / 2)
                throw new RuntimeException("ERROR! File is not valid");
            code = (code << 1) + (reader.nextBit() ? 1 : 0);
            codeLength++;

            var charCodeWithMeta = new CharCodeWithMeta(code, codeLength);
            if (codeToChar.containsKey(charCodeWithMeta)) {
                decoded.add((byte) codeToChar.get(charCodeWithMeta).charValue());
                code = 0;
                codeLength = 0;
            }
        }

        if (code != 0)
            throw new RuntimeException("ERROR! File is not valid");
    }

    public HuffmanStringDecoder(final byte[] data) {
        reader = new BinaryStringReader(data);
        codeToChar = new HashMap<>();
        decoded = new ArrayList<>();

        decodeCodes();
        decodeStr();
    }

    public Byte[] getDecoded() {
        return decoded.toArray(new Byte[0]);
    }
}
