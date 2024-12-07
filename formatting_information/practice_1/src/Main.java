import java.util.Formatter;

public class Main {
    public static void main(String[] args) {
        var formatter = new Formatter();
        System.out.println(formatter.format("%b %d %h %e %%", false, 100, 100, 100.0)); // "false 100 64 1,000000e+02 %"
    }
}