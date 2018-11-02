package jvm.java8.constructor.example5.serializeJackson.externalPackage;

import com.fasterxml.jackson.databind.ObjectMapper;
import jvm.java8.constructor.example5.serializeJackson.Cat;
import jvm.java8.constructor.example5.serializeJackson.CatSj;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;

public class SerializeCatTest {
    @Test
    public void serializeAllFieldsCat() throws IOException {
        final var inCat = new Cat(OptionalInt.of(42), Optional.of("maow"), "white");
        final var objectMapper = new ObjectMapper();
        final var json = objectMapper.writeValueAsString(inCat);
        final var outCat = objectMapper.readValue(json, Cat.class);
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
        final var inCat = CatSj.FuncWithDefaultValue.constructor(null, 1, null, 1,"white");
        final var objectMapper = new ObjectMapper();
        final var json = objectMapper.writeValueAsString(inCat);
        final var outCat = objectMapper.readValue(json, Cat.class);
        assertThat(outCat).isEqualTo(inCat);
        assertThat(outCat.getSize()).isPresent()
                .hasValue(26);
        assertThat(outCat.getName()).isNotPresent();
        assertThat(outCat.getColor())
                .isEqualTo("white");
    }
}
