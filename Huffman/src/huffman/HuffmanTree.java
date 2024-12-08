package huffman;

import huffman.utility.CharCodeWithMeta;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class HuffmanTree {
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

    public static class Node {
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

    Node root;

    public HuffmanTree(final byte[] data) {
        root = buildHuffmanTree(countBytes(data)).root;
    }

    public HuffmanTree(byte b, long freq) {
        root = new Node(b, freq, null, null);
    }

    public HuffmanTree(HuffmanTree left, HuffmanTree right) {
        root = new Node((byte) 0, left.root.freq + right.root.freq, left.root, right.root);
    }

    HashMap<Byte, CharCodeWithMeta> buildCodes() {
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
