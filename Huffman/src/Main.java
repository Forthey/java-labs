import huffman.Huffman;

public class Main {
    public static void main(String[] args) {
//        Huffman.compress("test.txt", "out.huff");
//        Huffman.decompress("out.huff", "test_dec.txt");
        Huffman.compress("img.png", "out.huff");
        Huffman.decompress("out.huff", "img_dec.png");
    }
}
