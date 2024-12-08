import huffman.Huffman;

public class Main {
    public static void main(String[] args) {
        Huffman.compress("img.png", "out.huff");
        Huffman.decompress("out.huff", "img_dec.png");
    }
}
