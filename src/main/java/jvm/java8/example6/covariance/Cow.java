package jvm.java8.example6.covariance;

public class Cow implements Animal<Grass> {
    @Override
    public void eat(Grass food) {

    }
}
