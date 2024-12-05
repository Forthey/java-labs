public class Main {
    public static void main(String[] args) {
        // Сужающее преобразование из double в int
        {
            double doubleVal = 30.1;
            System.out.println((int) doubleVal); // Выведет 30, дробная часть теряется
        }

        // Сужающее преобразование из short в byte
        {
            short shortVal1 = 10, shortVal2 = 200;
            // Без переполнения
            System.out.println((byte) shortVal1); // Выведет 10
            // С переполнением
            System.out.println((byte) shortVal2); // 200 при интерпретации двоичной записи с точки зрения byte станет равно -56
        }
    }
}