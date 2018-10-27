package jvm.java8.test6;

public interface Animal<T extends Food> {
    void eat(T food);
}
