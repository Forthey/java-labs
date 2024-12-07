import java.util.Objects;

public class Person {
    String name;
    String surname;
    Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                                                     // Сравнение ссылки
        if (o == null || getClass() != o.getClass()) return false;                      // Проверка типа

        Person p = (Person) o;                                                          // Приведение к типу Person

        return name.equals(p.name) && surname.equals(p.surname) && age.equals(p.age);   // Сравнение полей
    }

    // Переопределение метода hashCode() для совместимости с equals
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}
