package jvm.java8.example5.serializeJackson.externalPackage;

import com.fasterxml.jackson.databind.ObjectMapper;
import jvm.java8.example5.serializeJackson.Cat;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;

public class SerializeCatTest {
    @Test
    public void serializeAllFieldsCat() throws IOException {
        final var inCat = Cat.builder("white")
            .withSize(OptionalInt.of(42))
            .withName(Optional.of("maow"))
            .build();
        final var objectMapper = new ObjectMapper();
        final var json = objectMapper.writeValueAsString(inCat);
        final var outCat = objectMapper.readValue(json, Cat.Api.class);
        assertThat(outCat).isEqualTo(inCat);
        assertThat(outCat.getSize()).isPresent()
                .hasValue(42);
        assertThat(outCat.getName()).isPresent()
                .containsInstanceOf(String.class)
                .hasValue("maow");
        assertThat(outCat.getColor())
                .isEqualTo("white");
    }

    @Test
    public void serializeOnlyRequiredFieldsCat() throws IOException {
        final var inCat = Cat.builder("white")
                .build();
        final var objectMapper = new ObjectMapper();
        final var json = objectMapper.writeValueAsString(inCat);
        final var outCat = objectMapper.readValue(json, Cat.Api.class);
        assertThat(outCat).isEqualTo(inCat);
        assertThat(outCat.getSize()).isPresent()
                .hasValue(26);
        assertThat(outCat.getName()).isNotPresent();
        assertThat(outCat.getColor())
                .isEqualTo("white");
    }
}
