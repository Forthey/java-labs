# Логические блоки

## Практика #1

Что выведет данный код и почему?

```java
public class A {
    {
        System.out.println("logic (1) id= " + this.id);
    }

    static {
        System.out.println("static logic");
    }

    private int id = 1;

    public A(int id) {
        this.id = id;
        System.out.println("ctor id= " + id);
    }

    {
        System.out.println("logic (2) id= " + id);
    }
}

public class Main {
    public static void main(String[] args) {
        new A(100);
    }
}
```

### Ответ

```shell
static logic
logic (1) id= 0
logic (2) id= 1
ctor id= 100
```

**Объяснение**

При загрузке класса A один раз выполняется статический блок 
```java
static {
    System.out.println("static logic");
}
```
При создании экземпляра класса

```java
    new A(100);
```

1. Выполняется первый нестатический блок - на момент его выполнения id не проинициализировано - равно 0 

```java
{
    System.out.println("logic (1) id= " + this.id);
}
```

2. Инициализируется поле id 

```java
private int id = 1;
```

2. Выполняется второй нестатический блок - на момент его выполнения id проинициализировано и равно 1

```java
{
    System.out.println("logic (2) id= " + id);
}
```

3. Выполняется конструктор - значение поля id изменяется на значение параметра id (=100) и опять выводится на экран

```java
public A(int id) {
    this.id = id;
    System.out.println("ctor id= " + id);
}
```