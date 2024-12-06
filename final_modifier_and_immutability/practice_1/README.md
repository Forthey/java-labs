# Модификатор final и неизменяемость

## Практика #1

Как можно проинициализировать константу, которая объявлена следующим образом? Приведите все возможные варианты.

```java
public class A {
    public final int a;
}

```

### Ответ

1. Инициализация при объявлении

```java
public class A {
    public final int a = 30;
}
```

2. Инициализация в конструкторе

```java
public class A {
    public final int a;
    
    public A() {
        a = 30;
    }
}
```

3. Инициализация в блоке инициализации

```java
public class A {
    public final int a;

    {
        a = 30;
    }
}
```