package jvm.java8.builder.example1.implementInterface;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CatTest {

    @Test
    public void maxSpeed() {
        final var cat = Cat.builder()
                .build();
        assertThat(cat.maxSpeed()).isEqualTo(12);
    }
}
