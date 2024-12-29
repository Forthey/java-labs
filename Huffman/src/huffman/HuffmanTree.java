package huffman;

import huffman.utility.CharCodeWithMeta;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Represents a Huffman Tree used for encoding and decoding data using Huffman coding.
 * This class is responsible for building the Huffman tree, generating codes, and managing the tree structure.
 */
public class HuffmanTree {
    /**
     * A private static class representing a node in the Huffman Tree.
     */
    private static class Node {
        public byte b;
        public long freq;

        Node left, right;

        public Node(byte b, long freq, Node left, Node right) {
            this.b = b;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    /**
     * Constructs a HuffmanTree from the provided data.
     * The tree is built based on the frequency of bytes in the input data.
     *
     * @param data The input data to be encoded using the Huffman tree.
     */
    public HuffmanTree(final byte[] data) {
        root = buildHuffmanTree(countBytes(data)).root;
    }

    /**
     * Constructs a HuffmanTree with a single node.
     *
     * @param b     The byte represented by the root node.
     * @param freq  The frequency of the byte.
     */
    public HuffmanTree(byte b, long freq) {
        root = new Node(b, freq, null, null);
    }

    /**
     * Constructs a HuffmanTree by merging two other Huffman trees.
     *
     * @param left  The left subtree.
     * @param right The right subtree.
     */
    public HuffmanTree(HuffmanTree left, HuffmanTree right) {
        root = new Node((byte) 0, left.root.freq + right.root.freq, left.root, right.root);
    }

    /**
     * Counts the frequency of each byte in the provided data.
     *
     * @param data The input data.
     * @return A map where keys are bytes and values are their frequencies.
     */
    private static HashMap<Byte, Long> countBytes(final byte[] data) {
        var charFrequency = new HashMap<Byte, Long>();

        for (byte ch : data) {
            if (!charFrequency.containsKey(ch))
                charFrequency.put(ch, 1L);
            else
                charFrequency.put(ch, charFrequency.get(ch) + 1);
        }

        return charFrequency;
    }

    /**
     * Builds the Huffman tree from a frequency map of bytes.
     *
     * @param characterFreq A map where keys are bytes and values are their frequencies.
     * @return The root of the constructed Huffman tree.
     */
    private static HuffmanTree buildHuffmanTree(final HashMap<Byte, Long> characterFreq) {
        var symbolsQueue = new PriorityQueue<HuffmanTree>(Comparator.comparingLong(tree -> tree.root.freq));

        for (Byte ch : characterFreq.keySet()) {
            symbolsQueue.add(new HuffmanTree(ch, characterFreq.get(ch)));
        }

        while (symbolsQueue.size() > 1) {
            HuffmanTree tree1 = symbolsQueue.remove();
            HuffmanTree tree2 = symbolsQueue.remove();

            symbolsQueue.add(new HuffmanTree(tree1, tree2));
        }

        return symbolsQueue.peek();
    }

    /**
     * Builds the Huffman codes for the bytes based on the tree structure.
     *
     * @return A map where keys are bytes and values are their Huffman codes with metadata.
     */
    public HashMap<Byte, CharCodeWithMeta> buildCodes() {
        class TraversingData {
            public Node node;
            public final CharCodeWithMeta nodeCode;

            public TraversingData(Node node, CharCodeWithMeta nodeCode) {
                this.node = node;
                this.nodeCode = nodeCode;
            }
        }

        var codes = new HashMap<Byte, CharCodeWithMeta>();

        // If text contains only 1 character
        if (root.left == null & root.right == null) {
            codes.put(root.b, new CharCodeWithMeta(1L, (byte) 1));
            return codes;
        }

        var stack = new Stack<TraversingData>();

        stack.push(new TraversingData(root, new CharCodeWithMeta(0L, (byte) 0)));

        while (!stack.empty()) {
            TraversingData data = stack.pop();

            if (data.node.left == null && data.node.right == null) {
                codes.put(data.node.b, data.nodeCode);
                continue;
            }

            stack.push(new TraversingData(
                    data.node.left, new CharCodeWithMeta(
                    data.nodeCode.code << 1, (byte) (data.nodeCode.length + (byte) 1))
            ));

            stack.push(new TraversingData(
                    data.node.right, new CharCodeWithMeta(
                    (data.nodeCode.code << 1) + 1, (byte) (data.nodeCode.length + (byte) 1))
            ));
        }

        return codes;
    }
}
