abstract class Weapon {
    // Переопределяемый метод
    abstract String use();
}

class Pistol extends Weapon {
    // Ошибка: попытка использования неподходящего возвращаемого значения
    // void use() {
    // }

    // Переопределенный метод
    @Override
    String use() {
        return "Bang";
    }
}

public class Main {
    public static void main(String[] args) {
        Weapon weapon = new Pistol();

        System.out.println(weapon.use());
    }
}