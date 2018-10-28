package jvm.java8.example6.covariance;

public interface Animal<T extends Food> {
    void eat(T food);
}
