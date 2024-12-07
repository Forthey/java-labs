import java.util.ArrayList;

public class SuperExample {
    public static void addBaseClass(ArrayList<? super BaseClass> list) {
        // Можно добавить BaseClass
        list.add(new BaseClass());
    }
}
