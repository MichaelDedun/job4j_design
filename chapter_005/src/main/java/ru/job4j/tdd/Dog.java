package ru.job4j.tdd;

public class Dog {

   private int age;

    public Dog(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                '}';
    }
}
