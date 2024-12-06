# Статические методы и поля

## Практика #1

Приведите все варианты вызова метода printVars()

```java
public class A {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }
}
```

### Ответ

1. Через имя класса A

```java
A.printVars();
```

2. Через экземпляр класса A (или анонимный объект)

```java
var a = new A();
a.printVars();
new A().printVars();
```

3. Из другого статического или нестатического метода класса A

```java
public class A {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }
    
    public static void callPrintVars() {
        printVars();
    }

    public void callPrintVarsNonStatic() {
        printVars();
    }
}
```
