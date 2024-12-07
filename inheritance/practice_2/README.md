# Наследование

## Практика #2

Объясните как спецификаторы private, protected, public и спецификатор по умолчанию, меняются при наследовании на следующем примере.

```java
class A {
  int a1;
  public int a2;
  protected int a3;
  private int a4;

  void method1() {
    ...
  }

  public void method2() {
    ...
  }

  protected void method3() {
    ...
  }
  
  private void method4() {
    ...
  }

}

class B extends A {
  ...
}

class C extends B {
  ...
}
```

### Ответ

Поле ```a1``` и метод ```method1``` доступны в классе A (через this), а также в B и C (через super), так они находятся в одном пакете

Поле ```a2``` и метод ```method2``` доступны везде, в том числе в классах A (через this), B и C (через super)

Поле ```a3``` и метод ```method3``` доступны в классах A (через this), B и C (через super, так как они наследники класса A) 

Поле ```a4``` и метод ```method4``` доступны только в классе A (через this)