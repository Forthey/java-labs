# Обработка нескольких исключений

## Практика #2

Что означает использование final при в данном объявлении?

```java
try {
   ...
} catch (final Exception e) {
   ...
}
```

## Ответ

Использование ключевого слова `final` в объявлении переменной e в блоке `catch` означает, что переменная `e` является константной и её значение нельзя изменить после инициализации.