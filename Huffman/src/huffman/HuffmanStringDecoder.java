package huffman;

import huffman.utility.BinaryStringReader;
import huffman.utility.CharCodeWithMeta;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanStringDecoder {
    private BinaryStringReader reader;
    private HashMap<CharCodeWithMeta, Byte> codeToChar;
    private ArrayList<Byte> decoded;

    private void decodeCodes() {
        char codesNumber = (char) reader.next((byte) 8);

        for (char i = 0; i <= codesNumber; i++) {
            byte ch = (byte) reader.next((byte) 8);
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
                decoded.add(codeToChar.get(charCodeWithMeta));
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

    public byte[] getDecoded() {
        byte[] bytes = new byte[decoded.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) decoded.get(i);
        }
        return bytes;
    }
}
