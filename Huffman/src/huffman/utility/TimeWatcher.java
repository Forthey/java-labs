package huffman.utility;

public class TimeWatcher {
    private long timePoint;
    private String lastSuite;

    public void start(String suite) {
        lastSuite = suite;
        timePoint = System.nanoTime();
    }
    public void stop() {
        long timeDelta = System.nanoTime() - timePoint;
        System.out.printf("[[%s]]: %dms\n", lastSuite, (timeDelta / 1_000_000));
    }
}
