# Байтовые и символьные потоки ввода/вывода

## Практика #3

Если есть иерархия байтовых потоков ввода-вывода, основанная на абстрактных классах `InputStream` и `OutputStream`, то зачем дополнительные иерархии, основанные на абстрактных классах `Reader` и `Writer`?

## Ответ

Дополнительные иерархии, основанные на абстрактных классах `Reader` и `Writer`, предназначены для работы с текстовыми данными (символами), а не с байтами. Эти классы были введены для удобной работы с текстовой информацией, учитывая особенности символов и кодировок. 

Примеры возможностей `Reader` и `Writer`, которые удобны для работы с текстом и бессмысленны при работе с произвольным потоком данных:

- Чтение/запись строк (`BufferedReader.readLine()`, `PrintWriter.println()`).
- Чтение/запись массивов символов.