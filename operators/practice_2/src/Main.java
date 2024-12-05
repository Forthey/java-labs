public class Main {
    public static void main(String[] args) {
        BaseClass inheritedInst = new InheritedClass();
        BaseClass otherInst = new OtherInheritedClass();

        // Будет выведено "hello"
        if (inheritedInst instanceof InheritedClass casted) {
            casted.hello();  // Можно безопасно привести к типу и вызвать функцию
        } else {
            System.out.println("It is not an instance!!!");
        }

        // Будет выведено "It is not an instance!!!"
        if (otherInst instanceof InheritedClass) {
            ((InheritedClass) inheritedInst).hello();
        } else {
            System.out.println("It is not an instance!!!");
        }

        // Когда оператор instanceof применяется к null, он всегда возвращает false, поскольку null не является экземпляром какого-либо класса.
        InheritedClass nullInst = null;

        if (nullInst instanceof InheritedClass) {
            System.out.println("Unreachable code");
        } else {
            System.out.println("null is not an instance of anything");
        }
    }
}
