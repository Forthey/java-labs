public class Main {
    public static void main(String[] args) {
        int i1 = 128;
        Integer a1 = i1;
        Integer b1 = i1;
        System.out.println("a1==i1 " + (a1 == i1));                 // true, так как Integer при сравнении с int производит автораспаковку и сравнивает значения
        System.out.println("b1==i1 " + (b1 == i1));                 // true, так как Integer при сравнении с int производит автораспаковку и сравнивает значения
        System.out.println("a1==b1 " + (a1 == b1));                 // false, так как сравниваются адреса различных объектов Integer
        System.out.println("a1.equals(i1) -> " + a1.equals(i1));    // true, так как equals сравнивает значения с распаковкой
        System.out.println("b1.equals(i1) -> " + b1.equals(i1));    // true, так как equals сравнивает значения с распаковкой
        System.out.println("a1.equals(b1) -> " + a1.equals(b1));    // true, так как equals сравнивает значения с распаковкой

        int i2 = 127;
        Integer a2 = i2;
        Integer b2 = i2;
        System.out.println("a2==i2 " + (a2 == i2));                 // true, так как Integer при сравнении с int производит автораспаковку и сравнивает значения
        System.out.println("b2==i2 " + (b2 == i2));                 // true, так как Integer при сравнении с int производит автораспаковку и сравнивает значения
        System.out.println("a2==b2 " + (a2 == b2));                 // true, так как в этот раз адреса объектов совпадают - так как были получены из кеша, диапазон которого от -128 до 127
        System.out.println("a2.equals(i2) -> " + a2.equals(i2));    // true, так как equals сравнивает значения с распаковкой
        System.out.println("b2.equals(i2) -> " + b2.equals(i2));    // true, так как equals сравнивает значения с распаковкой
        System.out.println("a2.equals(b2) -> " + a2.equals(b2));    // true, так как equals сравнивает значения с распаковкой
    }
}
