package huffman.utility;

/**
 * Represents a character code with additional metadata about its length.
 * Used in Huffman coding to store the binary representation of a character and its length.
 */
public class CharCodeWithMeta {
    /**
     * The binary representation of the character code.
     */
    public long code;
    /**
     * The length of the binary code in bits.
     */
    public byte length;

    /**
     * Constructs a {@code CharCodeWithMeta} with the specified code and length.
     *
     * @param code   The binary representation of the character code.
     * @param length The length of the binary code in bits.
     */
    public CharCodeWithMeta(long code, byte length) {
        this.code = code;
        this.length = length;
    }

    /**
     * Checks if this {@code CharCodeWithMeta} is equal to another object.
     *
     * @param other The object to compare with.
     * @return {@code true} if the other object is an instance of {@code CharCodeWithMeta} and has the same code and length; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        if (this == other) return true;

        CharCodeWithMeta c = (CharCodeWithMeta) other;
        return this.code == c.code && length == c.length;
    }

    /**
     * Computes the hash code for this {@code CharCodeWithMeta}.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return (int) (code >= length ? code * code + code + length : code + length * length);
    }
};
