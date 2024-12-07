# Наследование

## Практика #1

Объясните, как нужно использовать ключевые слова this и super в подклассах?

### Ответ

Ключевое слово ```this``` используется для ссылки на текущий объект и применяется для:

- Доступа к полям текущего класса
- Вызова методов текущего объекта
- Вызова другого конструктора текущего класса

Пример:

```java
public class Person {
    protected String name;
    
    public Person(String name) {
        this.name = name;   // Присваиваем в поле name значение параметра
    }

    public Person() {
        this("Forthey");    // Вызываем другой конструктор Person 
    }

    public void greet() {
        System.out.println("Hello, " + this.name + "!");
    }

    public void callGreet() {
        this.greet();       // Вызываем метод greet 
    }
}
```

Ключевое слово ```super``` используется для ссылки на элементы суперкласса (родительского класса) и применяется для:

- Доступа к скрытому полю суперкласса.
- Вызова метода суперкласса.
- Вызова конструктора суперкласса (super()).

Пример: 

```java
public class Forthey extends Person {
    public Forthey {
        super("Forthey");
    }
    
    public String getName() {
        super.greet();
        return super.name;
    }
}
```