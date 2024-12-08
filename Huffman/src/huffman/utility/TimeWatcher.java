package huffman.utility;

public class TimeWatcher {
    private static boolean isOn = false;

    private long timePoint;
    private String lastSuite;

    public static void setIsOn(boolean isOn) {
        TimeWatcher.isOn = isOn;
    }

    public void start(String suite) {
        if (!isOn) return;
        lastSuite = suite;
        timePoint = System.nanoTime();
    }
    public void stop() {
        if (!isOn) return;
        long timeDelta = System.nanoTime() - timePoint;
        System.out.printf("[[%s]]: %dms\n", lastSuite, (timeDelta / 1_000_000));
    }
}
