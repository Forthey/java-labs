public class Main {
    public static void main(String[] args) {
        // number имеет тип double
        var number = 1.0;

        // numberFloat имеет тип float
        var numberFloat = 1.0f;

        // var лучше использовать в случаях, когда нужно избежать избыточного повторения типов, особенно в случае с дженериками
        var object = new SomeObject<Integer>(1);

        // Не стоит использовать var в случаях, когда тип переменной нельзя понять из текущего кода
        var someVariable = SomeObject.getSomething(); // Непонятно, какой тип имеет переменная someVariable
    }
}