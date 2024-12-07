public class Main {
    public static void main(String[] args) {
        // String -> StringBuffer
        String str = "Forthey";
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println(stringBuffer);   // Forthey

        // String -> StringBuilder
        StringBuilder stringBuilder = new StringBuilder(str);
        System.out.println(stringBuilder);  // Forthey

        // StringBuffer -> String
        str = stringBuffer.toString();
        System.out.println(str);            // Forthey

        // StringBuilder -> String
        str = stringBuilder.toString();
        System.out.println(str);            // Forthey

        // StringBuffer -> StringBuilder
        stringBuilder = new StringBuilder(stringBuffer.toString());
        System.out.println(stringBuilder);  // Forthey

        // StringBuilder -> StringBuffer
        stringBuffer = new StringBuffer(stringBuilder.toString());
        System.out.println(stringBuffer);   // Forthey
    }
}