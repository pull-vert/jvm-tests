package jvm.java8.constructor.example4.nullable;

import org.junit.Test;

import java.util.Optional;
import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;

public class CatOwnerTest {
    @Test
    public void increaseSize() {
        final var cat = new Cat(OptionalInt.of(42), Optional.of("Moquette"));
        assertThat(cat.getSize()).hasValue(42);
        assertThat(cat.getName()).hasValue("Moquette");
        final var catOwner = new CatOwner(cat);
        catOwner.increaseSize();
        assertThat(cat.getSize()).hasValue(44);
    }

    @Test
    public void changeName() {
        final var cat = new Cat(OptionalInt.of(42), Optional.of("Moquette"));
        assertThat(cat.getSize()).hasValue(42);
        assertThat(cat.getName()).hasValue("Moquette");
        final var catOwner = new CatOwner(cat);
        catOwner.changeName(" is wonderful");
        assertThat(cat.getName()).hasValue("Moquette is wonderful");
    }
}
