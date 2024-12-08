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
};

// TODO Переписать на Java, чтобы работало с HashMap
//template<>
//struct std::hash<CharCodeWithMeta> {
//    std::size_t operator()(const CharCodeWithMeta &key) const {
//        return key.code >= key.length ? key.code * key.code + key.code + key.length : key.code +
//                key.length * key.length;
//    }
//};
