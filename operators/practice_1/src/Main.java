public class Main {
    public static void main(String[] args) {
        // =
        int val = 100;
        int anotherVal = -1;

        // +=, -=, *=, /=, %=
        val += 10;  // val равно 110
        val -= 5;   // val равно 105
        val *= 2;   // val равно 210
        val /= 4;   // val равно 52
        val %= 3;   // val равно 1

        // Тернарный условный оператор ? :
        int maxValue = (val > anotherVal) ? val : anotherVal; // maxValue равно val

        // Логические операторы ||, &&
        boolean anyPositive = (val > 0) || (anotherVal > 0); // anyPositive равно true
        boolean allPositive = (val > 0) && (anotherVal > 0); // allPositive равно false

        // Побитовые операторы |, ^, &
        int bitwiseOrResult = val | anotherVal;   // Побитовое или
        int bitwiseXorResult = val ^ anotherVal;  // Побитовый XOR
        int bitwiseAndResult = val & anotherVal;  // Побитовое и

        // Операторы сравнения ==, >, >=, <, <=
        boolean isEqual = (val == anotherVal);          // isEqual равно false
        boolean isGreater = (val > anotherVal);         // isGreater равно true
        boolean isGreaterOrEqual = (val >= anotherVal); // isGreaterOrEqual равно true
        boolean isLess = (val < anotherVal);            // isLess равно false
        boolean isLessOrEqual = (val <= anotherVal);    // isLessOrEqual равно false

        // Побитовые сдвиги >>, >>>, <<
        int rightBitwiseShiftWithSignResult = anotherVal >> 1;  // Сдвиг битов вправо на 1 с сохранением знака (результат отрицательное число)
        int rightBitwiseShiftResult = anotherVal >>> 1;         // Сдвинуть битов вправо на 1 с заполнением нулем (результат положительное число)
        int leftBitwiseShiftResult = anotherVal << 1;           // Сдвиг битов влево на 1

        // Арифметические операторы +, -, *, /, %
        int sumResult = val + anotherVal;       // Сложение чисел
        int subResult = val - anotherVal;       // Вычитание чисел
        int mulResult = val * anotherVal;       // Умножение чисел
        int divResult = val / anotherVal;       // Деление чисел
        int remainderResult = val % anotherVal; // Остаток от деления одного числа на другое

        // Перегруженный оператор + у строк
        String hello = "hello, " + "world!"; // Конкатенация (соединение) строк

        // Унарные операторы ++ и -- и ~ и !
        val++;                      // Увеличение val на 1
        val--;                      // Уменьшение val на 1
        ++val;                      // Увеличение val на 1
        --val;                      // Уменьшение val на 1
        val = ~val;                 // Побитовое отрицание
        boolean notFalse = !false;  // Логическое отрицание

        // ( ) [ ]
        double sqrt = Math.sqrt(9);             // Вызов функций
        double priorityResult = (2 + 2) * 2;    // Приоритет операций
        int intSqrt = (int) sqrt;               // Приведение типов
        int[] array = new int[5];               // Создание массива
        array[0] = 1;                           // Обращение к элементу массива по индексу
    }
}