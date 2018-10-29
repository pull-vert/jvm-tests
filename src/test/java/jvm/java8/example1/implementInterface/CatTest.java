package jvm.java8.example1.implementInterface;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CatTest {

    @Test
    public void maxSpeed() {
        final var cat = Cat.Builder.newBuilder()
                .build();
        assertThat(cat.maxSpeed()).isEqualTo(12);
    }

    @Test
    public void printMaxSpeed() {
        final var cat = Cat.Builder.newBuilder()
                .build();
        cat.printMaxSpeed();
    }
}
