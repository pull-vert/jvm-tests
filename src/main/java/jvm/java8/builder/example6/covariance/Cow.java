package jvm.java8.builder.example6.covariance;

public class Cow implements Animal<Grass> {
    @Override
    public void eat(Grass food) {

    }
}
