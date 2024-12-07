import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // ArithmeticException
        try {
            int a = 3 / 0;                                          // Делим на 0
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());                     // / by zero
        }

        // ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[3]);                             // Индекс вне диапазона
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());                     // Index 3 out of bounds for length 3
        }

        // IllegalArgumentException
        try {
            var arrayList = new ArrayList<Integer>(-10);// Передаем отрицательное значение в конструктор ArrayList
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());                     // Illegal Capacity: -10
        }

        // ClassCastException
        try {
            var arrayList = new ArrayList();
            arrayList.add("Hello");                                 // Добавляем строку
            Integer number = (Integer) arrayList.get(0);            // Пытаемся привести объект к Integer
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());                     // class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
        }

        // NullPointerException
        try {
            String str = null;
            int length = str.length();                              // Обращение к методу объекта, равного null
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());                     // Cannot invoke "String.length()" because "str" is null
        }
    }
}
