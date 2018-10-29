package jvm.java11.test5;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;

public class SerializeCatTest {
    @Test
    public void serializeCat() throws IOException {
        final var inCat = new Cat(OptionalInt.of(42), Optional.of("maow"));
        final var objectMapper = new ObjectMapper();
        final var json = objectMapper.writeValueAsString(inCat);
        final var outCat = objectMapper.readValue(json, Cat.class);
        assertThat(inCat.equals(outCat)).isTrue();
    }
}
