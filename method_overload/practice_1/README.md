# Перегрузка методов

## Практика #1

Объясните, почему в цикле for (1) будут другие результаты, чем в следующих затем вызовах (2), хотя аргументы одинаковые?

```java
public class A {
    public void printNum(Integer i)
    {
        System.out.printf("Integer = %d%n", i);
    }
    public void printNum(int i)
    {
        System.out.printf("int = %d%n", i);
    }
    public void printNum(Float f)
    {
        System.out.printf("Float = %.4f%n", f);
    }
    public void printNum(Number n)
    {
        System.out.println("Number=" + n);
    }
}


public class Main {
    public static void main(String[] args) {
        A a = new A();
        Number[ ] num = {new Integer(1), 11, 1.11f, 11.11 };
        // цикл for (1)
        for (Number n : num) {
            a.printNum(n);
        }
        // (2)
        a.printNum(new Integer(1));
        a.printNum(11);
        a.printNum(1.11f);
        a.printNum(11.11);
    }
}
```

### Ответ

Вывод

```shell
Number=1
Number=11
Number=1.11
Number=11.11
Integer = 1
int = 11
Float = 1,1100
Number=11.11
```

**Объяснение**

Аргументы хранят одинаковое числовое значение, но имеют разный тип  

В цикле for (1)

```java
for (Number n : num) {
    a.printNum(n);
}
```

в метод printNum передаётся параметр с типом Number - что приводит к вызову перегрузки с параметром типа Number  

В вызовах (2)

```java
a.printNum(new Integer(1));
a.printNum(11);
a.printNum(1.11f);
a.printNum(11.11);
```

в метод printNum передаётся параметр с типом Integer, int, float и double соответственно.
1. Для Integer и int есть явная перегрузка - она будет и вызвана в соответствующих случаях
2. Для float и double вызовется перегрузка с параметрами подходящих классов-оболочек - Float и Number соответственно