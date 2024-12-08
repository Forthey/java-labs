package huffman.utility;

public class CharCodeWithMeta {
    public long code;
    public byte length;

    public CharCodeWithMeta(long code, byte length) {
        this.code = code;
        this.length = length;
    }

    public boolean equals(CharCodeWithMeta other) {
        if (other == null) return false;
        if (this == other) return true;

        return this.code == other.code && length == other.length;
    }

    @Override
    public int hashCode() {
        return (int) (code >= length ? code * code + code + length : code + length * length);
    }

};
