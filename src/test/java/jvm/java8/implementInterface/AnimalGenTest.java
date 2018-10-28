package jvm.java8.implementInterface;

import org.junit.Test;

public class AnimalGenTest {

    @Test
    public void generateAnimal() {
        Thread.currentThread().getContextClassLoader().getResourceAsStream("test1/Animal.sj");
    }
}
