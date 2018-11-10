package jvm.java8.constructor.example3.dependency;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CatOwnerTest {
    @Test
    public void increaseSize() {
        final var cat = new Cat(42, "Moquette");
        assertThat(cat.getSize()).isEqualTo(42);
        assertThat(cat.getName()).isEqualTo("Moquette");
        final var catOwner = new CatOwner(cat);
        catOwner.increaseSize();
        assertThat(cat.getSize()).isEqualTo(44);
    }

    @Test
    public void changeName() {
        final var cat = new Cat(42, "Moquette");
        assertThat(cat.getSize()).isEqualTo(42);
        assertThat(cat.getName()).isEqualTo("Moquette");
        final var catOwner = new CatOwner(cat);
        catOwner.changeName(" is wonderful");
        assertThat(cat.getName()).isEqualTo("Moquette is wonderful");
    }
}
