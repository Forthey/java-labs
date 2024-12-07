import java.util.Calendar;
import java.util.Formatter;

public class Main {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        Calendar calendar = Calendar.getInstance();

        formatter.format("Current Date: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", calendar);
        System.out.println(formatter);          // Current Date: 2024-12-07 19:11:11

        formatter.close();
    }
}