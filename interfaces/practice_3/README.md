# Интерфейсы

## Практика #3

Объясните, какая область видимости у интерфейса, объявленного следующим образом.

```java
protected interface Interface {
  ...
}
```

### Ответ

В Java интерфейс не может быть объявлен с модификатором доступа protected на уровне файла. Это связано с тем, что модификатор protected используется для управления доступом к членам класса (полям и методам) и не может применяться к интерфейсам или классам на верхнем уровне