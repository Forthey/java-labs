# Оператор выбора

## Практика #2

Что произойдет, если в некоторых частях case будет отсутствовать break, как в следующем примере?

```java
case 1:
    i = 1;
    break;
case 2:
    i = 2;
case 3:
    i = 3;
    break;
```

### Ответ

Если при выполнении кода не будет встречен оператор ```break``` после попадания в ```case```, то программа не выйдет из ```switch```, а "провалится" в следующий по списку ```case``` и начнёт выполнять его код. То есть выполнение продолжится до следующего оператора ```break```, либо до конца ```switch```.  
В вышеупомянутом примере, при попадании в ```case 2```, выполнится сначала ```i = 2;```, а затем ```i = 3;```