package jvm.java8.example2.simpleClass;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class CatTest {

    @Test
    public void instanciateCatWithRequiredFields() {
        final var cat = Cat.builder(42, "Moquette")
                .build();
        assertThat(cat.getSize()).isEqualTo(42);
        assertThat(cat.getName()).isEqualTo("Moquette");
    }

    @Test(expected = NullPointerException.class)
    public void instanciateCatWithMissingRequiredField() {
        Cat.builder(42, null)
                .build();
        fail("Expected Exception not thrown");
    }
}
