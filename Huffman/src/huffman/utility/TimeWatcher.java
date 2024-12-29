package huffman.utility;

/**
 * Utility class for measuring execution time of code sections.
 * Can be enabled or disabled globally to control whether timing is logged.
 */
public class TimeWatcher {
    private static boolean isOn = false;

    private long timePoint;
    private String lastSuite;

    /**
     * Enables or disables the {@code TimeWatcher}.
     * When disabled, timing measurements and logs will be skipped.
     *
     * @param isOn {@code true} to enable timing, {@code false} to disable it.
     */
    public static void setIsOn(boolean isOn) {
        TimeWatcher.isOn = isOn;
    }

    /**
     * Starts measuring time for a specific suite.
     *
     * @param suite A name or label for the code section being timed.
     *              This will be included in the timing log.
     */
    public void start(String suite) {
        if (!isOn) return;
        lastSuite = suite;
        timePoint = System.nanoTime();
    }

    /**
     * Stops the timing measurement and logs the elapsed time.
     * The elapsed time is printed in milliseconds, along with the suite name.
     */
    public void stop() {
        if (!isOn) return;
        long timeDelta = System.nanoTime() - timePoint;
        System.out.printf("[[%s]]: %dms\n", lastSuite, (timeDelta / 1_000_000));
    }
}
