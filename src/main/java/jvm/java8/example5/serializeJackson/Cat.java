/*
data class Cat(api var size: nullable Int = 26, api var name: nullable String = null, api val color: String) is Serializable
 */

package jvm.java8.example5.serializeJackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import internal.annotations.NotNull;
import internal.annotations.Nullable;
import internal.validation.Validation;

import java.io.Serializable;
import java.util.Optional;
import java.util.OptionalInt;

public final class Cat {

    // uninstanciable
    private Cat() {
    }

    public final static Builder builder(@NotNull final String color) {
        return new Builder(color);
    }

    @JsonDeserialize(builder = Builder.class)
    public static interface Api extends Serializable {
        @NotNull
        public OptionalInt getSize();

        public void setSize(@NotNull final OptionalInt size);

        @NotNull
        public Optional<String> getName();

        public void setName(@NotNull final Optional<String> name);

        @NotNull
        public String getColor();
    }

    @JsonPOJOBuilder(withPrefix = "withSerializable")
    public static final class Builder {
        @NotNull
        private OptionalInt size = OptionalInt.of(26);
        @NotNull
        private Optional<String> name = Optional.empty();
        @NotNull
        private String color;

        @JsonCreator
        Builder(@NotNull @JsonProperty("color") final String color) {
            Validation.checkParameterIsNotNull(color, "color");
            this.color = color;
        }

        public final Builder withSize(@NotNull final OptionalInt size) {
            Validation.checkParameterIsNotNull(size, "size");
            this.size = size;
            return this;
        }

        final Builder withSerializableSize(@Nullable final Integer size) {
            this.size = (null != size) ? OptionalInt.of(size) : OptionalInt.empty();
            return this;
        }

        public final Builder withName(@NotNull final Optional<String> name) {
            Validation.checkParameterIsNotNull(name, "name");
            this.name = name;
            return this;
        }

        final Builder withSerializableName(@Nullable final String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        public Api build() {
            return new Class(this.size, this.name, this.color);
        }
    }

    private static final class Class implements Api {
        @NotNull
        private transient OptionalInt size;
        @NotNull
        private transient Optional<String> name;
        @NotNull
        private String color;

        private Class(@NotNull final OptionalInt size, @NotNull final Optional<String> name, @NotNull final String color) {
            this.size = size;
            this.name = name;
            this.color = color;
        }

        @JsonProperty("size")
        @Nullable
        public final Integer getSerializableSize() {
            return (this.size.isPresent()) ? this.size.getAsInt() : null;
        }

        @Override
        @NotNull
        public final OptionalInt getSize() {
            return this.size;
        }

        @Override
        public final void setSize(@NotNull final OptionalInt size) {
            Validation.checkParameterIsNotNull(size, "size");
            this.size = size;
        }

        @JsonProperty("name")
        @Nullable
        public final String getSerializableName() {
            return this.name.orElse(null);
        }

        @Override
        @NotNull
        public final Optional<String> getName() {
            return this.name;
        }

        @Override
        public final void setName(@NotNull final Optional<String> name) {
            Validation.checkParameterIsNotNull(name, "name");
            this.name = name;
        }

        @JsonProperty("color")
        @Override
        @NotNull
        public String getColor() {
            return this.color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Class aClass = (Class) o;

            if (!size.equals(aClass.size)) return false;
            if (!name.equals(aClass.name)) return false;
            return color.equals(aClass.color);
        }

        @Override
        public int hashCode() {
            int result = size.hashCode();
            result = 31 * result + name.hashCode();
            result = 31 * result + color.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "size=" + size +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
