public class Main {
    public static void main(String[] args) {
        // int и double
        {
            int intVal = 1;
            double doubleVal = 2.3;

            // Результаты имеют тип double
            System.out.printf(
                    "Результаты int и double: %f (+), %f (-), %f (*), %f (/)\n",
                    intVal + doubleVal, intVal - doubleVal, intVal * doubleVal, intVal / doubleVal
            );
        }

        // float и double
        {
            float floatVal = 1.2f;
            double doubleVal = 2.3;

            // Не будет работать - так как результатом сложения будет double
            // float res = a + b;

            System.out.printf("Сложение float и double: %f\n", floatVal + doubleVal);
        }

        // int и byte
        {
            byte byteVal = 1;
            int intVal = 4;

            // Не будет работать - так как результатом сложения будет int
            // byte res = a + b;

            System.out.printf("Сложение byte и int: %d\n", byteVal + intVal);
        }

        // String
        {
            String str1 = "hello, ", str2 = "world! ";
            double val = 30.0;

            // Строки a и b соединятся между собой, и затем будет добавлена строка "30.0"
            System.out.printf("Сложение 2х String и double: %s\n", str1 + str2 + val);
        }
    }
}