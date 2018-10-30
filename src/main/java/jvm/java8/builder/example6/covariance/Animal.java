package jvm.java8.builder.example6.covariance;

public interface Animal<T extends Food> {
    void eat(T food);
}
