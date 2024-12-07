abstract class Weapon {
    // Переопределяемый метод
    String use() {
        return "...";
    }
}

class Pistol extends Weapon {
    // Ошибки нет - мы просто перегрузили метод use
    String use(String smth) {
        return smth;
    }

    // Ошибка есть - выполняется явная проверка компилятором, что метод должен переопределять метод суперкласса
    // @Override
    // String use(String smth) {
    //     return smth;
    // }
}