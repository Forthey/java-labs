public class Main {
    public static void main(String[] args) {
        NumberEnum one = NumberEnum.ONE;
        NumberEnum two = NumberEnum.TWO;
        NumberEnum thirty = NumberEnum.THIRTY;

        System.out.printf("%d %s\n",one.getNumber(), one.usefulInfo());         // Вывод 1 This is one
        System.out.printf("%d %s\n",two.getNumber(), two.usefulInfo());         // Вывод 2 This is two
        System.out.printf("%d %s\n",thirty.getNumber(), thirty.usefulInfo());   // Вывод 30 This is thirty (best number)
    }
}
