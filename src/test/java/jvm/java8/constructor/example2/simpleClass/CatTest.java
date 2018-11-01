package jvm.java8.constructor.example2.simpleClass;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class CatTest {

    @Test
    public void instanciateCatWithRequiredFields() {
        final var cat = new Cat(42, "Moquette");
        assertThat(cat.getSize()).isEqualTo(42);
        assertThat(cat.getName()).isEqualTo("Moquette");
    }

    @Test(expected = NullPointerException.class)
    public void instanciateCatWithMissingRequiredField() {
        new Cat(42, null);
        fail("Expected Exception not thrown");
    }
}
