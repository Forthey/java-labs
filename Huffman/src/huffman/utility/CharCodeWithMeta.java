package huffman.utility;

public class CharCodeWithMeta {
    public long code;
    public byte length;

    public CharCodeWithMeta(long code, byte length) {
        this.code = code;
        this.length = length;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        if (this == other) return true;

        CharCodeWithMeta c = (CharCodeWithMeta) other;
        return this.code == c.code && length == c.length;
    }

    @Override
    public int hashCode() {
        return (int) (code >= length ? code * code + code + length : code + length * length);
    }
};
