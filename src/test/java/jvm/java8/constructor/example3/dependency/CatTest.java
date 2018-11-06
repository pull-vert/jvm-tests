package jvm.java8.constructor.example3.dependency;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class CatTest {

    @Test
    public void instanciateCatWithoutFields() {
        final var cat = CatSj.FuncWithDefaultValue.constructor(null, 1, null, 1);
        assertThat(cat.getSize()).isEqualTo(26);
        assertThat(cat.getName()).isEqualTo("Grumpy");
    }

    @Test
    public void instanciateCatWithFields() {
        final var cat = new Cat(42, "Moquette");
        assertThat(cat.getSize()).isEqualTo(42);
        assertThat(cat.getName()).isEqualTo("Moquette");
    }

    @Test(expected = NullPointerException.class)
    public void instanciateCatWithNullField_Exception() {
        new Cat(42, null);
        fail("Expected Exception not thrown");
    }
}
