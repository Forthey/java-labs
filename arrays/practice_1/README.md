# Массивы

## Практика #1

Что произойдет в результате выполнения следующего кода?

```java
int a1[] = {1,2,3,4,5};
int a2[] = {6,7,8,9,10};
a1 = a2;
```

### Ответ

a1 и a2 будут ссылаться на один и тот же массив {6, 7, 8, 9, 10}, в то время как массив {1, 2, 3, 4, 5}, изначально связанный с a1, становится недоступным и может быть удалён сборщиком мусора.