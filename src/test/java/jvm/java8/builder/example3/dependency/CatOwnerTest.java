package jvm.java8.builder.example3.dependency;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CatOwnerTest {
    @Test
    public void increaseSize() {
        final var cat = Cat.builder()
                .withSize(42)
                .withName("Moquette")
                .build();
        assertThat(cat.getSize()).isEqualTo(42);
        assertThat(cat.getName()).isEqualTo("Moquette");
        final var catOwner = CatOwner.builder().withCat(cat).build();
        catOwner.increaseSize();
        assertThat(cat.getSize()).isEqualTo(44);
    }

    @Test
    public void changeName() {
        final var cat = Cat.builder()
                .withSize(42)
                .withName("Moquette")
                .build();
        assertThat(cat.getSize()).isEqualTo(42);
        assertThat(cat.getName()).isEqualTo("Moquette");
        final var catOwner = CatOwner.builder().withCat(cat).build();
        catOwner.changeName(" is wonderful");
        assertThat(cat.getName()).isEqualTo("Moquette is wonderful");
    }
}
