import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] intArray = {5, 3, 4, 1, 2};

        // Arrays.toString преобразует массив в строковое представление
        String arrayAsStr = Arrays.toString(intArray);
        System.out.println(arrayAsStr);                                 // Вывод [5, 3, 4, 1, 2]

        // Arrays.sort сортирует массив в порядке не убывания
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));                  // Вывод [1, 2, 3, 4, 5]

        // Arrays.binarySearch ищет индекс элемента массива с заданным значением с помощью бинарного поиска
        // Массив должен быть отсортирован, иначе результат непредсказуем
        int indexOfOne = Arrays.binarySearch(intArray, 4);
        System.out.println(indexOfOne);                                 // Вывод 3

        // Arrays.equals позволяет проверить, равны ли массивы: под равенством подразумевается равная длина и равенство всех элементов
        int[] equalArray = {1, 2, 3, 4, 5};
        int[] notEqualArray = {1, 2, 0, 4, 5};
        System.out.println(Arrays.equals(intArray, equalArray));        // Вывод true
        System.out.println(Arrays.equals(intArray, notEqualArray));     // Вывод false

        // Arrays.compare сравнивает массивы поэлементно и возвращает:
        // 0 - если массивы равны
        // > 0 - если на 1-й неравный i-й элемент первого массива больше i-го элемента второго массива или если первый массив короче второго
        // < 0 - если на i-й неравный i-й элемент первого массива меньше i-го элемента второго массива или если первый массив длиннее второго
        int[] lessArray = {1, 1, 3, 4, 5};
        int[] moreArray = {1, 3, 3, 4, 5};
        int[] shorterArray = {1, 2, 3, 4};
        int[] longerArray = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.compare(intArray, lessArray));        // Вывод 1
        System.out.println(Arrays.compare(intArray, moreArray));        // Вывод -1
        System.out.println(Arrays.compare(intArray, shorterArray));     // Вывод -1
        System.out.println(Arrays.compare(intArray, longerArray));      // Вывод 1
        System.out.println(Arrays.compare(intArray, equalArray));       // Вывод 0
    }
}
