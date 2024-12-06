# Классы-оболочки

## Практика #4

Какие значения напечатает следующий код?


```java
int i1 = 128;
Integer a1 = i1;
Integer b1 = i1;
System.out.println("a1==i1 " + (a1 == i1));
System.out.println("b1==i1 " + (b1 == i1));
System.out.println("a1==b1 " + (a1 == b1));
System.out.println("a1.equals(i1) -> " + a1.equals(i1));
System.out.println("b1.equals(i1) -> " + b1.equals(i1));
System.out.println("a1.equals(b1) -> " + a1.equals(b1));

int i2 = 127;
Integer a2 = i2;
Integer b2 = i2;
System.out.println("a2==i2 " + (a2 == i2));
System.out.println("b2==i2 " + (b2 == i2));
System.out.println("a2==b2 " + (a2 == b2));
System.out.println("a2.equals(i2) -> " + a2.equals(i2));
System.out.println("b2.equals(i2) -> " + b2.equals(i2));
System.out.println("a2.equals(b2) -> " + a2.equals(b2));
```
Объясните полученный результат. Для чего используется класс IntegerCache?

### Ответ

Вывод в консоль:

```shell
a1==i1 true
b1==i1 true
a1==b1 false
a1.equals(i1) -> true
b1.equals(i1) -> true
a1.equals(b1) -> true
a2==i2 true
b2==i2 true
a2==b2 true
a2.equals(i2) -> true
b2.equals(i2) -> true
a2.equals(b2) -> true
```

Объяснения каждого результата в папке src

IntegerCache - это внутренний класс внутри Integer, который хранит кэшированные значения для объектов-обёрток Integer в определённом диапазоне.  
Класс используется для оптимизации производительности и экономии памяти путём кеширования часто используемых объектов типа Integer.