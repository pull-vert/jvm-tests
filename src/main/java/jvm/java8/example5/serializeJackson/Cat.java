/*
data class Cat(api var size: nullable Int = 26, api var name: nullable String = null) is Serializable
 */

package jvm.java8.example5.serializeJackson;

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

    private Cat() { } // uninstanciable

    @JsonDeserialize(builder = Cat.Builder.class)
    public static interface Api extends Serializable {
        @NotNull
        public OptionalInt getSize();

        @NotNull
        public Optional<String> getName();

        public void setSize(@NotNull final OptionalInt size);

        public void setName(@NotNull final Optional<String> name);
    }

    @JsonPOJOBuilder(withPrefix = "withSerializable")
    public static final class Builder {
        @NotNull
        private OptionalInt size = OptionalInt.of(26);
        @NotNull
        private Optional<String> name = Optional.empty();

        public final Builder withSize(@NotNull final OptionalInt size) {
            Validation.checkParameterIsNotNull(size, "size");
            this.size = size;
            return this;
        }

        public final Builder withSerializableSize(@Nullable final Integer size) {
            this.size = (null != size) ? OptionalInt.of(size) : OptionalInt.empty();
            return this;
        }

        public final Builder withName(@NotNull final Optional<String> name) {
            Validation.checkParameterIsNotNull(name, "name");
            this.name = name;
            return this;
        }

        public final Builder withSerializableName(@Nullable final String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        public Api build() {
            return new Class(this.size, this.name);
        }
    }

    private static final class Class implements Api {
        @NotNull
        private transient OptionalInt size;
        @NotNull
        private transient Optional<String> name;

        private Class(@NotNull final OptionalInt size, @NotNull final Optional<String> name) {
            this.size = size;
            this.name = name;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Class cat = (Class) o;

            if (!size.equals(cat.size)) return false;
            return name.equals(cat.name);
        }

        @Override
        public int hashCode() {
            int result = size.hashCode();
            result = 31 * result + name.hashCode();
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
