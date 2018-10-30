package jvm.java8.builder.example3.dependency;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class CatTest {

    @Test
    public void instanciateCatWithoutFields() {
        final var cat = Cat.builder()
                .build();
        assertThat(cat.getSize()).isEqualTo(26);
        assertThat(cat.getName()).isEqualTo("Grumpy");
    }

    @Test
    public void instanciateCatWithFields() {
        final var cat = Cat.builder()
                .withSize(42)
                .withName("Moquette")
                .build();
        assertThat(cat.getSize()).isEqualTo(42);
        assertThat(cat.getName()).isEqualTo("Moquette");
    }

    @Test(expected = NullPointerException.class)
    public void instanciateCatWithNullField_Exception() {
        Cat.builder()
                .withName(null)
                .build();
        fail("Expected Exception not thrown");
    }
}
