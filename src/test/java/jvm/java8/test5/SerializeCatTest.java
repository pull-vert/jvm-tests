package jvm.java8.test5;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;

public class SerializeCatTest {
    @Test
    public void serializeCat() throws IOException {
        final var inCat = new Cat.Builder()
            .withSize(OptionalInt.of(42))
            .withName(Optional.of("maow"))
            .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(inCat);
        final var outCat = objectMapper.readValue(json, Cat.Api.class);
        assertThat(outCat).isEqualTo(inCat);
        assertThat(outCat.getSize()).isPresent()
                .hasValue(42);
        assertThat(outCat.getName()).isPresent()
                .containsInstanceOf(String.class)
                .hasValue("maow");
    }
}
