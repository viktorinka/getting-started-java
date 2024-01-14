package tests.lesson_10;

import java.util.List;

public class Person {
    public String name;
    public Integer age;
    public Boolean isMarried;
    public String spouse;
    public List<ContactNumbers> contactNumbers;
    public List<String> favoriteSports;
    public Car car;
    public static class Car {
        public String color;
        public Integer model;
    }

    public static class ContactNumbers {
        public String type;
        public String number;
    }
}
