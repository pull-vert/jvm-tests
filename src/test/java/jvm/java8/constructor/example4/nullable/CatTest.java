package jvm.java8.constructor.example4.nullable;

import org.junit.Test;

import java.util.Optional;
import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class CatTest {

    @Test
    public void instanciateCatWithoutFields() {
        final var cat = CatSj.FuncWithDefaultValue.constructor(null, 1, null, 1);
        assertThat(cat.getSize()).hasValue(26);
        assertThat(cat.getName()).isEmpty();
    }

    @Test
    public void instanciateCatWithFields() {
        final var cat = new Cat(OptionalInt.of(42), Optional.of("Moquette"));
        assertThat(cat.getSize()).hasValue(42);
        assertThat(cat.getName()).hasValue("Moquette");
    }

    @Test(expected = NullPointerException.class)
    public void instanciateCatWithNullField_Exception() {
        new Cat(null, Optional.of("Moquette"));
        fail("Expected Exception not thrown");
    }

    @Test
    public void setter() {
        final var cat = new Cat(OptionalInt.of(42), Optional.of("Moquette"));
        assertThat(cat.getSize()).hasValue(42);
        assertThat(cat.getName()).hasValue("Moquette");
        cat.setSize(OptionalInt.of(35));
        cat.setName(Optional.of("Lillith"));
        assertThat(cat.getSize()).hasValue(35);
        assertThat(cat.getName()).hasValue("Lillith");
    }

    @Test(expected = NullPointerException.class)
    public void setterNull_Exception() {
        final var cat = new Cat(OptionalInt.of(42), Optional.of("Moquette"));
        assertThat(cat.getSize()).hasValue(42);
        assertThat(cat.getName()).hasValue("Moquette");
        cat.setSize(null);
        fail("Expected Exception not thrown");
    }
}
