import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Примеры с <? extends>
        ExtendsExample.printNumbers(List.of(1, 2, 3, 4));           // Работает
        ExtendsExample.printNumbers(List.of(1.0, 2.1, 3.2, 4.3));   // Также работает
        // ExtendsExample.printNumbers(List.of("a", "b", "c", "d"));// Ошибка - String не является подклассом или классом Number

        // Примеры с <? super>
        var baseClassList = new ArrayList<BaseClass>();
        var objectList = new ArrayList<Object>();
        var inheritedFromBaseClassList = new ArrayList<InheritedFromBaseClass>();

        SuperExample.addBaseClass(baseClassList);                   // Работает
        SuperExample.addBaseClass(objectList);                      // Работает
        // SuperExample.addBaseClass(inheritedFromBaseClassList);   // Ошибка - InheritedFromBaseClass не является суперклассом BaseClass
    }
}